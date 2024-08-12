package com.tia102g1.orderlistinfo.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tia102g1.orderlist.model.OrderListService;
import com.tia102g1.orderlist.model.OrderListVO;
import com.tia102g1.orderlistinfo.model.OrderListInfoService;
import com.tia102g1.productinfo.model.ProductInfoServiceS;
import com.tia102g1.producttype.model.ProductTypeVO;
import com.tia102g1.orderlistinfo.model.OrderListInfoVO;

@Controller
@RequestMapping("/orderListInfo")
public class OrderListInfoController {

	Timestamp now = Timestamp.valueOf(LocalDateTime.now());

	@Autowired
	OrderListInfoService orderListInfoService;
	
	@Autowired
	OrderListService orderListService;
	
	@Autowired
	ProductInfoServiceS productInfoServiceS;
	
	@GetMapping({"", "/mainPageOrderListInfo"})
	public String referenceOrderListInfoListData(Model model) {
		List<OrderListInfoVO> list = orderListInfoService.getAll();
		model.addAttribute("orderListInfoListData", list);
		return "/orderListInfo/mainPageOrderListInfo";
	}
	
	@ModelAttribute("orderListInfoListData")
	protected List<OrderListInfoVO> referenceorderListInfoListListData(Model model) {
		List<OrderListInfoVO> list = orderListInfoService.getAll();
		return list;
	}
	
	@GetMapping("addOrderListInfo")
	public String addOrderListInfo(ModelMap model) {
		OrderListInfoVO orderListInfoVO = new OrderListInfoVO();
		model.addAttribute("orderListInfoVO", orderListInfoVO);
		return "/orderListInfo/addOrderListInfo";
	}
	
	@PostMapping("insert")
	public String insert(@Valid OrderListInfoVO orderListInfoVO, BindingResult result, ModelMap model) throws IOException{
		
		if(result.hasErrors()) {
			return "/orderListInfo/addOrderListInfo";
		}
		
		orderListInfoVO.setDateCreated(now);
		orderListInfoVO.setLastUpdated(now);		
		orderListInfoVO.setLastUpdatedBy(orderListInfoVO.getCreatedBy());
		
		orderListInfoService.addOrderListInfo(orderListInfoVO);
		
		List<OrderListInfoVO> list = orderListInfoService.getAll();
		
		model.addAttribute("orderListInfoListData", list);
		model.addAttribute("success", "- (新增成功)");
		return "redirect:/orderListInfo/mainPageOrderListInfo";
	}
	
	// 修改
		@PostMapping("getOne_For_Update")
		public String getOne_For_Update(@RequestParam("orderListInfoId") String orderListInfoId, ModelMap model) {
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
			/*************************** 2.開始查詢資料 *****************************************/

			// 先把指定id的VO物件查出來並顯示,準備交給updateEvent頁面做修改
			OrderListInfoVO orderListInfoVO = orderListInfoService.getOneOrderListInfo(Integer.valueOf(orderListInfoId));					

			/*************************** 3.查詢完成,準備轉交(Send the Success view) **************/
			model.addAttribute("orderListInfoVO", orderListInfoVO);

			return "/orderListInfo/updateOrderListInfo";
		}
		
		@PostMapping("update")
		public String update(@Valid OrderListInfoVO orderListInfoVO, BindingResult result, ModelMap model) throws IOException {
			
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
			
			if (result.hasErrors()) { //錯誤訊息result
				return "/orderListInfo/updateOrderListInfo";
			}
			/*************************** 2.開始修改資料 *****************************************/
			orderListInfoVO.setLastUpdated(now);
			orderListInfoService.updateOrderListInfo(orderListInfoVO); //把更新好屬性的當前VO物件交給Service層做update

			/*************************** 3.修改完成,準備轉交(Send the Success view) **************/
			model.addAttribute("success", "- (修改成功)");
			orderListInfoVO = orderListInfoService.getOneOrderListInfo(Integer.valueOf(orderListInfoVO.getOrderListInfoId())); //取出剛更新完的VO物件,顯示在前端頁面上
			model.addAttribute("orderListInfoVO", orderListInfoVO);
				
			return "/orderListInfo/listOneOrderListInfo";
		}
}
