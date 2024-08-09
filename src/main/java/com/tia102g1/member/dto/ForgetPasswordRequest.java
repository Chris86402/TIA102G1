package com.tia102g1.member.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ForgetPasswordRequest {

    @Email(message = "請輸入正確的Email格式")
    @NotBlank
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
