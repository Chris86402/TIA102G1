package com.tia102g1.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CouponController {

    @Autowired
    private CouponService couponService;


    @GetMapping({"admin/coupon", "/coupon/mainPageCoupon" })
    public String mainPageCoupon(Model model) {
        List<Coupon> couponList = couponService.getAllCoupons();
        model.addAttribute("couponList", couponList);
        return "/coupon/mainPageCoupon";
    }

    /**
     * 查詢全部優惠券
     * @return
     */
    @GetMapping("coupon")
    public ResponseEntity<?> getAllCoupons(ModelMap modelMap) {
        List<Coupon> couponList = couponService.getAllCoupons();
        modelMap.addAttribute("couponList", couponList);
        return ResponseEntity.status(HttpStatus.OK).body(couponList);
    }
    /**
     * 新增優惠券
     * @param coupon
     * @return 重導回 coupon 管理首頁
     */
    @PostMapping("coupon/add")
    public String addCoupon(@Valid @ModelAttribute("coupon") Coupon coupon) {
        couponService.addCoupon(coupon);
        return "redirect:/coupon/mainPageCoupon";
    }

    /**
     * 編輯優惠券
     * @param couponId: 用來拿到要更新的 coupon
     * @return 引導到更新頁 updateCoupon.html
     */
    @GetMapping("coupon/edit/{couponId}")
    public String editingCoupon(@PathVariable Integer couponId, Model model) {
        Coupon toUpdate = couponService.getCoupon(couponId);
        model.addAttribute("couponToUpdate", toUpdate);
        return "/coupon/updateCoupon";
    }

    /**
     * 編輯優惠券
     * @param couponId: 用來拿到要更新的 coupon
     * @param coupon: 從 updateCoupon.html 傳來要更改的 coupon 資料
     * @return 引導回 coupon 管理首頁。
     */
    @PutMapping("coupon/{couponId}")
    public String updateCoupon(@Valid @PathVariable Integer couponId,
                               @ModelAttribute("coupon") Coupon coupon) {
        coupon.setLastUpdated(new Timestamp(new Date().getTime()));
        couponService.updateCoupon(coupon);
        return "redirect:/admin/coupon";
    }

    /**
     * 刪除優惠券
     * @param couponId
     * @return
     */
    @DeleteMapping("coupon/{couponId}")
    public String deleteCoupon(@PathVariable Integer couponId) {
        System.out.println("couponId = " + couponId);
        couponService.deleteCoupon(couponId);
        return "redirect:/coupon/mainPageCoupon";
    }

    /**
     * 查詢單項優惠券
     * @param couponId
     * @return
     */
    @GetMapping("coupon/{couponId}")
    public ResponseEntity<?> getCoupon(@PathVariable Integer couponId) {
        Coupon coupon = couponService.getCoupon(couponId);
        return ResponseEntity.status(HttpStatus.OK).body(coupon);
    }

    /**
     * 搜尋優惠券
     * @param searchParams
     * @return
     */

    @GetMapping("coupon/search")
    public ResponseEntity<List<Coupon>> searchCoupons(@RequestParam Map<String, String> searchParams) {
        List<Coupon> coupons = couponService.searchCoupons(searchParams);
        return ResponseEntity.ok(coupons);
    }
}
