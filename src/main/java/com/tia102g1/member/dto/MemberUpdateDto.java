package com.tia102g1.member.dto;

import com.tia102g1.member.constant.AccountStatus;

import javax.persistence.Id;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.sql.Timestamp;

public class MemberUpdateDto implements Serializable {
    @Id
    Integer memberId;

    @NotNull
    Integer memberLvId = 1;
    Integer staffId;
    @NotNull
    String password;
    @NotNull
    @Size(min = 2, max = 10, message = "名字必須在2-5個字元之間")
    String name;
    @NotNull
    @Pattern(regexp = "^09\\d{8}$", message = "輸入錯誤，請輸入09+末8碼")
    String phone;
    @NotNull
    @Email(message = "請輸入正確的Email格式")
    String email;
    @NotNull
    Integer cntCode;
    @NotNull
    Integer distCode;
    @NotBlank
    String address;
    @NotNull
    Integer accumulate = 0;
    @NotNull
    Integer coinBalance = 0;
    @NotNull
    Integer noShow = 0;
    String cardHolder;
    String cardNumber;
    Integer cardYY;
    Integer cardMM;
    String cardVerifyCode;
    @NotNull
    AccountStatus status;
    Timestamp blockedTime;
    String blockedReason;
    @NotNull
    String lastUpdatedBy;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getMemberLvId() {
        return memberLvId;
    }

    public void setMemberLvId(Integer memberLvId) {
        this.memberLvId = memberLvId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCntCode() {
        return cntCode;
    }

    public void setCntCode(Integer cntCode) {
        this.cntCode = cntCode;
    }

    public Integer getDistCode() {
        return distCode;
    }

    public void setDistCode(Integer distCode) {
        this.distCode = distCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAccumulate() {
        return accumulate;
    }

    public void setAccumulate(Integer accumulate) {
        this.accumulate = accumulate;
    }

    public Integer getCoinBalance() {
        return coinBalance;
    }

    public void setCoinBalance(Integer coinBalance) {
        this.coinBalance = coinBalance;
    }

    public Integer getNoShow() {
        return noShow;
    }

    public void setNoShow(Integer noShow) {
        this.noShow = noShow;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCardYY() {
        return cardYY;
    }

    public void setCardYY(Integer cardYY) {
        this.cardYY = cardYY;
    }

    public Integer getCardMM() {
        return cardMM;
    }

    public void setCardMM(Integer cardMM) {
        this.cardMM = cardMM;
    }

    public String getCardVerifyCode() {
        return cardVerifyCode;
    }

    public void setCardVerifyCode(String cardVerifyCode) {
        this.cardVerifyCode = cardVerifyCode;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Timestamp getBlockedTime() {
        return blockedTime;
    }

    public void setBlockedTime(Timestamp blockedTime) {
        this.blockedTime = blockedTime;
    }

    public String getBlockedReason() {
        return blockedReason;
    }

    public void setBlockedReason(String blockedReason) {
        this.blockedReason = blockedReason;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
