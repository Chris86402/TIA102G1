package com.tia102g1.qutype.controller;

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

import com.tia102g1.qutype.model.QuTypeService;
import com.tia102g1.qutype.model.QuTypeVO;

@Controller
@RequestMapping("/quType")
public class QuTypeController {
	
	Timestamp now = Timestamp.valueOf(LocalDateTime.now());
	
	@Autowired
	QuTypeService quTypeSvc;
	
	@GetMapping("addQuType")
	public String addQuType(ModelMap model) {
		QuTypeVO quTypeVO = new QuTypeVO();
		model.addAttribute("quTypeVO", quTypeVO);
		return "quType/addQuType";
	}
	
	@PostMapping("insert")
	public String insert(@Valid QuTypeVO quTypeVO,BindingResult result, ModelMap model, HttpSession session) {
		if(result.hasErrors()) {
			return "quType/addQuType";
		}
		
		quTypeVO.setDateCreated(now);
		quTypeVO.setLastUpdated(now);
		
		String createdBy = (String) session.getAttribute("staffId");

		quTypeVO.setCreatedBy(createdBy);
		quTypeVO.setLastUpdatedBy(createdBy);		
		quTypeSvc.addQuType(quTypeVO);
		
		List<QuTypeVO> list = quTypeSvc.getAll();
		
		model.addAttribute("quTypeListData", list);
		
		return "redirect:/quType/mainPageQuType";
	}
	
	@PostMapping("getOne_For_Update")
	public String getOne_For_Update(@RequestParam("quTypeId") String quTypeId, ModelMap model) {
		QuTypeVO quTypeVO = quTypeSvc.getOneQuType(Integer.valueOf(quTypeId));
		
		model.addAttribute("quTypeVO", quTypeVO);
		return "quType/updateQuType";
	}
	
	@PostMapping("update")
	public String update(@Valid QuTypeVO quTypeVO, BindingResult result, ModelMap model, HttpSession session) {
		if(result.hasErrors()) {
			return "quType/updateQuType";
		}
		String lastUpdatedBy = (String) session.getAttribute("staffId");
	   
		quTypeVO.setLastUpdatedBy(lastUpdatedBy);
		quTypeVO.setLastUpdated(now);
		quTypeSvc.updateQuType(quTypeVO);
		
		quTypeVO = quTypeSvc.getOneQuType(Integer.valueOf(quTypeVO.getQuTypeId()));
		model.addAttribute("quTypeVO", quTypeVO);
		return "quType/listOneQuType";
	}
}
