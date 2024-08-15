package com.tia102g1.orderlist.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tia102g1.orderlist.model.OrderListVO;

public class OrderListRowMapper implements RowMapper<OrderListVO> {
	
	@Override
	public OrderListVO mapRow(ResultSet resultSet, int i) throws SQLException {
		
		OrderListVO orderList = new OrderListVO();
		
		orderList.setOrderListId(resultSet.getInt("orderListId"));
		
		orderList.setMemberIdRM(resultSet.getInt("memberId"));
		orderList.setCouponIdRM(resultSet.getInt("couponId"));
		orderList.setEventIdRM(resultSet.getInt("eventId"));
		
		orderList.setOrderDt(resultSet.getTimestamp("orderDt"));
		orderList.setOrderAmount(resultSet.getInt("orderAmount"));
		orderList.setCouponUsedAmount(resultSet.getInt("couponUsedAmount"));
		orderList.setCoinUsedAmount(resultSet.getInt("coinUsedAmount"));
		orderList.setPayAmount(resultSet.getInt("payAmount"));
		orderList.setOrderStatus(resultSet.getInt("orderStatus"));
		orderList.setPaymentMethod(resultSet.getInt("paymentMethod"));
		orderList.setPaymentStatus(resultSet.getInt("paymentStatus"));
		orderList.setPickupMethod(resultSet.getInt("pickupMethod"));
		orderList.setUseCoupon(resultSet.getInt("useCoupon"));
		orderList.setUseCoin(resultSet.getInt("useCoin"));
		orderList.setCardHolder(resultSet.getString("cardHolder"));
		orderList.setCardNumber(resultSet.getString("cardNumber"));
		orderList.setCardYy(resultSet.getInt("cardYy"));
		orderList.setCardMm(resultSet.getString("cardMm"));
		orderList.setCardVerifyCode(resultSet.getString("cardVerifyCode"));
		orderList.setInvoiceWay(resultSet.getInt("invoiceWay"));
		orderList.setInvoiceTaxNo(resultSet.getString("invoiceTaxNo"));
		orderList.setInvoiceMobileCode(resultSet.getString("invoiceMobileCode"));
		orderList.setRecipientName(resultSet.getString("recipientName"));
		orderList.setRecipientPhone(resultSet.getString("recipientPhone"));
		
		orderList.setRecipientCntRM(resultSet.getInt("recipientCnt"));
		orderList.setRecipientDistRM(resultSet.getInt("recipientDist"));

		orderList.setRecipientAddress(resultSet.getString("recipientAddress"));
		orderList.setCreatedBy(resultSet.getString("createdBy"));
		orderList.setDateCreated(resultSet.getTimestamp("dateCreated"));
		orderList.setLastUpdatedBy(resultSet.getString("lastUpdatedBy"));
		orderList.setLastUpdated(resultSet.getTimestamp("lastUpdated"));
		
		return orderList;
	}
	



}

