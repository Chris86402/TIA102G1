package com.tia102g1.staff.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tia102g1.staff.model.StaffService;
import com.tia102g1.staff.model.StaffVO;

@Controller
@RequestMapping("/staff")
public class StaffController {
	
	Timestamp now = Timestamp.valueOf(LocalDateTime.now());
	
	@Autowired
	StaffService staffSvc;
	
	@GetMapping("addStaff")
	public String addStaff(ModelMap model) {
		StaffVO staffVO = new StaffVO();
		model.addAttribute("staffVO", staffVO);
		return "staff/addStaff";
	}
	
	@PostMapping("insert")
	public String insert(@RequestParam("employDt") String employDt ,@Valid StaffVO staffVO, BindingResult result, ModelMap model, HttpSession session) throws IOException{
		result = removeFieldError(staffVO, result, "employDt");
		
		 if (employDt == null || employDt.trim().length() == 0) {
		     model.addAttribute("errorMessage", "到職日期:請勿空白");
		     return "staff/addStaff"; 
		 }
		 
		if(result.hasErrors()) {
			return "staff/addStaff";
		}
		
		staffVO.setPassword("Desserter");
		staffVO.setStatus(1);
		staffVO.setDateCreated(now);
		staffVO.setLastUpdated(now);
		
		String createdBy = (String) session.getAttribute("staffId");

		staffVO.setCreatedBy(createdBy);
		staffVO.setLastUpdatedBy(createdBy);		
		staffSvc.addStaff(staffVO);
		
		List<StaffVO> list = staffSvc.getAll();
		
		model.addAttribute("staffListData", list);
		return "redirect:/staff/listAllStaff";
	}
	
	@PostMapping("getOne_For_Display")
	public String getOne_For_Display(@RequestParam("staffId") String staffId, ModelMap model) {
		StaffVO staffVO = staffSvc.getOneStaff(Integer.valueOf(staffId));
		
		model.addAttribute("staffVO", staffVO);
		return "staff/listOneStaff";
	}
	
	@PostMapping("getOne_For_Update")
	public String getOne_For_Update(@RequestParam("staffId") String staffId, ModelMap model) {
		StaffVO staffVO = staffSvc.getOneStaff(Integer.valueOf(staffId));
		
		model.addAttribute("staffVO", staffVO);
		return "staff/updateStaff";
	}
	
