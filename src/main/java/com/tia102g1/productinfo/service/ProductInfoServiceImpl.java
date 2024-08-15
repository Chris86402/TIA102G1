package com.tia102g1.productinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tia102g1.productinfo.dao.ProductInfoDaoV2;
import com.tia102g1.productinfo.entity.ProductInfo;

@Component
public class ProductInfoServiceImpl implements ProductInfoService{

	@Autowired
	private ProductInfoDaoV2 productInfoDao;
	
	@Override
	public ProductInfo getProductInfoById(Integer productId) {
		return productInfoDao.getProductInfoById(productId);
	}

}
