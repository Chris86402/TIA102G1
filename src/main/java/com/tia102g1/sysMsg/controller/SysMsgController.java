package com.tia102g1.sysMsg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tia102g1.sysMsg.model.SysMsgService;
import com.tia102g1.sysMsg.model.SysMsgVO;

@Controller
@RequestMapping("/sysMsg")
public class SysMsgController {

	@Autowired
	SysMsgService sysMsgSvc;
	
	public String addSysMsg(ModelMap model) {
		
		return "sysMsg/addSysMsg";
	}
	
	public String insert(@Valid SysMsgVO sysMsgVO, BindingResult result, ModelMap model) {
		
		return "sysMsg/listAllSysMsg";
	}
	
	public String getOne_For_Update(@RequestParam("sysMsgId") String sysMsgId, ModelMap model) {
		
		return "sysMsg/update_sysMsg_input";
	}
	
	public String update(@Valid SysMsgVO sysMsgVO, BindingResult result, ModelMap model) {
		
		return "sysMsg/listOneSysMsg";
	}
	
	public String delete(@RequestParam("sysMsgId") String sysMsgId, ModelMap model) {
		
		return "sysMsg/listAllSysMsg";
	}
	
	public String listAllSysMsg(HttpServletRequest req, Model model) {
		
		return "sysMsg/listAllSysMsg";
	}
}
