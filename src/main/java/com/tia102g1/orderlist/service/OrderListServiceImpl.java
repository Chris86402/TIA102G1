package com.tia102g1.orderlist.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.tia102g1.cart.model.Cart;
import com.tia102g1.member.dao.MemberDao;
import com.tia102g1.member.model.Member;
import com.tia102g1.orderlist.dao.OrderListDao;
import com.tia102g1.orderlist.dto.BuyItem;
import com.tia102g1.orderlist.dto.CreateOrderListRequest;
import com.tia102g1.orderlist.dto.OrderListQueryParams;
import com.tia102g1.orderlist.model.OrderListVO;
import com.tia102g1.orderlistinfo.model.OrderListInfoVO;
import com.tia102g1.productinfo.dao.ProductInfoDaoV2;
import com.tia102g1.productinfo.entity.ProductInfo;

@Component
public class OrderListServiceImpl implements OrderListService {
	
	private final static Logger log = LoggerFactory.getLogger(OrderListServiceImpl.class); 
	
	@Autowired
	private OrderListDao orderListDao;
	
	@Autowired
	private ProductInfoDaoV2 productInfoDao;
	
	@Autowired
	private MemberDao memberDao;
	
//	//查詢訂單筆數
//	@Override
//	public Integer countOrder(OrderListQueryParams orderListQueryParams) {
//		return orderListDao.countOrder(orderListQueryParams);
//	}
	
	
	//查詢某顧客所有訂單
	@Override
	public List<OrderListVO> getOrders(OrderListQueryParams orderListQueryParams) {
		//訂單主檔
		List<OrderListVO> orderListList = orderListDao.getOrders(orderListQueryParams);
		
		//關聯的訂單明細
		for (OrderListVO orderList : orderListList) {
			List<OrderListInfoVO> orderListInfoList = orderListDao.getOrderListInfosByOrderId(orderList.getOrderListId());
			
			orderList.setOrderListInfoVO(orderListInfoList);	
		}
		
		return orderListList;
	}
	
	
	//查詢單筆訂單
	@Override
	public OrderListVO getOrderById(Integer orderListId) {
		
		//取得訂單主檔
		OrderListVO orderList = orderListDao.getOrderById(orderListId);
		
		//取得訂單主檔的訂單明細
		List<OrderListInfoVO> orderListInfoList = orderListDao.getOrderListInfosByOrderId(orderListId);
		
		//合併主檔與明細
		orderList.setOrderListInfoVO(orderListInfoList);
		
		return orderList;
	}
	

	@Transactional
	@Override
	public Integer createOrderList(Integer memberId, CreateOrderListRequest createOrderListRequest) {
		
		//檢查會員是否存在
		Member member = memberDao.getMemberById(memberId);
		
		if(member == null) {
			log.warn("該會員ID {} 不存在", memberId);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		int totalAmount = 0;
		List<OrderListInfoVO> orderListInfoList = new ArrayList<>();
		
		for(BuyItem buyItem : createOrderListRequest.getBuyItemList()) {
			
			ProductInfo productInfo = productInfoDao.getProductInfoById(buyItem.getProductId());
			
			//檢查商品是否存在、庫存是否足夠
			if(productInfo == null) {
				log.warn("商品 {} 庫存數量不足，無法購買。剩餘庫存 {}，欲購買數量 {}",
						buyItem.getProductId(), productInfo.getTotalCount(), buyItem.getQuantity());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			
			//扣除商品庫存
			//商品結餘數量-購買量
			productInfoDao.updateStock(productInfo.getProductId(), productInfo.getTotalCount() - buyItem.getQuantity());
			
			
			//總價錢 = 購買數量 * 商品價格
			int amount = buyItem.getQuantity() * productInfo.getProPrice();
			totalAmount = totalAmount + amount;
		
			//將BuyItem轉換為OrderListInfo訂單明細
			OrderListInfoVO orderListInfo = new OrderListInfoVO();
			orderListInfo.setProductIdRM(buyItem.getProductId());
			orderListInfo.setProQuantity(buyItem.getQuantity());
			orderListInfo.setPurchasedPrice(amount);
			
			orderListInfoList.add(orderListInfo);
		
		}
		
		
		//創建訂單
		Integer orderListId = orderListDao.createOrderList(memberId, totalAmount);
		
		orderListDao.createOrderListInfos(orderListId, orderListInfoList);
		
		return orderListId;
	}
	


}
