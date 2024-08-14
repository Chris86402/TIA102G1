package com.tia102g1.productcomment.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tia102g1.member.model.Member;
import com.tia102g1.member.model.MemberService;
import com.tia102g1.orderlistinfo.model.OrderListInfoService;
import com.tia102g1.orderlistinfo.model.OrderListInfoVO;
import com.tia102g1.productcomment.model.ProductCommentService;
import com.tia102g1.productcomment.model.ProductCommentVO;
import com.tia102g1.productinfo.entity.ProductInfo;
import com.tia102g1.productinfo.model.ProductInfoServiceS;
import com.tia102g1.staff.model.StaffService;
import com.tia102g1.staff.model.StaffVO;

@Controller
@RequestMapping("/productComment")
public class ProductCommentController {

	Timestamp now = Timestamp.valueOf(LocalDateTime.now());

	@Autowired
	ProductCommentService productCommentService;

	@Autowired
	MemberService memberService;

	@Autowired
	ProductInfoServiceS productInfoServiceS;

	@Autowired
	OrderListInfoService orderListInfoService;

	@Autowired
	StaffService staffService;

	@GetMapping({ "", "/mainPageProductComment" })
	public String referenceProductCommentListData(Model model) {
		List<ProductCommentVO> list = productCommentService.getAll();
		model.addAttribute("productCommentListData", list);
		return "/productComment/mainPageProductComment";
	}
	
	@ModelAttribute("productCommentListData")
	protected List<ProductCommentVO> referenceListData_ProComment(Model model){
		List<ProductCommentVO> list = productCommentService.getAll();
		return list;
	}

	@ModelAttribute("memberListData")
	protected List<Member> referenceListData_member(Model model) {
		List<Member> list = memberService.getAll();
		return list;
	}

	@ModelAttribute("productInfoListData")
	protected List<ProductInfo> referenceListData_productInfo(Model model) {
		List<ProductInfo> list = productInfoServiceS.getAll();
		return list;
	}

	@ModelAttribute("orderListInfoListData")
	protected List<OrderListInfoVO> referenceListData_orderListInfo(Model model) {
		List<OrderListInfoVO> list = orderListInfoService.getAll();
		return list;
	}

	@ModelAttribute("staffListData")
	protected List<StaffVO> referenceListData_staff(Model model) {
		List<StaffVO> list = staffService.getAll();
		return list;
	}

	@GetMapping("addProductComment")
	public String addProductComment(ModelMap model) {
		ProductCommentVO productCommentVO = new ProductCommentVO();
		model.addAttribute("productCommentVO", productCommentVO);
		return "/productComment/addProductComment";
	}

	@PostMapping("insert")
	public String insert(@Valid ProductCommentVO productCommentVO, BindingResult result, ModelMap model,
			@RequestParam("commentPic") MultipartFile[] parts) throws IOException {
		// 移除與 commentPic 相關的字段錯誤
		result = removeFieldError(productCommentVO, result, "commentPic");

		if (!parts[0].isEmpty()) { // 檢查用戶是否上傳了圖片
			for (MultipartFile multipartFile : parts) {
				if (multipartFile.getSize() > 5 * 1024 * 1024) { // 限制圖片大小為5MB以內
					model.addAttribute("errorMessage", "商品照片: 圖片大小不能超過 5MB");
					return "/productComment/addProductComment";
				}

				byte[] buf = multipartFile.getBytes();
				productCommentVO.setCommentPic(buf);
			}
		} else {
			productCommentVO.setCommentPic(null); // 如果未上傳圖片，則將圖片設置為null
		}

		if (result.hasErrors()) { // 如果有其他錯誤
			List<ObjectError> allErrors = result.getAllErrors(); // 獲取所有錯誤信息
			System.out.println(allErrors); // 輸出錯誤信息以便調試
			return "/productComment/addProductComment"; // 確認返回路徑
		}

		productCommentVO.setDateCreated(now);
		productCommentVO.setLastUpdated(now);
		productCommentVO.setLastUpdatedBy(productCommentVO.getCreatedBy());

		productCommentService.addProductCommentVO(productCommentVO);

		model.addAttribute("success", "- (新增成功)");

		return "redirect:/productComment/mainPageProductComment"; // 確認重定向路徑
	}

