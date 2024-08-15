package com.tia102g1.orderlist.service;

import java.util.List;

import com.tia102g1.orderlist.dto.CreateOrderListRequest;
import com.tia102g1.orderlist.dto.OrderListQueryParams;
import com.tia102g1.orderlist.model.OrderListVO;
import com.tia102g1.orderlistinfo.model.OrderListInfoVO;

public interface OrderListService {
	
//	//查詢訂單筆數
//	Integer countOrder(OrderListQueryParams orderListQueryParams);
	
	//查詢所有歷史訂單
	List<OrderListVO> getOrders(OrderListQueryParams orderListQueryParams);
	
	//單筆查詢訂單主檔
	OrderListVO getOrderById(Integer orderListId);
	
	//新增訂單
	Integer createOrderList(Integer memberId, CreateOrderListRequest createOrderListRequest);
	
}
