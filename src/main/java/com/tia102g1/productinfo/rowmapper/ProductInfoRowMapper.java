package com.tia102g1.productinfo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tia102g1.productinfo.entity.ProductInfo;

public class ProductInfoRowMapper implements RowMapper<ProductInfo> {

	@Override
	public ProductInfo mapRow(ResultSet resultSet, int i) throws SQLException {
		
		ProductInfo productInfo = new ProductInfo();
		
		productInfo.setProductId(resultSet.getInt("productId"));
		productInfo.setProductTypeIdRM(resultSet.getInt("productTypeId"));
		productInfo.setProName(resultSet.getString("proName"));
		productInfo.setProPrice(resultSet.getInt("proPrice"));
		productInfo.setProSafetyStock(resultSet.getInt("proSafetyStock"));
		productInfo.setTotalCount(resultSet.getInt("totalCount"));
		productInfo.setCommentUsers(resultSet.getInt("commentUsers"));
		productInfo.setCommentStars(resultSet.getInt("commentStars"));
		productInfo.setProPic(resultSet.getBytes("proPic"));
		productInfo.setProStatus(resultSet.getInt("proStatus"));
		productInfo.setProDesc(resultSet.getString("proDesc"));
		productInfo.setCreatedBy(resultSet.getString("createdBy"));
		productInfo.setDateCreated(resultSet.getTimestamp("dateCreated"));
		productInfo.setLastUpdatedBy(resultSet.getString("lastUpdatedBy"));
		productInfo.setLastUpdated(resultSet.getTimestamp("lastUpdated"));

		return productInfo;
	}


}
