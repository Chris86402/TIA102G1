package com.tia102g1.chart.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartOrderListRepository extends JpaRepository<ChartOrderListVO, Integer>{
	
	@Query(value = "SELECT DATE(orderDt) AS orderDate, " +
            "SUM(CASE WHEN paymentStatus = 1 THEN payAmount ELSE 0 END) AS group1Amount, " +
            "SUM(CASE WHEN paymentStatus = 2 THEN payAmount ELSE 0 END) AS group2Amount, " +
            "SUM(CASE WHEN paymentStatus IN (3, 4) THEN payAmount ELSE 0 END) AS group3Amount " +
            "FROM OrderList " +
            "GROUP BY DATE(orderDt) " +
            "ORDER BY DATE(orderDt)", nativeQuery = true)
	List<Object[]>  findOrderSummary();
}
