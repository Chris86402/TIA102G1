package com.tia102g1.orderlistinfo.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tia102g1.event.CompositeQuery_Event;
import com.tia102g1.event.model.EventVO;
import com.tia102g1.productinfo.entity.ProductInfo;
import com.tia102g1.producttype.model.ProductTypeVO;

@Service("orderListInfoService")
public class OrderListInfoService {

	@Autowired
	OrderListInfoRepository repository;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addOrderListInfo(OrderListInfoVO orderListInfoVO) {
		repository.save(orderListInfoVO);
	}

	public void updateOrderListInfo(OrderListInfoVO orderListInfoVO) {
		repository.save(orderListInfoVO);
	}
	
	public OrderListInfoVO getOneOrderListInfo(Integer orderListInfoId) {
		Optional<OrderListInfoVO> optional = repository.findById(orderListInfoId);
		return optional.orElse(null);
	}
	
	public List<OrderListInfoVO> getAll(){
		return repository.findAll();
	}
	
	public List<OrderListInfoVO> getOrderListInfosByOrderListId(Integer orderListId) {
        return repository.findByOrderListVOOrderListId(orderListId);
    }
}
