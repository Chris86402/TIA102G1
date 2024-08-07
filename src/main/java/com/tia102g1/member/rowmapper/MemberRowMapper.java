package com.tia102g1.member.rowmapper;

import com.tia102g1.member.constant.AccountStatus;
import com.tia102g1.member.model.Member;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRowMapper implements RowMapper<Member> {
    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
        //將資料庫的數據取出，並將數據轉為java object
        Member member = new Member();
        member.setMemberId(rs.getInt("MEMBERID"));
        member.setMemberLvId(rs.getInt("MEMBERLVID"));
        member.setStaffId(rs.getInt("STAFFID"));
        member.setAccount(rs.getString("ACCOUNT"));
        member.setPassword(rs.getString("PASSWORD"));
        member.setName(rs.getString("NAME"));
        member.setBirthDt(rs.getDate("BIRTHDT"));
        member.setPhone(rs.getString("PHONE"));
        member.setEmail(rs.getString("EMAIL"));
        member.setCntCode(rs.getInt("CNTCODE"));
        member.setDistCode(rs.getInt("DISTCODE"));
        member.setAddress(rs.getString("ADDRESS"));
        member.setAccumulate(rs.getInt("ACCUMULATE"));
        member.setCoinBalance(rs.getInt("COINBALANCE"));
        member.setJoinDate(rs.getDate("JOINDATE"));
        member.setNoShow(rs.getInt("NOSHOW"));
        member.setCardHolder(rs.getString("CARDHOLDER"));
        member.setCardNumber(rs.getString("CARDNUMBER"));
        member.setCardYY(rs.getInt("CARDYY"));
        member.setCardMM(rs.getInt("CARDMM"));
        member.setCardVerifyCode(rs.getString("CARDVERIFYCODE"));

        int accountStatus = rs.getInt("STATUS");
        AccountStatus status = AccountStatus.getStatus(accountStatus);
        member.setStatus(status);

//        member.setStatus(AccountStatus.getStatus(rs.getInt("STATUS")));
//        member.setStatus(rs.getInt("STATUS")); 沒有用enum這樣寫

        member.setBlockedTime(rs.getTimestamp("BLOCKEDTIME"));
        member.setBlockedReason(rs.getString("BLOCKEDREASON"));
        member.setCreatedBy(rs.getString("CREATEDBY"));
        member.setDateCreated(rs.getTimestamp("DATECREATED"));
        member.setLastUpdatedBy(rs.getString("LASTUPDATEDBY"));
        member.setLastUpdated(rs.getTimestamp("LASTUPDATED"));
        return member;
    }
}
