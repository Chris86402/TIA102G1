package com.tia102g1.csform.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tia102g1.csform.model.CsFormService;
import com.tia102g1.csform.model.CsFormVO;
import com.tia102g1.member.model.Member;
import com.tia102g1.member.model.MemberService;
import com.tia102g1.orderlist.model.OrderListService;
import com.tia102g1.orderlist.model.OrderListVO;
import com.tia102g1.qutype.model.QuTypeService;
import com.tia102g1.qutype.model.QuTypeVO;
import com.tia102g1.staff.model.StaffService;
import com.tia102g1.staff.model.StaffVO;

@Controller
@RequestMapping("/csForm")
public class CsFormController {
	
	@Autowired
	CsFormService csFormSvc;
	
	@Autowired
	MemberService memberSvc;
	
	@Autowired
	OrderListService orderListSvc;
	
	@Autowired
	StaffService staffSvc;
	
	@Autowired
	QuTypeService quTypeSvc;
	
//	Date TodayDate = Date.valueOf(LocalDate.now());
	
	//帶著VO物件,導向addCsForm.html
	@GetMapping("addCsForm")
	public String addCsForm(ModelMap model) {
		CsFormVO csFormVO = new CsFormVO();
		model.addAttribute("csFormVO", csFormVO);
		
		return "csForm/addCsForm";
		
	}
	
	//新增
	@PostMapping("insert")
	public String insert(@Valid CsFormVO csFormVO, BindingResult result, ModelMap model, 
			@RequestParam("quPic") MultipartFile[] parts) throws IOException {
		
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		// 去除BindingResult中quPic欄位的FieldError紀錄 --> 見第172行
		result = removeFieldError(csFormVO, result, "quPic");

		if (parts[0].isEmpty()) { // 使用者未選擇要上傳的圖片時
			model.addAttribute("errorMessage", "活動圖片: 請上傳圖片");
		} else {
			for (MultipartFile multipartFile : parts) {
				byte[] buf = multipartFile.getBytes();
				csFormVO.setQuPic(buf);
			}
		}
		if (result.hasErrors() || parts[0].isEmpty()) {
			return "csForm/addCsForm";
		}
		/*************************** 2.開始新增資料 *****************************************/
		
//		csFormVO.setReplyDt(TodayDate);
		csFormVO.setLastUpdatedBy(csFormVO.getCreatedBy());
		
		System.out.println("準備新增的VO: " + csFormVO);
		csFormSvc.addCsForm(csFormVO);
		
//		try {
//			csFormVO.setLastUpdatedBy(csFormVO.getCreatedBy());
//			csFormSvc.addCsForm(csFormVO);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		
		/*************************** 3.新增完成,準備轉交(Send the Success view) **************/
		List<CsFormVO> list = csFormSvc.getAll();
		model.addAttribute("CsFormListData", list);
		model.addAttribute("success", "- (新增成功)");
		
		return "redirect:/csForm/listAllCsForm";
	}
	
	
	//查出指定VO物件,轉交給updateCsForm.html做修改
	@PostMapping("getOne_For_Update")
	public String getOne_For_Update(@RequestParam("csFormId") String csFormId, ModelMap model) {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		/*************************** 2.開始查詢資料 *****************************************/
		
		//先把指定id的VO物件查出來並顯示,準備交給updateCsForm頁面做修改
		CsFormVO csFormVO = csFormSvc.getOneCsForm(Integer.valueOf(csFormId));
		
		System.out.println("查詢出來的VO: " + csFormVO);

		/*************************** 3.查詢完成,準備轉交(Send the Success view) **************/
		model.addAttribute("csFormVO", csFormVO);
		
		return "csForm/updateCsForm";
	}
	
	
	//修改
	@PostMapping("update")
	public String update(@Valid CsFormVO csFormVO, BindingResult result, ModelMap model) throws IOException {
		
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/

		if (result.hasErrors()) { //錯誤訊息result
//			csFormVO = csFormSvc.getOneCsForm(Integer.valueOf(csFormVO.getCsFormId())); //取出原本的VO物件,顯示在前端頁面上
//			model.addAttribute("csFormVO", csFormVO);
			return "csForm/updateCsForm";
		}
		/*************************** 2.開始修改資料 *****************************************/
		System.out.println("準備修改的VO: " + csFormVO);
		
		csFormSvc.updateCsForm(csFormVO); //把更新好屬性的當前VO物件交給Service層做update
		
//		try {
//			csFormSvc.updateCsForm(csFormVO);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		/*************************** 3.修改完成,準備轉交(Send the Success view) **************/
		model.addAttribute("success", "- (修改成功)");
		csFormVO = csFormSvc.getOneCsForm(Integer.valueOf(csFormVO.getCsFormId())); //取出剛更新完的VO物件,顯示在前端頁面上
		model.addAttribute("csFormVO", csFormVO);
			
		return "csForm/listOneCsForm";
	}
	
	
	//刪除
	@PostMapping("delete")
	public String delete(@RequestParam("csFormId") String csFormId, ModelMap model) {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		/*************************** 2.開始刪除資料 *****************************************/
		
		csFormSvc.deleteCsForm(Integer.valueOf(csFormId)); //執行刪除
		
		/*************************** 3.刪除完成,準備轉交(Send the Success view) **************/
		List<CsFormVO> list = csFormSvc.getAll(); //全部查詢,刪完後顯示最新的全部資料
		model.addAttribute("csFormListData", list);
		model.addAttribute("success", "- (刪除成功)");
		
		return "csForm/listAllCsForm";
	}
	
