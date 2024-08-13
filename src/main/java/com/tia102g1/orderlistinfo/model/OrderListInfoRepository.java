package com.tia102g1.orderlistinfo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListInfoRepository extends JpaRepository<OrderListInfoVO, Integer>{
	
	 List<OrderListInfoVO> findByOrderListVOOrderListId(Integer orderListId);
	
}
