package com.tia102g1.productInfo.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tia102g1.productInfo.entity.ProductInfo;
import com.tia102g1.productInfo.model.ProductInfoServiceS;
@Controller
@RequestMapping("/productInfo")
public class ProductInfoController {

	Timestamp now = Timestamp.valueOf(LocalDateTime.now());
	
	@Autowired
	ProductInfoServiceS productInfoServiceS;
	
	//@GetMapping("addProductInfo")
	public String addProductInfo(ModelMap model) {
		ProductInfo productInfo = new ProductInfo();
		model.addAttribute("productInfo",productInfo);
		return "productInfo/addProductInfo";
	}
	
	@GetMapping("/mainPageProductInfo")
	public String referenceProductInfoListData(Model model){
		List<ProductInfo> list = productInfoServiceS.getAll();
		model.addAttribute("productInfoListData", list);
		return "/productInfo/mainPageProductInfo";
		
	}
	
	//@PostMapping("listProductInfosByCompositeQuery")
	public String listAllProductInfo(HttpServletRequest req, Model model) {
		Map<String, String[]> map = req.getParameterMap();
		List<ProductInfo> list = productInfoServiceS.getAll(map);
		model.addAttribute("productInfoListData", list);
		return "productInfo/mainPageProductInfo";
	}
}
