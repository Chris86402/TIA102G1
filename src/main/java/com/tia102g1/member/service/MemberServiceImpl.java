package com.tia102g1.member.service;

import com.tia102g1.member.constant.AccountStatus;
import com.tia102g1.member.dao.MemberDao;
import com.tia102g1.member.dto.*;
import com.tia102g1.member.model.Member;
import org.apache.bcel.generic.RETURN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class MemberServiceImpl implements MemberService {
    //添加LOG，制式化寫法
    private final static Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailForForgetPassword emailForForgetPassword;

    @Override

    public Integer register(MemberRegisterRequest memberRegisterRequest) {
        //為什麼service取名register而不是createMember?，因service層會添加其他額外判斷是否register，而不單單只是create而已
        //檢查帳號
        //註冊account不可重複，先藉由getMemberByAccount判斷是否有查詢到該帳號，有查到則代表該帳號已經註冊過
        Member member = memberDao.getMemberByAccount(memberRegisterRequest.getAccount());

        //判斷不是null，代表該帳號已經註冊過了
        if (member != null) {
            log.warn("該帳號已經被註冊");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        //使用 BCrypt 加密密碼
        String hashedPassword = passwordEncoder.encode(memberRegisterRequest.getPassword());
        //將加密過後的密碼set到該會員資料
        memberRegisterRequest.setPassword(hashedPassword);
        //創建帳號
        return memberDao.createMember(memberRegisterRequest);
    }

    @Override
    public Member login(MemberLoginRequest memberLoginRequest) {
        Member member = memberDao.getMemberByAccount(memberLoginRequest.getAccount());

        //登入失敗情況
        if (member == null) {
            log.warn("該帳號不存在");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return member;
        //將使用者輸入的密碼先利用MD5加密，再將此密碼和資料庫的會員密碼比對是否相同
//        String hashedPassword = DigestUtils.md5DigestAsHex(memberLoginRequest.getPassword().getBytes());
//
//        //判斷該帳號所輸入的密碼是否正確
//        if (member.getPassword().equals(hashedPassword)) {
//            return member;
//        } else {
//            log.warn("輸入的密碼錯誤");
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
    }

    @Override
    public Member getMemberById(Integer memberId) {
        return memberDao.getMemberById(memberId);
    }

    @Override
    public List<Member> getAll(MemberQueryParams memberQueryParams) {
        return memberDao.getAll(memberQueryParams);
    }

    @Override
    public List<Member> getBlockedList(MemberQueryParams memberQueryParams) {
        return memberDao.getBlockedList(memberQueryParams);
    }

    @Override
    public Integer updateMember(Integer memberId, MemberUpdateDto memberUpdateDto) {
        Member member = memberDao.getMemberByUpdatedPasswordMemberId(memberUpdateDto.getPassword());

        //將更新過後的密碼加密
        String hashedPassword = passwordEncoder.encode(memberUpdateDto.getPassword());
        memberUpdateDto.setPassword(hashedPassword);

        //如果有設置黑名單的話，要將停權日期更新
        if (memberUpdateDto.getStatus().equals(AccountStatus.BLOCKED.getStatus())) {
            Timestamp now = new Timestamp(System.currentTimeMillis());
            memberUpdateDto.setBlockedTime(now);
        }

        return memberDao.updateMember(memberId, memberUpdateDto);
    }

    @Override
    public Integer deleteMemberById(Integer memberId) {
        return memberDao.deleteMemberById(memberId);
    }

    @Override
    public Integer countMember(MemberQueryParams memberQueryParams) {
        return memberDao.countMember(memberQueryParams);
    }

    @Override
    public Integer countBlockedMember(MemberQueryParams memberQueryParams) {
        return memberDao.countBlockedMember(memberQueryParams);
    }

    @Override
    public Integer unblockMember(Integer memberId) {

        return memberDao.unblockMember(memberId);
    }

    @Override
    public Member getMemberByAccount(String account) {
        Member member = memberDao.getMemberByAccount(account);
        if (member == null) {
            throw new UsernameNotFoundException("找不到該帳號: " + account);

        }
        return memberDao.getMemberByAccount(account);
    }

    @Override
    public Member getMemberByEmail(ForgetPasswordRequest forgetPasswordRequest) {

        Member member = memberDao.getMemberByEmail(forgetPasswordRequest);
        if (member == null) {
            log.warn("信箱 {} 不存在 ", forgetPasswordRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }
        return memberDao.getMemberByEmail(forgetPasswordRequest);
    }

    @Override
    public void forgetPassword(ForgetPasswordRequest forgetPasswordRequest) {

        // 1. 檢查使用者輸入的email是否存在
        Member member = memberDao.getMemberByEmail(forgetPasswordRequest);
        if (member == null) {
            log.warn("輸入的信箱 {} 不存在", forgetPasswordRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "您輸入的信箱不存在");
        }

        // 2. 生成隨機密碼
        String newPassword = generateRandomPassword(6);

        // 3. 將新隨機密碼的加密並更新到該會員的資料庫
        String hashedPassword = passwordEncoder.encode(newPassword);
        member.setPassword(hashedPassword);
        memberDao.updateMemberPassword(member.getMemberId(), member.getPassword());

        // 4. 發送生成的隨機密碼到使用者的信箱
        String subject = "忘記密碼通知";
        String content = "您的新密碼是，" + newPassword + "，請使用該密碼登入，並修改您的密碼。";
        emailForForgetPassword.sendPlainText(forgetPasswordRequest.getEmail(), subject, content);
    }



    /**
     * 隨機生成密碼的方法，用於忘記密碼的功能
     *
     * @param length 預計隨機生成幾個數字
     * @return 生成的密碼
     */
    private String generateRandomPassword(int length) {
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }

}