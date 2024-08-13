package com.tia102g1.county.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tia102g1.county.model.CountyService;
import com.tia102g1.county.model.CountyVO;
import com.tia102g1.dist.model.DistService;
import com.tia102g1.dist.model.DistVO;

@Controller
@RequestMapping("/county")
public class CountyController {

	@Autowired
	CountyService countySvc;

	@Autowired
	DistService distSvc;

	// 查詢指定縣市的鄉鎮區
	@PostMapping("getZipCode")
	public String getZipCode(@RequestParam("cntCode") String cntCode, ModelMap model) {

		if (Integer.valueOf(cntCode) == 0) {
			List<DistVO> dists = distSvc.getAll();
			model.addAttribute("distListData", dists);
		}

		else {
			Set<DistVO> dists = countySvc.getOneCounty(Integer.valueOf(cntCode)).getDists();
			model.addAttribute("distListData", dists);
		}
		model.addAttribute("countyVO", new CountyVO());
		List<CountyVO> list = countySvc.getAll();
		model.addAttribute("countyListData", list);

		return "county/mainPageCounty";
	}



}
