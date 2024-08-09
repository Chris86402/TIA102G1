package com.tia102g1.member.controller;

import com.tia102g1.member.dto.*;
import com.tia102g1.member.model.Member;
import com.tia102g1.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import util.Page;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/members/register")
    public ResponseEntity<Member> register(@RequestBody
                                           @Valid MemberRegisterRequest memberRegisterRequest) {
        //藉由Keyholder方法返回最新一筆生成的會員id
        Integer memberid = memberService.register(memberRegisterRequest);
        //將生成的會員id利用getmemberId方法返回完整的會員資料
        Member member = memberService.getMemberById(memberid);

        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    @PostMapping("/members/login")
    //藉由memberLoginRequest判斷使用者的帳密是否能夠正確登入
    public ResponseEntity<Member> login(@RequestBody @Valid MemberLoginRequest memberLoginRequest) {

        Member member = memberService.login(memberLoginRequest);

        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<Member> getMemberId(@PathVariable Integer memberId) {
        Member member = memberService.getMemberById(memberId);

        if (member != null) {
            return ResponseEntity.status(HttpStatus.OK).body(member);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @GetMapping("/members")
    public ResponseEntity<Page<Member>> getAll(
            //查詢條件
            @RequestParam(required = false) String searchName,
            @RequestParam(required = false) String searchAccount,
            //排序Sorting
            @RequestParam(defaultValue = "MEMBERID") String orderBy,
            @RequestParam(defaultValue = "asc") String sort,
            //分頁Pagination
            @RequestParam(defaultValue = "3") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ) {
        //直接新增一個memberQueryParams，裡面放查詢條件的參數。以後要新增查詢條件就直接在這裏面新增就好
        //不需要再從service、dao層一路修改
        MemberQueryParams memberQueryParams = new MemberQueryParams();
        memberQueryParams.setSearchName(searchName);
        memberQueryParams.setSearchAccount(searchAccount);
        memberQueryParams.setOrderBy(orderBy);
        memberQueryParams.setSort(sort);
        memberQueryParams.setLimit(limit);
        memberQueryParams.setOffset(offset);
        //取得memberList
        List<Member> memberList = memberService.getAll(memberQueryParams);
        //取得member總數
        Integer total = memberService.countMember(memberQueryParams);

        //分頁
        Page<Member> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(memberList);

        //當前端請求/members就會消耗資源，不管getAll是否查詢到/members這個資源都是存在的(就算查不到)
        //反之，查詢特定ID商品，/members/{memberId}，可能會因為是null而沒有這個資源
        return ResponseEntity.status(HttpStatus.OK).body(page);

    }

    @PutMapping("/members/{memberId}")
    public Integer updateMember(@PathVariable Integer memberId,
                                @RequestBody @Valid MemberUpdateDto memberUpdateDto) {
        return memberService.updateMember(memberId, memberUpdateDto);

    }

    @DeleteMapping("/members/{memberId}")
    public Integer deleteMemberById(@PathVariable Integer memberId) {
        return memberService.deleteMemberById(memberId);
    }

    @GetMapping("/blocked")
    public ResponseEntity<Page<Member>> getBlockedList(

            //排序Sorting
            @RequestParam(defaultValue = "MEMBERID") String orderBy,
            @RequestParam(defaultValue = "asc") String sort,
            //分頁Pagination
            @RequestParam(defaultValue = "3") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset) {
        MemberQueryParams memberQueryParams = new MemberQueryParams();
        memberQueryParams.setOrderBy(orderBy);
        memberQueryParams.setSort(sort);
        memberQueryParams.setLimit(limit);
        memberQueryParams.setOffset(offset);
        //取得blockedList
        List<Member> blockedList = memberService.getBlockedList(memberQueryParams);
        //取得blockedMember總數
        Integer total = memberService.countBlockedMember(memberQueryParams);
        //分頁
        Page<Member> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(blockedList);


        //當前端請求/members就會消耗資源，不管getAll是否查詢到/members這個資源都是存在的(就算查不到)
        //反之，查詢特定ID商品，/members/{memberId}，可能會因為是null而沒有這個資源
        return ResponseEntity.status(HttpStatus.OK).body(page);

    }

    @PutMapping("/unblock/{memberId}")
    public Integer unblockMember(@PathVariable Integer memberId) {

        return memberService.unblockMember(memberId);
    }

    @PutMapping("/forgotPassword")
    public ResponseEntity<Member> forgetPassword(
            @RequestBody @Valid ForgetPasswordRequest forgetPasswordRequest) {

        Member member = memberService.getMemberByEmail(forgetPasswordRequest);

        return ResponseEntity.status(HttpStatus.OK).body(member);

    }

}