	@ModelAttribute("memberListData")
	protected List<Member> referenceListData_Member() {
		List<Member> list = memberSvc.getAll();
		return list;
	}
	
	@ModelAttribute("orderListListData")
	protected List<OrderListVO> referenceListData_OrderList() {
		List<OrderListVO> list = orderListSvc.getAll();
		return list;
	}
	
	@ModelAttribute("staffListData")
	protected List<StaffVO> referenceListData_Staff() {
		List<StaffVO> list = staffSvc.getAll();
		return list;
	}
	
	@ModelAttribute("quTypeListData")
	protected List<QuTypeVO> referenceListData_QuType() {
		List<QuTypeVO> list = quTypeSvc.getAll();
		return list;
	}
	
	
	// BindingResult 是 Spring 框架中的一個接口，用來存儲表單驗證的錯誤信息
	public BindingResult removeFieldError(CsFormVO csFormVO, BindingResult result, String removedFieldname) {
		// 取得需要保留的錯誤列表
		List<FieldError> errorsListToKeep = result.getFieldErrors().stream() // 取得所有的FieldError //轉換成一個流來處理這些錯誤
				.filter(fieldname -> !fieldname.getField().equals(removedFieldname)) // 過濾掉欄位名稱等於 removedFieldname 的錯誤
				.collect(Collectors.toList()); // 將過濾後的結果收集成一個 List<FieldError>
		// 重新建立 BindingResult
		result = new BeanPropertyBindingResult(csFormVO, "csFormVO"); // 創建一個新的 BeanPropertyBindingResult 對象，綁定到 empVO

		// 將保留的錯誤加回到新的 BindingResult
		for (FieldError fieldError : errorsListToKeep) { // 將保留的錯誤逐個加回到新的 BindingResult 中
			result.addError(fieldError);
			System.out.println(fieldError);
		}
		return result;
	}
	
	
	//複合查詢
	@PostMapping("listCsForms_ByCompositeQuery")
	public String listAllCsForm(HttpServletRequest req, Model model) {
		Map<String, String[]> map = req.getParameterMap(); //getParameterMap()返回一個map
		//該map傳入getAll()會執行複合查詢CompositeQuery_XXX class的getAllC()方法,回傳查詢結果list
		List<CsFormVO> list = csFormSvc.getAll(map);
		model.addAttribute("csFormListData", list);
		
		return "csForm/listAllCsForm";
	}
	

}
