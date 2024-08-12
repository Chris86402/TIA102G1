package com.tia102g1.productinfo.controller;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tia102g1.productinfo.entity.ProductInfo;
import com.tia102g1.productinfo.model.ProductInfoServiceS;
import com.tia102g1.producttype.model.ProductTypeService;
import com.tia102g1.producttype.model.ProductTypeVO;
@Controller 
@RequestMapping("/productInfo")
public class ProductInfoController {

	Timestamp now = Timestamp.valueOf(LocalDateTime.now());
	
	@Autowired
	ProductInfoServiceS productInfoServiceS;
	
	@Autowired
	ProductTypeService productTypeService;
	
	@GetMapping({"", "/mainPageProductInfo"})
	public String referenceProductInfoListData(Model model){
		List<ProductInfo> list = productInfoServiceS.getAll();
		model.addAttribute("productInfoListData", list);
		return "/productInfo/mainPageProductInfo";
		
	}
	
	@ModelAttribute("productInfoListData2")
	protected List<ProductInfo> referenceListData(Model model){
		List<ProductInfo> list = productInfoServiceS.getAll();
		return list;
	}
	
	@ModelAttribute("typeListData")
	protected List<ProductTypeVO> referenceListData_type(Model model){
		List<ProductTypeVO> list = productTypeService.getAll();
		return list;
	}
	
	@GetMapping("addProductInfo")
	public String addProductInfo(ModelMap model) {
		ProductInfo productInfo = new ProductInfo();
		model.addAttribute("productInfo",productInfo);
		return "/productInfo/addProductInfo";
	}
	
