package com.tia102g1.productinfo.dao;

import com.tia102g1.productinfo.entity.ProductInfo;

public interface ProductInfoDaoV2 {
	
	ProductInfo getProductInfoById(Integer productId);
	
	void updateStock(Integer productId, Integer stock);
}
