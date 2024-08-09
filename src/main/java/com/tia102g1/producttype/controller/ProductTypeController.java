package com.tia102g1.producttype.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tia102g1.producttype.model.ProductTypeService;
import com.tia102g1.producttype.model.ProductTypeVO;

@Controller
@RequestMapping("/productType")
public class ProductTypeController {
	
	Timestamp now = Timestamp.valueOf(LocalDateTime.now());

	
	@Autowired
	ProductTypeService typeSvc;
	
	@GetMapping("addType")
	public String addType(ModelMap model) {
		ProductTypeVO typeVO = new ProductTypeVO();
		model.addAttribute("productTypeVO", typeVO);
		return "productType/addType";
	}
	
	@PostMapping("insert")
	public String insert(@Valid ProductTypeVO typeVO, BindingResult result, ModelMap model, HttpSession session) throws IOException{
		System.out.println("============================" + result);
		if(result.hasErrors()) {
			return "productType/addType";
		}
		
		
		typeVO.setDateCreated(now);
		typeVO.setLastUpdated(now);
		String createdBy = (String) session.getAttribute("staffId");

	    typeVO.setCreatedBy(createdBy);
		typeVO.setLastUpdatedBy(createdBy);
		
		typeSvc.addType(typeVO);
		
		List<ProductTypeVO> list = typeSvc.getAll();
		
		model.addAttribute("typeListData", list);
		model.addAttribute("success", "- (新增成功)");
		return "redirect:/productType/mainPageProductType";
	}
	
	@PostMapping("getOne_For_Display")
	public String getOne_For_Display(@RequestParam("productTypeId") String productTypeId, ModelMap model) {
		ProductTypeVO typeVO = typeSvc.getOneType(Integer.valueOf(productTypeId));
		
		model.addAttribute("productTypeVO", typeVO);
		model.addAttribute("getOne_For_Display", "true");
		return "/productType/mainPageProductType";
	}
	
	@PostMapping("getOne_For_Update")
	public String getOne_For_Update(@RequestParam("productTypeId") String productTypeId, ModelMap model) {
		
		ProductTypeVO typeVO =  typeSvc.getOneType(Integer.valueOf(productTypeId));
		
		model.addAttribute("productTypeVO", typeVO);
		return "productType/updateProductType";
	}
	
	@PostMapping("update")
	public String update(@Valid ProductTypeVO typeVO, BindingResult result, ModelMap model, HttpSession session) throws IOException{
		
		if(result.hasErrors()) {
			return "productType/updateProductType";
		}
		String lastUpdatedBy = (String) session.getAttribute("staffId");

	    typeVO.setLastUpdatedBy(lastUpdatedBy);
		typeVO.setLastUpdated(now);
		typeSvc.updateType(typeVO);
		
		model.addAttribute("success", "- (修改成功)");
		typeVO = typeSvc.getOneType(Integer.valueOf(typeVO.getProductTypeId()));
		model.addAttribute("productTypeVO", typeVO);
		return "productType/listOneType";
	}
}
