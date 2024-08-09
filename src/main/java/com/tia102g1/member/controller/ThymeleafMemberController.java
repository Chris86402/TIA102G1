package com.tia102g1.member.controller;

import com.tia102g1.member.dto.MemberQueryParams;
import com.tia102g1.member.dto.MemberUpdateDto;
import com.tia102g1.member.model.Member;
import com.tia102g1.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import util.Page;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@Controller
@RequestMapping("/member")
public class ThymeleafMemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/mainPageMember")
    public String getMembers(
            @RequestParam(required = false) String searchName,
            @RequestParam(required = false) String searchAccount,
            @RequestParam(defaultValue = "MEMBERID") String orderBy,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "100") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset,
            Model model) {

        // 設置查詢參數
        MemberQueryParams memberQueryParams = new MemberQueryParams();
        memberQueryParams.setSearchName(searchName);
        memberQueryParams.setSearchAccount(searchAccount);
        memberQueryParams.setOrderBy(orderBy);
        memberQueryParams.setSort(sort);
        memberQueryParams.setLimit(limit);
        memberQueryParams.setOffset(offset);

        // 查詢會員列表和總數
        List<Member> memberList = memberService.getAll(memberQueryParams);
        Integer total = memberService.countMember(memberQueryParams);

        // 打印日誌確認 memberList 的內容
        System.out.println("會員列表: " + memberList);

        // 分頁物件設置
        Page<Member> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(memberList);

        // 添加屬性到模型
        model.addAttribute("memberList", memberList);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchAccount", searchAccount);

        return "member/mainPageMember";

    }

    @GetMapping("/update/{id}")
    public String updateMemberForm(@PathVariable Integer id, Model model) {
        Member member = memberService.getMemberById(id);
        if (member == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "會員不存在");
        }
        model.addAttribute("member", member);
        return "member/update";
    }

    @PostMapping("/update/{id}")
    public String updateMember(@PathVariable Integer id, @Validated @ModelAttribute("member") MemberUpdateDto memberUpdateDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("member", memberUpdateDto);
            return "member/update";  // 如果有錯誤，返回更新頁面
        }
        memberService.updateMember(id, memberUpdateDto);
        return "redirect:/member/mainPageMember"; //成功後回到 mainPageMember
    }

    @GetMapping("/delete/{id}")
    public String deleteMember(@PathVariable Integer id) {
        memberService.deleteMemberById(id);
        return "redirect:/member/mainPageMember"; //刪除後回到 mainPageMember
    }

    @GetMapping("/mainPageBlockedMember")
    public String getBlockedMembers(
            @RequestParam(required = false) String searchName,
            @RequestParam(required = false) String searchAccount,
            @RequestParam(defaultValue = "MEMBERID") String orderBy,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "100") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset,
            Model model) {

        // 設置查詢參數
        MemberQueryParams memberQueryParams = new MemberQueryParams();
        memberQueryParams.setOrderBy(orderBy);
        memberQueryParams.setSort(sort);
        memberQueryParams.setLimit(limit);
        memberQueryParams.setOffset(offset);

        // 查詢會員列表和總數
        List<Member> blockedList = memberService.getBlockedList(memberQueryParams);
        Integer total = memberService.countBlockedMember(memberQueryParams);

        // 分頁物件設置
        Page<Member> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(blockedList);


        // 添加屬性到模型
        model.addAttribute("blockedList", blockedList);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchAccount", searchAccount);

        return "member/mainPageBlockedMember";
    }

    @GetMapping("/unblock/{memberId}")
    public String unblockMember(@PathVariable Integer memberId) {
        memberService.unblockMember(memberId);
        return "redirect:/member/mainPageBlockedMember";
    }


}
