package com.tia102g1.orderlist.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.tia102g1.orderlist.dto.OrderListQueryParams;
import com.tia102g1.orderlist.model.OrderListVO;
import com.tia102g1.orderlist.rowmapper.OrderListRowMapper;
import com.tia102g1.orderlistinfo.model.OrderListInfoVO;
import com.tia102g1.orderlistinfo.rowmapper.OrderListInfoRowMapper;

@Component
public class OrderListDaoImpl implements OrderListDao {

	@Autowired
	private NamedParameterJdbcTemplate npjt;
	
//	@Override
//	public Integer countOrder(OrderListQueryParams orderQueryParams) {
//		String sql = "SELECT count(*) FROM orderList WHERE 1=1";
//		
//		Map<String, Object> map = new HashMap<>();
//		
//		//查詢條件
//		sql = addFilteringSql(sql, map, orderQueryParams);
//		
//		Integer total = npjt.queryForObject(sql, map, Integer.class);
//		
//		return total;
//	}
	
	
	//查詢所有訂單
	@Override
	public List<OrderListVO> getOrders(OrderListQueryParams orderListQueryParams) {
		
		String sql = "SELECT orderListId, memberId, couponId, eventId, orderDt, orderAmount, couponUsedAmount, "
				+ "coinUsedAmount, payAmount, orderStatus, paymentMethod, paymentStatus, pickupMethod, useCoupon, "
				+ "useCoin, cardHolder, cardNumber, cardYy, cardMm, cardVerifyCode, invoiceWay, invoiceTaxNo, "
				+ "invoiceMobileCode, recipientName, recipientPhone, recipientCnt, recipientDist, recipientAddress, "
				+ "createdBy, dateCreated, lastUpdatedBy, lastUpdated "
				+ "FROM orderList "
				+ "WHERE memberId = :memberId "
				+ "ORDER BY dateCreated desc, orderListId asc";
		
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", orderListQueryParams.getMemberId());
		
		List<OrderListVO> orderListList = npjt.query(sql, map, new OrderListRowMapper());
		
		return orderListList;
	}
	
	

	// 查詢訂單主檔
	@Override
	public OrderListVO getOrderById(Integer orderListId) {

		String sql = "SELECT orderListId, memberId, couponId, eventId, orderDt, orderAmount, couponUsedAmount, "
				+ "coinUsedAmount, payAmount, orderStatus, paymentMethod, paymentStatus, pickupMethod, useCoupon, "
				+ "useCoin, cardHolder, cardNumber, cardYy, cardMm, cardVerifyCode, invoiceWay, invoiceTaxNo, "
				+ "invoiceMobileCode, recipientName, recipientPhone, recipientCnt, recipientDist, recipientAddress, "
				+ "createdBy, dateCreated, lastUpdatedBy, lastUpdated FROM orderList WHERE orderListId = :orderListId";

		Map<String, Object> map = new HashMap<>();
		map.put("orderListId", orderListId);

		List<OrderListVO> orderList = npjt.query(sql, map, new OrderListRowMapper());

		if (orderList.size() > 0) {
			return orderList.get(0);
		} else {
			return null;
		}
	}
	
	//查詢訂單明細
	@Override
	public List<OrderListInfoVO> getOrderListInfosByOrderId(Integer orderListId) {
		//以訂單主檔找出對應的訂單明細與商品資訊
		String sql = "SELECT o1.orderListInfoId, o1.orderListId, o1.productId, o1.purchasedPrice, "
				+ "o1.proQuantity, p.proName, p.proPic "
				+ "FROM orderListInfo as o1 "
				+ "LEFT JOIN productInfo as p ON o1.productId = p.productId "
				+ "WHERE o1.orderListId = :orderListId";
		
		Map<String, Object> map = new HashMap<>();
		map.put("orderListId", orderListId);

		List<OrderListInfoVO> orderListInfoList = npjt.query(sql, map, new OrderListInfoRowMapper());

		return orderListInfoList;
	}

	// 新增訂單主檔資料
	@Override
	public Integer createOrderList(Integer memberId, Integer totalAmount) {

		String sql = "INSERT INTO orderList(memberId, couponId, eventId, orderDt, orderAmount, couponUsedAmount, "
				+ "coinUsedAmount, payAmount, orderStatus, paymentMethod, paymentStatus, pickupMethod, useCoupon, "
				+ "useCoin, cardHolder, cardNumber, cardYy, cardMm, cardVerifyCode, invoiceWay, invoiceTaxNo, "
				+ "invoiceMobileCode, recipientName, recipientPhone, recipientCnt, recipientDist, recipientAddress, "
				+ "createdBy, lastUpdatedBy) "
				+ "VALUES (:memberId, null, null, '2024-05-31', :orderAmount, 0, 350, 4350, 1, 2, 1, 2, 0, 1, '廖嘉銀', '', "
				+ "null, '', '', 2, '', 'BJH469', '廖嘉銀', '0913556230', 8, 350, '福德路22號', '廖嘉銀', 'chris')";

		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("orderAmount", totalAmount);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		npjt.update(sql, new MapSqlParameterSource(map), keyHolder);

		int orderListId = keyHolder.getKey().intValue();

		return orderListId;
	}

	// 新增訂單明細資料
	@Override
	public void createOrderListInfos(Integer orderListId, List<OrderListInfoVO> orderListInfoList) {

		String sql = "INSERT INTO orderListInfo (orderListId, productId, purchasedPrice, proQuantity, createdBy, lastUpdatedBy) "
				+ "values (:orderListId, :productId, :purchasedPrice, :proQuantity, 'chris', 'chris')";

		// batchUpdate批次新增資料
		MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[orderListInfoList.size()];

		for (int i = 0; i < orderListInfoList.size(); i++) {
			OrderListInfoVO orderListInfo = orderListInfoList.get(i);

			parameterSources[i] = new MapSqlParameterSource();
			parameterSources[i].addValue("orderListId", orderListId);
			parameterSources[i].addValue("productId", orderListInfo.getProductIdRM()); // 訂單明細的商品id
			parameterSources[i].addValue("purchasedPrice", orderListInfo.getPurchasedPrice()); // 訂單明細的商品購買單價
			parameterSources[i].addValue("proQuantity", orderListInfo.getProQuantity()); // 訂單明細的商品購買數量

		}

		npjt.batchUpdate(sql, parameterSources);
	}


}