	// BindingResult 是 Spring 框架中的一個接口，用來存儲表單驗證的錯誤信息
	// 去除BindingResult中某個欄位的FieldError紀錄
	// 動態處理表單驗證錯誤
	// 返回的 BindingResult 會包含所有原本的錯誤信息，但移除了指定欄位名稱的錯誤
	public BindingResult removeFieldError(ProductCommentVO productCommentVO, BindingResult result,
			String removedFieldname) {
		// 取得需要保留的錯誤列表
		List<FieldError> errorsListToKeep = result.getFieldErrors().stream() // 取得所有的FieldError //轉換成一個流來處理這些錯誤
				.filter(fieldname -> !fieldname.getField().equals(removedFieldname)) // 過濾掉欄位名稱等於 removedFieldname 的錯誤
				.collect(Collectors.toList()); // 將過濾後的結果收集成一個 List<FieldError>
		// 重新建立 BindingResult
		result = new BeanPropertyBindingResult(productCommentVO, "productCommentVO"); // 創建一個新的
																						// BeanPropertyBindingResult
																						// 對象，綁定到 productinfo

		// 將保留的錯誤加回到新的 BindingResult
		for (FieldError fieldError : errorsListToKeep) { // 將保留的錯誤逐個加回到新的 BindingResult 中
			result.addError(fieldError);
			System.out.println(fieldError);
		}
		return result;
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String handleMaxUploadSizeExceededException(MaxUploadSizeExceededException exc,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errorMessage", "文件大小超過最大限制 (5MB)");
		return "redirect:/productComment/addProductComment";
	}

	// 回覆評價
	@PostMapping("getOne_For_Update")
	public String getOne_For_Update(@RequestParam("proCommentId") String proCommentId, ModelMap model) {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		/*************************** 2.開始查詢資料 *****************************************/

		// 先把指定id的VO物件查出來並顯示,準備交給updateEvent頁面做修改
		ProductCommentVO productCommentVO = productCommentService.getOneProductCommentVO(Integer.valueOf(proCommentId));
				
		/*************************** 3.查詢完成,準備轉交(Send the Success view) **************/
		model.addAttribute("productCommentVO", productCommentVO);

		return "productComment/updateProductComment";
	}

	@PostMapping("update")
	public String update(@Valid ProductCommentVO productCommentVO, BindingResult result, ModelMap model,
			@RequestParam("commentPic") MultipartFile[] parts) throws IOException {

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		// 去除BindingResult中proPic欄位的FieldError紀錄 --> 見第172行
		result = removeFieldError(productCommentVO, result, "commentPic");

		if (parts[0].isEmpty()) { // 使用者未選擇要上傳的新圖片時,就取原有的圖片塞入
			byte[] commentPic = productCommentService.getOneProductCommentVO(productCommentVO.getProCommentId()).getCommentPic(); // getOneProductCommentVO()返回VO物件,
																											// 再呼叫圖片屬性getter
			productCommentVO.setCommentPic(commentPic); // 然後setter放入當前VO物件中
		} else { // 使用者有選擇要上傳的新圖片時
			for (MultipartFile multipartFile : parts) { // 逐一取出
				if (multipartFile.getSize() > 5 * 1024 * 1024) { // 5MB = 5 * 1024 * 1024 bytes
					model.addAttribute("errorMessage", "商品照片: 圖片大小不能超過 5MB");
					return "/productComment/addProductComment";
				}
				byte[] commentPic = multipartFile.getBytes(); // 轉為Bytes
				productCommentVO.setCommentPic(commentPic); // 把Bytes setter進當前VO物件的圖片屬性
			}
		}
		if (result.hasErrors()) { // 錯誤訊息result
			return "/productComment/updateProductComment";
		}
		/*************************** 2.開始修改資料 *****************************************/
		productCommentVO.setReplyTime(now);
		productCommentVO.setLastUpdated(now);
		productCommentService.updateProductCommentVO(productCommentVO);// 把更新好屬性的當前VO物件交給Service層做update

		/*************************** 3.修改完成,準備轉交(Send the Success view) **************/
		model.addAttribute("success", "- (修改成功)");
		productCommentVO = productCommentService.getOneProductCommentVO(Integer.valueOf(productCommentVO.getProCommentId()));// 取出剛更新完的VO物件,顯示在前端頁面上
		model.addAttribute("productCommentVO", productCommentVO);

		return "/productComment/listOneProductComment";
	}
	
	@PostMapping("listComment_byMember")
	public String listMemberComments(@RequestParam("memberId") String memberId, Model model) {
		List<ProductCommentVO> list = productCommentService.getOneMemberComment(Integer.valueOf(memberId));
		model.addAttribute("productCommentListData", list);
		return "productComment/mainPageProductComment";
	}
	
	@PostMapping("listComment_byProduct")
	public String listProdComments(@RequestParam("productId") String productId, Model model) {
		List<ProductCommentVO> list = productCommentService.getOneProdComment(Integer.valueOf(productId));
		model.addAttribute("productCommentListData", list);
		return "productComment/mainPageProductComment";
	}

}