	@PostMapping("update")
	public String update(@Valid StaffVO staffVO, BindingResult result, ModelMap model, @RequestParam(value = "leaveDt", required = false) String leaveDtStr, HttpSession session) {
		
		result = removeFieldError(staffVO, result, "leaveDt");
		
		Date employDt = staffVO.getEmployDt();
		Date leaveDt = null;
		
		if(leaveDtStr != null && leaveDtStr.trim().length() != 0) {
            try {
				leaveDt = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(leaveDtStr).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if(leaveDt != null && employDt != null && leaveDt.compareTo(employDt) < 0) {
			model.addAttribute("errorMessage", "離職日不得早於到職日");
	        return "staff/updateStaff";
		}
		
		String lastUpdatedBy = (String) session.getAttribute("staffId");
		staffVO.setLastUpdatedBy(lastUpdatedBy);

	    staffVO.setLeaveDt(leaveDt);
		staffVO.setLastUpdated(now);
		
		if(result.hasErrors()) {
			System.out.println(result);
			return "staff/updateStaff";
		}
		
		staffSvc.updateStaff(staffVO);
		
		staffVO = staffSvc.getOneStaff(Integer.valueOf(staffVO.getStaffId()));
		model.addAttribute("staffVO", staffVO);
		return "staff/listOneStaff";
	}
	
	@PostMapping("listStaff_ByCompositeQuery")
	public String listAllStaff(HttpServletRequest req, Model model) {
		Map<String, String[]> map = req.getParameterMap();
		List<StaffVO> list = staffSvc.getAll(map);
		model.addAttribute("staffListData", list);
		return "staff/listAllStaff";
	}
	
	@GetMapping("staffLogin")
	public String staffLogin(Model model) {
		StaffVO staffVO = new StaffVO();
		model.addAttribute("staffVO", staffVO);
		return "staff/staffLogin";
	}
	
	@PostMapping("login")
	public String login(@RequestParam("staffId") String staffIdStr, @RequestParam("password") String password, @RequestParam(value = "redirect") String redirect,HttpServletRequest req,HttpSession session,Model model) {
		
		if(staffIdStr == null || staffIdStr.trim().length() == 0 || !staffIdStr.matches("^\\d{4}$")) {
			model.addAttribute("errorMessage", "請輸入員工編號");
			return "staff/staffLogin";
		}
		
		StaffVO staff = staffSvc.getOneStaff(Integer.valueOf(staffIdStr));
		
		if(staff == null) {
			model.addAttribute("errorMessage", "員工不存在");
		}
		
		if(staff.getStatus() == 0) {
			model.addAttribute("errorMessage", "該員工已離職");
			return "staff/staffLogin";
		}
		
		if("Desserter".equals(password)) {
			return "redirect:/staff/staffChangePW";
		}else if(password.equals(staff.getPassword())) {
			model.addAttribute("staffId", staffIdStr);
			session.setAttribute("staffName", staff.getName());
			session.setAttribute("permission",staff.getPermission());
			session.setAttribute("staffId", staffIdStr);
			if(redirect == null || redirect.trim().length() == 0) {
				redirect = "/";
			}
			session.removeAttribute("location");
			return "redirect:" + redirect;
		}else {
			model.addAttribute("errorMessage", "登入失敗!!!");
			return "staff/staffLogin";
		}
	}
	
	@GetMapping("staffChangePW")
	public String changePWPage(Model model) {
		StaffVO staffVO = new StaffVO();
		
		model.addAttribute("staffVO", staffVO);
		return "staff/staffChangePW";
	}
	
	@PostMapping("changePW")
	public String changePW(@RequestParam("staffId") String staffIdStr ,@RequestParam("pastPW") String pastPW,@RequestParam("newPW") String newPW, Model model) {
		
		if(staffIdStr == null || staffIdStr.trim().length() == 0 || !staffIdStr.matches("^\\d{4}$")) {
			model.addAttribute("errorMessage", "請輸入員工編號");
			return "staff/staffChangePW";
		}
		
		StaffVO staff = staffSvc.getOneStaff(Integer.valueOf(staffIdStr));
		
		if(staff == null) {
			model.addAttribute("errorMessage", "員工不存在");
			return "staff/staffChangePW";
		}
		
		if(staff.getStatus() == 0) {
			model.addAttribute("errorMessage", "該員工已離職");
			return "staff/staffChangePW";
		}
		
		if(pastPW == null || pastPW.trim().length() == 0 || !pastPW.equals(staff.getPassword())) {
			model.addAttribute("errorMessage", "請輸入舊密碼!!!!");
			return "staff/staffChangePW";
		}
		
		String newPWReg = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{1,10}$";
		if(newPW == null || newPW.trim().length() == 0) {
			model.addAttribute("errorMessage", "請輸入新密碼!!!");
			return "staff/staffChangePW";
		}else if(newPW.equals(pastPW)) {
			model.addAttribute("errorMessage", "新密碼不得與舊密碼相同!!!");
			return "staff/staffChangePW";
		}else if(!newPW.trim().matches(newPWReg)) {
			model.addAttribute("errorMessage", "密碼請輸入英文大小寫及數字，不得超過10字!!!");
			return "staff/staffChangePW";
		}
		
		staff.setPassword(newPW);
		staffSvc.updateStaff(staff);
		model.addAttribute("staffVO", staff);
		return "redirect:/staff/staffLogin";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {		
	    
		session.invalidate();
		
		return "redirect:/";
	}
	
	public BindingResult removeFieldError(StaffVO staffVO, BindingResult result, String removedFieldname) {
		List<FieldError> errorsListToKeep = result.getFieldErrors().stream().filter(fieldname -> !fieldname.getField().equals(removedFieldname)).collect(Collectors.toList());
		result = new BeanPropertyBindingResult(staffVO, "staffVO");
		for(FieldError fieldError : errorsListToKeep) {
			result.addError(fieldError);
		}
		return result;
	}
	
}
