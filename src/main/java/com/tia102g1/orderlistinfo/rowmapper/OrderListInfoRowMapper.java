package com.tia102g1.orderlistinfo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tia102g1.orderlistinfo.model.OrderListInfoVO;

public class OrderListInfoRowMapper implements RowMapper<OrderListInfoVO>{

	@Override
	public OrderListInfoVO mapRow(ResultSet resultSet, int i) throws SQLException {
		
		OrderListInfoVO orderListInfo = new OrderListInfoVO();
		
		orderListInfo.setOrderListInfoId(resultSet.getInt("orderListInfoId"));
		orderListInfo.setOrderListIdRM(resultSet.getInt("orderListId"));
		orderListInfo.setProductIdRM(resultSet.getInt("productId"));
		orderListInfo.setPurchasedPrice(resultSet.getInt("purchasedPrice"));
		orderListInfo.setProQuantity(resultSet.getInt("proQuantity"));
		orderListInfo.setProName(resultSet.getString("ProName"));
		orderListInfo.setProPic(resultSet.getBytes("ProPic"));

		return orderListInfo;
	}

}
