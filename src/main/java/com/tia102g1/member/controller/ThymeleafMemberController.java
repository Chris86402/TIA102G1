package com.tia102g1.member.controller;

import com.tia102g1.county.model.CountyService;
import com.tia102g1.county.model.CountyVO;
import com.tia102g1.dist.model.DistService;
import com.tia102g1.dist.model.DistVO;
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
    @Autowired
    CountyService countyService;

    @Autowired
    DistService distService;

    /**
     * 顯示後台員工總覽主頁的控制器
     *
     * @param searchName
     * @param searchAccount
     * @param orderBy
     * @param sort
     * @param limit
     * @param offset
     * @param model
     * @return
     */
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

    /**
     * 跳轉到更新後台會員頁面的控制器
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/update/{id}")
    public String updateMemberForm(@PathVariable Integer id, Model model) {
        Member member = memberService.getMemberById(id);
        if (member == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "會員不存在");
        }
        model.addAttribute("member", member);
        return "member/update";
    }


    /**
     * 更新後台會員的控制器(後台)
     *
     * @param id              要更新的ID
     * @param memberUpdateDto 更新的參數
     * @param result          錯誤的結果
     * @param model
     * @return 更新成功後返回到會員總覽
     */
    @PostMapping("/update/{id}")
    public String updateMember(@PathVariable Integer id, @Validated @ModelAttribute("member") MemberUpdateDto memberUpdateDto, BindingResult result, Model model) {


        if (result.hasErrors()) {
            model.addAttribute("member", memberUpdateDto);
            return "member/update";  // 如果有錯誤，返回更新頁面
        }
        memberService.updateMember(id, memberUpdateDto);
        return "redirect:/member/mainPageMember"; //成功後回到 mainPageMember
    }

    /**
     * 刪除後台某筆會員資料的控制器(後台用)
     *
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deleteMember(@PathVariable Integer id) {
        memberService.deleteMemberById(id);
        return "redirect:/member/mainPageMember"; //刪除後回到 mainPageMember
    }

    /**
     * 跳轉到黑名單總覽的控制器
     *
     * @param searchName
     * @param searchAccount
     * @param orderBy
     * @param sort
     * @param limit
     * @param offset
     * @param model
     * @return
     */
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

    /**
     * 解鎖黑名單的控制器(後台用)
     *
     * @param memberId
     * @return
     */
    @GetMapping("/unblock/{memberId}")
    public String unblockMember(@PathVariable Integer memberId) {
        memberService.unblockMember(memberId);
        return "redirect:/member/mainPageBlockedMember";
    }

    /**
     * 跳轉到會員中心的控制器(前台)
     *
     * @param memberId
     * @param model
     * @return
     */
    @GetMapping("/myaccount/{memberId}")
    public String getMyAccount(@PathVariable Integer memberId, Model model) {
        Member member = memberService.getMemberById(memberId);
        if (member == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "會員不存在");
        }
        model.addAttribute("member", member);
        return "frontendapp/myaccount";
    }

    /**
     * 跳轉到更新會員資料頁面的控制器(前台)
     *
     * @param memberId
     * @param model
     * @return
     */
    @GetMapping("/myaccount/{memberId}/memberInfo")
    public String showMemberInfo(@PathVariable Integer memberId, Model model) {
        Member member = memberService.getMemberById(memberId);
        if (member == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "會員不存在");
        }
        List<CountyVO> counties = countyService.getAllCounties();
        model.addAttribute("counties", counties);
        model.addAttribute("member", member);
        return "frontendapp/memberInfo";  // 返回到編輯會員資料的頁面
    }


    /**
     * 更新會員資料的控制器(前台)
     *
     * @param memberId
     * @param memberUpdateDto
     * @param
     * @return
     */
    @PostMapping("/myaccount/{memberId}/updateMemberInfo")
    public String updateMemberInfo(@PathVariable Integer memberId,
                                   @Validated @ModelAttribute("member") MemberUpdateDto memberUpdateDto,
                                   BindingResult bindingResult,
                                   Model model) {

        if (bindingResult.hasErrors()) {
            // 如果有驗證錯誤，將錯誤訊息和當前輸入的數據返回到原頁面
            List<CountyVO> counties = countyService.getAllCounties();
            model.addAttribute("counties", counties);
            model.addAttribute("member", memberUpdateDto);
            return "frontendapp/memberInfo";  // 返回更新頁面並顯示錯誤訊息
        }

        // 如果沒有錯誤，執行更新操作並重定向到會員資料頁面
        memberService.updateMember(memberId, memberUpdateDto);
        return "redirect:/member/myaccount/" + memberId;
    }


    /**
     * 獲取所有縣市的API
     * @return
     */
    @GetMapping("/api/counties")
    @ResponseBody
    public List<CountyVO> getAllCounties() {
        return countyService.getAllCounties();
    }

    /**
     * 根據縣市代碼獲取對應的鄉鎮市區
     * @param cntCode
     * @return
     */
    @GetMapping("/api/districts")
    @ResponseBody
    public List<DistVO> getDistrictsByCountyCode(@RequestParam("cntCode") Integer cntCode) {
        return distService.getDistrictsByCountyCode(cntCode);
    }
}
