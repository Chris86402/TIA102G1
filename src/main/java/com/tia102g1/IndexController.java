package com.tia102g1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tia102g1.productType.model.ProductTypeService;
import com.tia102g1.productType.model.ProductTypeVO;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired
	ProductTypeService typeSvc;

	// 首頁
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/productType/listAllType")
	public String listAllType(Model model) {
		return "productType/listAllType";
	}

	@ModelAttribute("typeListData")
	protected List<ProductTypeVO> referenceListData(Model model) {
		List<ProductTypeVO> list = typeSvc.getAll();
		return list;
	}

	/* ======================= mainPage ======================= */

	// 會員資料
	@GetMapping("member/mainPageMember")
	public String mainPageMember(Model model) {
		return "member/mainPageMember";
	}
	
	// 會員黑名單
	@GetMapping("member/blockedMember")
	public String blockedMember(Model model) {
		return "member/blockedMember";
	}

	// 會員等級對照
	@GetMapping("memberLv/mainPageMemberLv")
	public String mainPageMemberLv(Model model) {
		return "memberLv/mainPageMemberLv";
	}

	// 優惠券持有紀錄
	@GetMapping("memberCoupon/mainPageMemberCoupon")
	public String mainPageMemberCoupon(Model model) {
		return "memberCoupon/mainPageMemberCoupon";
	}

	// 購物金持有紀錄
	@GetMapping("memberCoin/mainPageMemberCoin")
	public String mainPageMemberCoin(Model model) {
		return "memberCoin/mainPageMemberCoin";
	}

	// 商品類型對照
	@GetMapping("productType/mainPageProductType")
	public String mainPageProductType(Model model) {
		return "productType/mainPageProductType";
	}

//	// 商品基本資料
//	@GetMapping("productInfo/mainPageProductInfo")
//	public String mainPageProductInfo(Model model) {
//		return "productInfo/mainPageProductInfo";
//	}

	// 商品入庫紀錄
	@GetMapping("productStock/mainPageProductStock")
	public String mainPageProductStock(Model model) {
		return "productStock/mainPageProductStock";
	}

	// 商品評價紀錄
	@GetMapping("productComment/mainPageProductComment")
	public String mainPageProductComment(Model model) {
		return "productComment/mainPageProductComment";
	}

	// 最愛商品紀錄
	@GetMapping("favProduct/mainPageFavProduct")
	public String mainPageFavProduct(Model model) {
		return "favProduct/mainPageFavProduct";
	}

	// 購物車紀錄
	@GetMapping("cart/mainPageCart")
	public String mainPageCart(Model model) {
		return "cart/mainPageCart";
	}

	// 加購商品關係
	@GetMapping("addOn/mainPageAddOn")
	public String mainPageAddOn(Model model) {
		return "addOn/mainPageAddOn";
	}

	// 訂單紀錄
	@GetMapping("orderList/mainPageOrderList")
	public String mainPageOrderList(Model model) {
		return "orderList/mainPageOrderList";
	}

	// 訂單商品明細
	@GetMapping("orderListInfo/mainPageOrderListInfo")
	public String mainPageOrderListInfo(Model model) {
		return "orderListInfo/mainPageOrderListInfo";
	}

	// 促銷活動
	@GetMapping("event/mainPageEvent")
	public String mainPageEvent(Model model) {
		return "event/mainPageEvent";
	}

	// 優惠券
	@GetMapping("coupon/mainPageCoupon")
	public String mainPageCoupon(Model model) {
		return "coupon/mainPageCoupon";
	}

	// 問題類型對照
	@GetMapping("quType/mainPageQuType")
	public String mainPageQuType(Model model) {
		return "quType/mainPageQuType";
	}

	// 客服表單
	@GetMapping("csForm/mainPageCsForm")
	public String mainPageCsForm(Model model) {
		return "csForm/mainPageCsForm";
	}
	
	// 報表分析管理
	@GetMapping("report/mainPageReport")
	public String mainPageReport(Model model) {
		return "report/mainPageReport";
	}

	// 常見問題
	@GetMapping("commonAsk/mainPageCommonAsk")
	public String mainPageCommonAsk(Model model) {
		return "commonAsk/mainPageCommonAsk";
	}

	// 商品公告
	@GetMapping("news/mainPageNews")
	public String mainPageNews(Model model) {
		return "news/mainPageNews";
	}

	// 門市資訊
	@GetMapping("store/mainPageStore")
	public String mainPageStore(Model model) {
		return "store/mainPageStore";
	}

	// 縣市代碼對照
	@GetMapping("county/mainPageCounty")
	public String mainPageCounty(Model model) {
		return "county/mainPageCounty";
	}

	// 鄉鎮區代碼對照
	@GetMapping("district/mainPageDistrict")
	public String mainPageDistrict(Model model) {
		return "district/mainPageDistrict";
	}

	// 系統通知訊息
	@GetMapping("sysMsg/mainPageSysMsg")
	public String mainPageSysMsg(Model model) {
		return "sysMsg/mainPageSysMsg";
	}

	// 員工資料
	@GetMapping("staff/mainPageStaff")
	public String mainPageStaff(Model model) {
		return "staff/mainPageStaff";
	}

	//前台頁面
	//首頁
	@RequestMapping({"/","index","/index.html"})
	public String homePage() {
		return "/frontend-app/index";
	}
	//購物車
	@GetMapping("/cart-page.html")
	public String cartPage(){
		return "/frontend-app/cart-page";
	}
	//關於我們
	@GetMapping("/about-us.html")
	public String aboutUsPage(){
		return "/frontend-app/about-us";
	}
	//聯絡我們
	@GetMapping("/contact-us.html")
	public String contactUsPage(){
		return "/frontend-app/contact-us";
	}
}
