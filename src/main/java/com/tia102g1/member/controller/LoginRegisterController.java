package com.tia102g1.member.controller;

import com.tia102g1.member.dto.ForgetPasswordRequest;
import com.tia102g1.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class LoginRegisterController {
    @Autowired
    MemberService memberService;

    //登入
    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    //忘記密碼
    @GetMapping("/forgetPassword")
    public String forgetPassword(Model model) {
        model.addAttribute("forgetPasswordRequest", new ForgetPasswordRequest());
        return "frontendapp/forgetpassword";
    }


    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@Validated @ModelAttribute("forgetPasswordRequest") ForgetPasswordRequest forgetPasswordRequest,
                                            BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("請輸入有效的Email格式");
        }

        try {
            memberService.forgetPassword(forgetPasswordRequest);
            return ResponseEntity.ok("已將新密碼寄到您的信箱");
        } catch (ResponseStatusException ex) {
            return ResponseEntity.badRequest().body(ex.getReason());
        }
    }
}
