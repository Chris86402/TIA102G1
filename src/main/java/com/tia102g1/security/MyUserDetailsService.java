package com.tia102g1.security;

import com.tia102g1.member.constant.AccountStatus;
import com.tia102g1.member.dao.MemberDao;
import com.tia102g1.member.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MemberDao memberDao;


    @Override
    //此方法是將使用者輸入的帳號密碼，從資料庫查詢這一筆數據，並且回傳給spring security
    //username泛指帳號
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //從資料庫中查詢Member的數據

        Member member = memberDao.getMemberByAccount(username);
        if (member == null) {
            //自定義異常
            // Spring Security 的默認會將 UsernameNotFoundException 包裝成 BadCredentialsException，以防止洩露。
            throw new UsernameNotFoundException("找不到該帳號: " + username);

        } else {

//            if (member.getStatus().equals((AccountStatus.BLOCKED))) {
//                System.out.println("您為黑名單，無法登入");
//            } else if (member.getStatus().equals(AccountStatus.NORMAL)) {
//                System.out.println("可以正常登入");
//            }

            String memberAccount = member.getAccount();
            String memberPassword = member.getPassword();

            // 權限部分，先不用管
            List<GrantedAuthority> authorities = new ArrayList<>();

            // 轉換成 Spring Security 指定的 User 格式
            return new User(memberAccount, memberPassword, authorities);
        }


    }
}