	@PostMapping("insert")
	public String insert(@Valid ProductInfo productInfo, BindingResult result, ModelMap model, @RequestParam("proPic") MultipartFile[] parts) throws IOException {
		result = removeFieldError(productInfo, result, "proPic");
		if (parts[0].isEmpty()) { // 使用者未選擇要上傳的圖片時
	        model.addAttribute("errorMessage", "商品照片: 請上傳照片");
	    } else {
	        for (MultipartFile multipartFile : parts) {
	        	if (multipartFile.getSize() > 5 * 1024 * 1024) { // 5MB = 5 * 1024 * 1024 bytes
                    model.addAttribute("errorMessage", "商品照片: 圖片大小不能超過 5MB");
                    return "/productInfo/addProductInfo";
                }

	            byte[] buf = multipartFile.getBytes();
	            productInfo.setProPic(buf);
	        }
	    }

	    if(result.hasErrors() || parts[0].isEmpty()) {
	        List<ObjectError> allErrors = result.getAllErrors(); // 取得錯誤資訊
	        System.out.println(allErrors); // 印出錯誤資訊
	        return "/productInfo/addProductInfo"; // 確認返回路徑是否正確
	    }
	    
	    productInfo.setCommentUsers(0);
	    productInfo.setCommentStars(0);
	    productInfo.setDateCreated(now);
	    productInfo.setLastUpdated(now);
	    productInfo.setLastUpdatedBy(productInfo.getCreatedBy());

	    productInfoServiceS.addProductInfo(productInfo);

	    List<ProductInfo> list = productInfoServiceS.getAll();
	    model.addAttribute("success", "- (新增成功)");

	    return "redirect:/productInfo/mainPageProductInfo"; // 確認重定向路徑是否正確
	}
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxUploadSizeExceededException(MaxUploadSizeExceededException exc, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errorMessage", "文件大小超過最大限制 (5MB)");
        return "redirect:/productInfo/addProductInfo";
    }

	
	//修改
	@PostMapping("getOne_For_Update")
	public String getOne_For_Update(@RequestParam("productId") String productId, ModelMap model) {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		/*************************** 2.開始查詢資料 *****************************************/
		
		//先把指定id的VO物件查出來並顯示,準備交給updateEvent頁面做修改
		ProductInfo productInfo = productInfoServiceS.getOneProductInfo(Integer.valueOf(productId));
				

		/*************************** 3.查詢完成,準備轉交(Send the Success view) **************/
		model.addAttribute("productInfo", productInfo);
		
		return "productInfo/updateProductInfo";
	}
	
	
	@PostMapping("update")
	public String update(@Valid ProductInfo productInfo, BindingResult result, ModelMap model, 
			@RequestParam("proPic") MultipartFile[] parts) throws IOException {
		
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		// 去除BindingResult中proPic欄位的FieldError紀錄 --> 見第172行
		result = removeFieldError(productInfo, result, "proPic");

		if (parts[0].isEmpty()) { // 使用者未選擇要上傳的新圖片時,就取原有的圖片塞入
			byte[] proPic = productInfoServiceS.getOneProductInfo(productInfo.getProductId()).getProPic(); //getOneProductInfo()返回VO物件, 再呼叫圖片屬性getter
			productInfo.setProPic(proPic); //然後setter放入當前VO物件中
		} else { //使用者有選擇要上傳的新圖片時
			for (MultipartFile multipartFile : parts) { //逐一取出
				if (multipartFile.getSize() > 5 * 1024 * 1024) { // 5MB = 5 * 1024 * 1024 bytes
                    model.addAttribute("errorMessage", "商品照片: 圖片大小不能超過 5MB");
                    return "/productInfo/addProductInfo";
                }
				byte[] proPic = multipartFile.getBytes(); //轉為Bytes
				productInfo.setProPic(proPic); //把Bytes setter進當前VO物件的圖片屬性
			}
		}
		if (result.hasErrors()) { //錯誤訊息result
			return "/productinfo/updateProductInfo";
		}
		/*************************** 2.開始修改資料 *****************************************/
		productInfo.setLastUpdated(now);
		productInfoServiceS.updateProductInfo(productInfo); //把更新好屬性的當前VO物件交給Service層做update
	

		/*************************** 3.修改完成,準備轉交(Send the Success view) **************/
		model.addAttribute("success", "- (修改成功)");
		productInfo = productInfoServiceS.getOneProductInfo(Integer.valueOf(productInfo.getProductId())); //取出剛更新完的VO物件,顯示在前端頁面上
		model.addAttribute("productInfo",productInfo);
			
		return "/productInfo/listOneProductInfo";
	}
	
	
	// BindingResult 是 Spring 框架中的一個接口，用來存儲表單驗證的錯誤信息
	// 去除BindingResult中某個欄位的FieldError紀錄
	// 動態處理表單驗證錯誤
	// 返回的 BindingResult 會包含所有原本的錯誤信息，但移除了指定欄位名稱的錯誤
	public BindingResult removeFieldError(ProductInfo productInfo, BindingResult result, String removedFieldname) {
		// 取得需要保留的錯誤列表
		List<FieldError> errorsListToKeep = result.getFieldErrors().stream() // 取得所有的FieldError //轉換成一個流來處理這些錯誤
				.filter(fieldname -> !fieldname.getField().equals(removedFieldname)) // 過濾掉欄位名稱等於 removedFieldname 的錯誤
				.collect(Collectors.toList()); // 將過濾後的結果收集成一個 List<FieldError>
		// 重新建立 BindingResult
		result = new BeanPropertyBindingResult(productInfo, "productinfo"); // 創建一個新的 BeanPropertyBindingResult 對象，綁定到 productinfo

		// 將保留的錯誤加回到新的 BindingResult
		for (FieldError fieldError : errorsListToKeep) { // 將保留的錯誤逐個加回到新的 BindingResult 中
			result.addError(fieldError);
			System.out.println(fieldError);
		}
		return result;
	}


	@PostMapping("listProductInfosByCompositeQuery")
	public String listAllProductInfo(HttpServletRequest req, Model model) {
		Map<String, String[]> map = req.getParameterMap();
		List<ProductInfo> list = productInfoServiceS.getAll(map);
		model.addAttribute("productInfoListData", list);
		return "/productInfo/mainPageProductInfo";
	}
}
