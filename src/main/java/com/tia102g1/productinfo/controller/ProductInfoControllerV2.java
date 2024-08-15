package com.tia102g1.productinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tia102g1.productinfo.entity.ProductInfo;
import com.tia102g1.productinfo.service.ProductInfoService;

@RestController
public class ProductInfoControllerV2 {
	
	@Autowired
	private ProductInfoService productInfoService;

	@GetMapping("/products/{productId}")
	public ResponseEntity<ProductInfo> getProductInfo(@PathVariable Integer productId) {
		
		ProductInfo productInfo = productInfoService.getProductInfoById(productId);
		
		if (productInfo != null) {
			return ResponseEntity.status(HttpStatus.OK).body(productInfo);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
