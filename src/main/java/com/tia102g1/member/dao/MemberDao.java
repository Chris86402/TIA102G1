package com.tia102g1.member.dao;

import com.tia102g1.member.dto.ForgetPasswordRequest;
import com.tia102g1.member.dto.MemberQueryParams;
import com.tia102g1.member.dto.MemberRegisterRequest;
import com.tia102g1.member.dto.MemberUpdateDto;
import com.tia102g1.member.model.Member;

import java.util.List;


public interface MemberDao {
    /**
     * 新增一筆會員的方法
     *
     * @param memberRegisterRequest 前端傳來的要新建的會員資料
     * @return 返回的是最新會員的ID
     */
    Integer createMember(MemberRegisterRequest memberRegisterRequest);

    /**
     * 藉由會員ID查詢會員的方法
     *
     * @param memberId 要查詢的會員ID
     * @return 返回該會員的相關資料
     */
    Member getMemberById(Integer memberId);

    /**
     * 查詢所有會員的方法
     *
     * @return 返回一個包含所有會員的List
     */
    List<Member> getAll(MemberQueryParams memberQueryParams);

    /**
     * 查詢所有黑名單的方法
     *
     * @param memberQueryParams 查詢條件
     * @return 返回一個包含所有黑名單的list
     */
    List<Member> getBlockedList(MemberQueryParams memberQueryParams);

    /**
     * 藉由帳號查詢會員ID的方法
     *
     * @param account 要查詢的帳號
     * @return 該帳號的會員資料，沒有該帳號則返回null
     */
    Member getMemberByAccount(String account);

    /**
     * 查看更新密碼的是哪一個會員
     *
     * @param password 更新的密碼
     * @return 返回該會員資料
     */
    Member getMemberByUpdatedPasswordMemberId(String password);

    /**
     * 更新某會員ID資料的方法
     */
    Integer updateMember(Integer memberId, MemberUpdateDto memberUpdateDto);

    /**
     * 刪除某會員ID的方法
     *
     * @param memberId 要刪除的會員ID
     */
    Integer deleteMemberById(Integer memberId);

    /**
     * 查詢會員總數(分頁)
     * @param memberQueryParams 要查詢的會員參數
     * @return 返回查詢條件下的會員總數
     */
    Integer countMember(MemberQueryParams memberQueryParams);

    /**
     * 查詢黑名單的總數(分頁)
     * @param memberQueryParams  要查詢的黑名單參數
     * @return 返回查詢條件下的黑名單總數
     */
    Integer countBlockedMember(MemberQueryParams memberQueryParams);

    /**
     * 解除某會員的黑名單
     * @param memberId 要解除的會員ID
     * @return 解除的會員ID
     */
    Integer unblockMember(Integer memberId);

    /**
     * 藉由email查詢會員ID的方法
     * @param forgetPasswordRequest 會員的email
     * @return 返回該會員的資訊
     */
    Member getMemberByEmail(ForgetPasswordRequest forgetPasswordRequest);

    /**
     * 更新會員密碼的方法(member)
     * @param memberId 要更新密碼的會員ID
     * @param password 要更新的密碼
     * @return 返回更新密碼的會員ID
     */
    Integer updateMemberPassword(Integer memberId,String password);

}
