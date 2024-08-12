package com.tia102g1.orderlist.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tia102g1.orderlistinfo.model.OrderListInfoRepository;
import com.tia102g1.orderlistinfo.model.OrderListInfoVO;

@Service("orderListService")
public class OrderListService {

	@Autowired
	OrderListRepository repository;

	@Autowired
	OrderListInfoRepository orderListInfoRepository;

	@Autowired
	private SessionFactory sessionFactory;

	// 新增
	public void addOrderList(OrderListVO orderListVO) {
		repository.save(orderListVO);
	}

	// 修改
	public void updateOrderList(OrderListVO orderListVO) {
		repository.save(orderListVO);
	}

	// 單筆查詢
	public OrderListVO getOneOrderList(Integer orderListId) {
		Optional<OrderListVO> optional = repository.findById(orderListId);
		return optional.orElse(null); // 如果有查到資料就回傳VO物件,否則就回傳null
	}

	// 全部查詢
	public List<OrderListVO> getAll() {
		return repository.findAll();
	}

	// 複合查詢
	public List<OrderListVO> getAll(Map<String, String[]> map) {
		return CompositeQuery_OrderList.getAllC(map, sessionFactory.openSession());
	}

	// 查詢訂單主檔及其關聯的明細資料，返回 List<OrderListInfoVO>
	public List<OrderListInfoVO> getOrderListInfos(Integer orderListId) {
		// 查詢訂單主檔
		Optional<OrderListVO> optionalOrderList = repository.findById(orderListId);
		// 找到對應的訂單主檔會回傳true
		if (optionalOrderList.isPresent()) {
			OrderListVO orderList = optionalOrderList.get();
			// 確保關聯的明細資料已經加載
			return orderList.getOrderListInfoVO().stream().collect(Collectors.toList());
		}

		return List.of(); // 如果訂單主檔不存在，返回空列表
	}
}
