package com.tia102g1.productinfo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.tia102g1.productinfo.entity.ProductInfo;
import com.tia102g1.productinfo.rowmapper.ProductInfoRowMapper;

@Component
public class ProductInfoDaoV2Impl implements ProductInfoDaoV2 {

	@Autowired
	private NamedParameterJdbcTemplate npjt;
	
	//單筆查詢商品
	@Override
	public ProductInfo getProductInfoById(Integer productId) {

		String sql = "SELECT productId, productTypeId, proName, proPrice, "
				+ "proSafetyStock, totalCount, commentUsers, commentStars, "
				+ "proPic, proStatus, proDesc, createdBy, dateCreated, lastUpdatedBy, lastUpdated " 
				+ "FROM productInfo WHERE productId = :productId";

		Map<String, Object> map = new HashMap<>();
		map.put("productId", productId);

		List<ProductInfo> productInfoList = npjt.query(sql, map, new ProductInfoRowMapper());

		if (productInfoList.size() > 0) {
			return productInfoList.get(0);
		} else {
			return null;
		}
	}

	//更新商品庫存
	@Override
	public void updateStock(Integer productId, Integer stock) {
		
		String sql = "UPDATE productInfo SET totalCount = :totalCount "
				+ "WHERE productId = :productId";
		
		Map<String, Object> map = new HashMap<>();
		map.put("productId", productId);
		map.put("totalCount", stock);
		
		npjt.update(sql, map);
		
	}

}
