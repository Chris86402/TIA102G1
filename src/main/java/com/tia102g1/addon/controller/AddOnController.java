package com.tia102g1.addon.controller;

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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tia102g1.addon.model.AddOn;
import com.tia102g1.addon.model.AddOnService;
import com.tia102g1.orderlistinfo.model.OrderListInfoVO;
import com.tia102g1.productcomment.model.ProductCommentVO;
import com.tia102g1.productinfo.entity.ProductInfo;
import com.tia102g1.productinfo.model.ProductInfoServiceS;

@Controller
@RequestMapping("/addOn")
public class AddOnController {
	
	Timestamp now = Timestamp.valueOf(LocalDateTime.now());
	
	@Autowired
	AddOnService addOnService;
	
	@Autowired
	ProductInfoServiceS productInfoServiceS;
	
	@GetMapping({"", "/mainPageAddOn"})
	public String referenceAddOnListData(Model model) {
		List<AddOn> list = addOnService.getAll();
		model.addAttribute("addOnListData", list);
		return "/addOn/mainPageAddOn";
	}
	
	@ModelAttribute("productInfoListData")
	protected List<ProductInfo> referenceListData(Model model){
		List<ProductInfo> list = productInfoServiceS.getAll();
		return list;
	}
	
	@GetMapping("addAddOn")
	public String addAddOn(ModelMap model) {
		AddOn addOn = new AddOn();
		model.addAttribute("addOn",addOn);
		return "/addOn/addAddOn";
	}
	
	@PostMapping("listAddOn_byMainProId")
	public String listProIdAddOn(@RequestParam("productInfoMain") String productInfoMain, Model model) {
		List<AddOn> list = addOnService.getByProductId(Integer.valueOf(productInfoMain));
		model.addAttribute("addOnListData", list);
		return "/addOn/mainPageAddOn";
	}
	
	@PostMapping("listAddOn_byStatus")
	public String listStatusAddOn(@RequestParam("status") String status, Model model) {
		List<AddOn> list = addOnService.getByStatus(Integer.valueOf(status));
		model.addAttribute("addOnListData", list);
		return "/addOn/mainPageAddOn";
	}
	
	@PostMapping("insert")
	public String insert(@Valid AddOn addOn, BindingResult result, ModelMap model) throws IOException{
		
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors(); // 取得錯誤資訊
	        System.out.println(allErrors); // 印出錯誤資訊
			return "/addOn/mainPageAddOn";
		}
		
		if (addOn.getDateCreated() == null) {
	        addOn.setDateCreated(new Timestamp(System.currentTimeMillis()));
	    }
	    
	    if (addOn.getLastUpdated() == null) {
	        addOn.setLastUpdated(new Timestamp(System.currentTimeMillis()));
	    }
		
//		addOn.setDateCreated(now);
//		addOn.setLastUpdated(now);		
//		addOn.setLastUpdatedBy(addOn.getCreatedBy());
		
		addOnService.addAddOn(addOn);
		
		List<AddOn> list = addOnService.getAll();
		
		model.addAttribute("addOnListData", list);
		model.addAttribute("success", "- (新增成功)");
		return "redirect:/addOn/mainPageAddOn";
	}
	
	
	@PostMapping("getOne_For_Update")
	public String getOne_For_Update(@RequestParam("addOnId") String addOnId, ModelMap model) {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		/*************************** 2.開始查詢資料 *****************************************/

		// 先把指定id的VO物件查出來並顯示,準備交給updateEvent頁面做修改
		AddOn addOn = addOnService.getOneAddOn(Integer.valueOf(addOnId));				
		
		/*************************** 3.查詢完成,準備轉交(Send the Success view) **************/
		model.addAttribute("addOn", addOn);

		return "/addOn/updateAddOn";
	}
	
	@PostMapping("update")
	public String update(@Valid AddOn addOn, BindingResult result, ModelMap model) throws IOException {
		
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/		
		if (result.hasErrors()) { //錯誤訊息result
			return "/addOn/updateAddOn";
		}
		/*************************** 2.開始修改資料 *****************************************/
		addOn.setLastUpdated(now);
		addOnService.updateAddOn(addOn); //把更新好屬性的當前VO物件交給Service層做update

		/*************************** 3.修改完成,準備轉交(Send the Success view) **************/
		model.addAttribute("success", "- (修改成功)");
		addOn = addOnService.getOneAddOn(Integer.valueOf(addOn.getAddOnId())); //取出剛更新完的VO物件,顯示在前端頁面上
		model.addAttribute("addOn", addOn);
			
		return "/addOn/listOneAddOn";
	}
			
}
