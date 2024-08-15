package com.tia102g1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tia102g1.coupon.Coupon;
import com.tia102g1.coupon.CouponService;
import com.tia102g1.news.model.NewsService;
import com.tia102g1.news.model.NewsVO;

@Controller
public class FrontendController {
	
	@Autowired
	NewsService newsSvc;
	
	@Autowired
	CouponService couponService;

	/* ======================= 前台使用者頁面 ======================= */
	// 首頁
	@RequestMapping({ "/index", "/index.html" })
	public String frontendIndex(Model model) {
		return "/frontendapp/index";
	}
	
	@ModelAttribute("newsListData")
	protected List<NewsVO> referenceNewsListData(Model model) {
		List<NewsVO> list = newsSvc.getAll();
		return list;
	}
	
	@ModelAttribute("couponList")
    public List<Coupon> getAllCoupons(ModelMap modelMap) {
        List<Coupon> couponList = couponService.getAllCoupons();
        return couponList;
	}

	/* ====== 會員 ====== */
//	// 註冊 ===註冊登入controller放在login中====
//	@GetMapping({ "/register", "/register.html" })
//	public String frontendRegister(Model model) {
//		return "/frontendapp/register";
//	}
	// 登入
//	@GetMapping({ "/login", "/login.html" })
//	public String frontendLoginSignup(Model model) {
//		return "/frontendapp/login";
//	}

	// 我的最愛
	@GetMapping({ "/favproduct", "/favProduct.html" })
	public String frontendFavProduct(Model model) {
		return "/frontendapp/favProduct";
	}

//	// 會員資料
//	@GetMapping({ "/memberinfo", "/memberInfo.html" })
//	public String frontendMemberInfo(Model model) {
//		return "/frontendapp/memberInfo";
//	}

	/* ====== 購物流程 ====== */
	// 商品總覽
//	@GetMapping({ "/productcategory", "/productCategory.html" })
//	public String frontendCategory(Model model) {
//		return "/frontendapp/productCategory";
//	}

	// 商品詳細資訊
	@GetMapping({ "/productdetails", "/productDetails.html" })
	public String frontendProductDetail(Model model) {
		return "/frontendapp/productDetails";
	}

	// 購物車
	@GetMapping({ "/cart", "/cart.html" })
	public String frontendShoppingCart(Model model) {
		return "/frontendapp/cart";
	}

	/* ====== 結帳付款 ====== */
	// 填寫付款資訊
	@GetMapping({ "/checkout", "/checkout.html" })
	public String frontendCheckout(Model model) {
		return "/frontendapp/checkout";
	}

	// 訂單成立確認
	@GetMapping({ "/orderconfirmation", "/orderConfirmation.html" })
	public String frontendOrderConfirm(Model model) {
		return "/frontendapp/orderConfirmation";
	}

	/* ====== 常見問題 ====== */
	@GetMapping({ "/commonask", "/commonAsk.html" })
	public String frontendCommonAsk(Model model) {
		return "/frontendapp/commonAsk";
	}

	/* ====== 客服 ====== */
	// 聯絡我們
	@GetMapping({ "/contactus", "/contactUs.html" })
	public String frontendContactUs(Model model) {
		return "/frontendapp/contactUs";
	}

	/* ====== 門市資訊 ====== */
	@GetMapping({ "/store", "/store.html" })
	public String frontendStore(Model model) {
		return "/frontendapp/store";
	}
	
	
	// ===================================================
	// 關於我們 (有空再做)
	@GetMapping({ "/aboutus", "/aboutUs.html" })
	public String frontendAboutUs(Model model) {
		return "/frontendapp/aboutUs";
	}

	// 測試頁
	@GetMapping({ "/sample" })
	public String frontendSample(Model model) {
		return "/frontendapp/sample";
	}
}
