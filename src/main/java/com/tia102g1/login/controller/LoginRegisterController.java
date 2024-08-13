package com.tia102g1.login.controller;

import com.tia102g1.county.model.CountyService;
import com.tia102g1.county.model.CountyVO;
import com.tia102g1.dist.model.DistService;
import com.tia102g1.dist.model.DistVO;
import com.tia102g1.member.dto.ForgetPasswordRequest;
import com.tia102g1.member.dto.MemberRegisterRequest;
import com.tia102g1.member.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class LoginRegisterController {
    @Autowired
    MemberService memberService;
    @Autowired
    CountyService countyService;
    @Autowired
    DistService distService;
    private static final Logger log = LoggerFactory.getLogger(LoginRegisterController.class);


    //登入
    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    //顯示忘記密碼頁面
    @GetMapping("/forgetPassword")
    public String forgetPassword(Model model) {
        model.addAttribute("forgetPasswordRequest", new ForgetPasswordRequest());
        return "frontendapp/forgetpassword";
    }


    //忘記密碼的API
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

    // 顯示註冊頁面並傳遞縣市資料
    @GetMapping("/register")
    public String showRegisterPage(Model model, MemberRegisterRequest memberRegisterRequest) {
        List<CountyVO> counties = countyService.getAllCounties();
        model.addAttribute("counties", counties);
        model.addAttribute("memberRegisterRequest", memberRegisterRequest);

        return "frontendapp/register";
    }


    // 獲取所有縣市的API
    @GetMapping("/api/counties")
    @ResponseBody
    public List<CountyVO> getAllCounties() {
        return countyService.getAllCounties();
    }

    // 根據縣市代碼獲取對應的鄉鎮市區
    @GetMapping("/api/districts")
    @ResponseBody
    public List<DistVO> getDistrictsByCountyCode(@RequestParam("cntCode") Integer cntCode) {
        return distService.getDistrictsByCountyCode(cntCode);
    }

    // 處理註冊請求
    @PostMapping("/register")
    public String registerMember(@Validated @ModelAttribute("memberRegisterRequest") MemberRegisterRequest memberRegisterRequest,
                                 BindingResult result, Model model) {
        // 檢查表單驗證錯誤
        if (result.hasErrors()) {
            List<CountyVO> counties = countyService.getAllCounties();
            model.addAttribute("counties", counties);
            return "frontendapp/register";
        }
        try {
            // 調用服務層方法來保存會員資料
            memberService.register(memberRegisterRequest);
        } catch (ResponseStatusException ex) {
            // 如果捕捉到的例外是帳號或信箱重複，返回錯誤訊息
            String reason = ex.getReason();
            if (reason != null) {
                if (reason.contains("帳號")) {
                    model.addAttribute("accountError", reason);
                }
                if (reason.contains("信箱")) {
                    model.addAttribute("emailError", reason);
                }
            }
            List<CountyVO> counties = countyService.getAllCounties();
            model.addAttribute("counties", counties);
            return "frontendapp/register";
        }
        // 註冊成功後，重定向到成功頁面
        model.addAttribute("registrationSuccess", true);
        return "redirect:/login";
    }
}