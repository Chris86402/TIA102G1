package com.tia102g1.sysmsg.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tia102g1.sysmsg.model.SysMsgService;
import com.tia102g1.sysmsg.model.SysMsgVO;

@Controller
@RequestMapping("/sysMsg")
public class SysMsgController {
	
	Timestamp now = Timestamp.valueOf(LocalDateTime.now());

	@Autowired
	SysMsgService sysMsgSvc;
	
	@GetMapping("addSysMsg")
	public String addSysMsg(ModelMap model) {
		SysMsgVO sysMsgVO = new SysMsgVO();
		model.addAttribute("sysMsgVO", sysMsgVO);
		return "sysMsg/addSysMsg";
	}
	
	@PostMapping("insert")
	public String insert(@Valid SysMsgVO sysMsgVO, BindingResult result, ModelMap model, HttpSession session) {
		
		if(result.hasErrors()) {
			return "sysMsg/addSysMsg";
		}
		
		sysMsgVO.setStatus(1);
		
		sysMsgVO.setDateCreated(now);
		sysMsgVO.setLastUpdated(now);
		
		String createdBy = (String) session.getAttribute("staffId");

		sysMsgVO.setCreatedBy(createdBy);
		sysMsgVO.setLastUpdatedBy(createdBy);		
		sysMsgSvc.addSysMsg(sysMsgVO);
		
		List<SysMsgVO> list = sysMsgSvc.getAll();
		
		model.addAttribute("sysMsgListData", list);
		return "redirect:/sysMsg/listAllSysMsg";
	}
	
	@PostMapping("getOne_For_Update")
	public String getOne_For_Update(@RequestParam("sysMsgId") String sysMsgId, ModelMap model) {
		SysMsgVO sysMsgVO = sysMsgSvc.getOneSysMsg(Integer.valueOf(sysMsgId));
		
		model.addAttribute("sysMsgVO", sysMsgVO);
		return "sysMsg/update_sysMsg_input";
	}
	
	@PostMapping("update")
	public String update(@Valid SysMsgVO sysMsgVO, BindingResult result, ModelMap model, HttpSession session) {
		if(result.hasErrors()) {
			return "sysMsg/update_sysMsg_input";
		}
		String lastUpdatedBy = (String) session.getAttribute("staffId");

		sysMsgVO.setLastUpdatedBy(lastUpdatedBy);
		sysMsgVO.setLastUpdated(now);
		
		sysMsgSvc.updateSysMsg(sysMsgVO);
		
		sysMsgVO = sysMsgSvc.getOneSysMsg(Integer.valueOf(sysMsgVO.getSysMsgId()));
		model.addAttribute("sysMsgVO", sysMsgVO);
		
		return "sysMsg/listOneSysMsg";
	}
	
	@PostMapping("delete")
	public String delete(@RequestParam("sysMsgId") String sysMsgId, ModelMap model) {
		sysMsgSvc.deleteSysMsg(Integer.valueOf(sysMsgId));
		
		List<SysMsgVO> list = sysMsgSvc.getAll();
		model.addAttribute("sysMsgListData", list);
		return "sysMsg/listAllSysMsg";
	}
	
	@PostMapping("listSysMsg_ByCompositeQuery")
	public String listAllSysMsg(HttpServletRequest req, Model model) {
		Map<String, String[]> map = req.getParameterMap();
		List<SysMsgVO> list = sysMsgSvc.getAll(map);
		model.addAttribute("sysMsgListData", list);
		return "sysMsg/listAllSysMsg";
	}
}
