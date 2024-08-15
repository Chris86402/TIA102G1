package com.tia102g1.productinfo.controller;

import com.tia102g1.orderlist.model.OrderListVO;
import com.tia102g1.orderlistinfo.model.OrderListInfoVO;
import com.tia102g1.productinfo.entity.ProductInfo;
import com.tia102g1.productinfo.model.ProductInfoServiceS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class productInfoUserController {

	@Autowired
	ProductInfoServiceS productInfoServiceS;

	/**
	 * 取得單一商品資訊
	 *
	 * @param productId
	 * @return
	 */
	// 測api
	@GetMapping("product/api/{productId}")
	public ResponseEntity<?> getProduct(@PathVariable Integer productId) {
		ProductInfo product = productInfoServiceS.getOneProductInfo(productId);
		Map<String, String> map = new HashMap<>();
//        System.out.println(product.toString());
		map.put("productId", product.getProductId().toString());
		map.put("productName", product.getProName());
		map.put("productPrice", product.getProPrice().toString());
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}

	@GetMapping("product/{productId}")
	public String getProduct(@PathVariable Integer productId, Model model) {
		ProductInfo product = productInfoServiceS.getOneProductInfo(productId);
		model.addAttribute("product", product);

        //計算商品的平均星星數
        Integer averageRating = product.getCommentStars() / product.getCommentUsers();
        model.addAttribute("averageRating", averageRating);
        return "/frontendapp/productDetails";
    }

	// 商品總覽
	@GetMapping({ "/productcategory", "/productCategory.html" })
	public String frontendCategory(Model model) {
		List<ProductInfo> list = productInfoServiceS.getAll();
		model.addAttribute("productInfoListData", list);
		return "/frontendapp/productCategory";
	}
}
