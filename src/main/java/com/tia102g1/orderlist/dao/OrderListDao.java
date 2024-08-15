package com.tia102g1.orderlist.dao;

import java.util.List;

import com.tia102g1.orderlist.dto.OrderListQueryParams;
import com.tia102g1.orderlist.model.OrderListVO;
import com.tia102g1.orderlistinfo.model.OrderListInfoVO;

public interface OrderListDao {
	
//	//查詢訂單總筆數
//	Integer countOrder(OrderListQueryParams orderQueryParams);
	
	//取得所有訂單資料
	List<OrderListVO> getOrders(OrderListQueryParams orderQueryParams);
	
	//查詢訂單主檔
	OrderListVO getOrderById(Integer orderListId);
	
	//查詢訂單主檔中的訂單明細
	List<OrderListInfoVO> getOrderListInfosByOrderId(Integer orderListId);
	
	//新增訂單主檔
	Integer createOrderList(Integer memberId, Integer totalAmount);
	
	//新增訂單明細
	void createOrderListInfos(Integer orderListId, List<OrderListInfoVO> orderListInfoList);
}
