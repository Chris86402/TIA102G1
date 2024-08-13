package com.tia102g1.orderlist.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tia102g1.county.model.CountyService;
import com.tia102g1.county.model.CountyVO;
import com.tia102g1.coupon.Coupon;
import com.tia102g1.coupon.CouponService;
import com.tia102g1.dist.model.DistService;
import com.tia102g1.dist.model.DistVO;
import com.tia102g1.event.model.EventService;
import com.tia102g1.event.model.EventVO;
import com.tia102g1.member.model.Member;
import com.tia102g1.member.model.MemberService;
import com.tia102g1.orderlist.model.OrderListService;
import com.tia102g1.orderlist.model.OrderListVO;
import com.tia102g1.orderlistinfo.model.OrderListInfoService;
import com.tia102g1.orderlistinfo.model.OrderListInfoVO;

@Controller
@RequestMapping("/orderList")
public class OrderListController {

	Timestamp now = Timestamp.valueOf(LocalDateTime.now());

	@Autowired
	OrderListService orderListService;

	@Autowired
	MemberService memberService;

	@Autowired
	CouponService couponService;

	@Autowired
	EventService eventService;

	@Autowired
	DistService distService;

	@Autowired
	CountyService countyService;
	
	@Autowired
	OrderListInfoService orderListInfoService;
	

	@GetMapping({ "", "/mainPageOrderList" })
	public String referenceOrderListData(Model model) {
		List<OrderListVO> list = orderListService.getAll();
		model.addAttribute("orderListData", list);
		return "/orderList/mainPageOrderList";
	}

	@ModelAttribute("orderListData2")
	protected List<OrderListVO> referenceListData(Model model) {
		List<OrderListVO> list = orderListService.getAll();
		return list;
	}

	@ModelAttribute("memberListData")
	protected List<Member> referenceListData_member(Model model) {
		List<Member> list = memberService.getAll();
		return list;
	}

	
	@ModelAttribute("couponListData")
	protected List<Coupon> referenceListData_coupon(Model model){
		List<Coupon> list = couponService.getAllCoupons();
		return list;
	}

	@ModelAttribute("eventListData")
	protected List<EventVO> referenceListData_event(Model model) {
		List<EventVO> list = eventService.getAll();
		return list;
	}

	@ModelAttribute("distListData")
	protected List<DistVO> referenceListData_dist(Model model) {
		List<DistVO> list = distService.getAll();
		return list;
	}

	@ModelAttribute("countyListData")
	protected List<CountyVO> referenceListData_county(Model model) {
		List<CountyVO> list = countyService.getAll();
		return list;
	}
	
	@ModelAttribute("orderListInfoListData")
	protected List<OrderListInfoVO> referenceorderListInfoListListData(Model model) {
		List<OrderListInfoVO> list = orderListInfoService.getAll();
		return list;
	}
	

	@GetMapping("listOneOrderList")
	public String listOneOrderList(@RequestParam("orderListId") Integer orderListId, Model model) {
		// 查詢指定的OrderListVO
		OrderListVO orderListVO = orderListService.getOneOrderList(orderListId);
		model.addAttribute("orderListVO", orderListVO);
		
		List<OrderListInfoVO> orderListInfoList = orderListService.getOrderListInfos(orderListId);
		model.addAttribute("orderListInfoListData", orderListInfoList);

		return "/orderList/listOneOrderList";
	}

	@GetMapping("addOrderList")
	public String addOrderList(ModelMap model) {
		OrderListVO orderListVO = new OrderListVO();
		model.addAttribute("orderListVO", orderListVO);
		return "/orderList/addOrderList";
	}
	
	@PostMapping("showOrderDetails")
    public String showOrderDetails(Model model, HttpSession session) {
        String orderListId = (String) session.getAttribute("orderListId");
        List<OrderListInfoVO> orderListInfoListDataById = orderListInfoService.getOrderListInfosByOrderListId(Integer.valueOf(orderListId));
        System.out.println("");
        model.addAttribute("orderListId", orderListId);
        model.addAttribute("orderListInfoListDataById", orderListInfoListDataById);

        return "/orderList/listOneOrderList"; // 返回渲染的 Thymeleaf 模板名称
    }
		

	@PostMapping("insert")
	public String insert(@Valid OrderListVO orderListVO, BindingResult result, ModelMap model) throws IOException {

		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors(); // 取得錯誤資訊
			System.out.println(allErrors); // 印出錯誤資訊
			return "/orderList/addOrderList";
		}

		orderListVO.setOrderDt(now);
		orderListVO.setPayAmount(
				orderListVO.getOrderAmount() - orderListVO.getCouponUsedAmount() - orderListVO.getCoinUsedAmount());
		orderListVO.setDateCreated(now);
		orderListVO.setLastUpdated(now);
		orderListVO.setLastUpdatedBy(orderListVO.getCreatedBy());

		orderListService.addOrderList(orderListVO);

		List<OrderListVO> list = orderListService.getAll();

		model.addAttribute("success", "- (新增成功)");

		return "redirect:/orderList/mainPageOrderList";
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String handleMaxUploadSizeExceededException(MaxUploadSizeExceededException exc,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errorMessage", "文件大小超過最大限制 (5MB)");
		return "redirect:/orderList/addorderList";
	}

	// 修改
	@PostMapping("getOne_For_Update")
	public String getOne_For_Update(@RequestParam("orderListId") String orderListId, ModelMap model) {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		/*************************** 2.開始查詢資料 *****************************************/

		// 先把指定id的VO物件查出來並顯示,準備交給updateEvent頁面做修改
		OrderListVO orderListVO = orderListService.getOneOrderList(Integer.valueOf(orderListId));

		/*************************** 3.查詢完成,準備轉交(Send the Success view) **************/
		model.addAttribute("orderListVO", orderListVO);

		return "orderList/updateOrderList";
	}

	@PostMapping("update")
	public String update(@Valid OrderListVO orderListVO, BindingResult result, ModelMap model) throws IOException {

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/

		if (result.hasErrors()) { // 錯誤訊息result
			return "/orderList/updateOrderList";
		}
		/*************************** 2.開始修改資料 *****************************************/
		orderListVO.setLastUpdated(now);
		orderListService.updateOrderList(orderListVO); // 把更新好屬性的當前VO物件交給Service層做update

		/*************************** 3.修改完成,準備轉交(Send the Success view) **************/
		model.addAttribute("success", "- (修改成功)");
		orderListVO = orderListService.getOneOrderList(Integer.valueOf(orderListVO.getOrderListId())); // 取出剛更新完的VO物件,顯示在前端頁面上
		model.addAttribute("orderListVO", orderListVO);

		return "/orderList/listOneOrderList";
	}

	@PostMapping("listOrderListByCompositeQuery")
	public String listAllOrderList(HttpServletRequest req, Model model) {
		Map<String, String[]> map = req.getParameterMap();
		List<OrderListVO> list = orderListService.getAll(map);
		model.addAttribute("orderListData", list);
		return "/orderlist/mainPageOrderList";
	}

}
