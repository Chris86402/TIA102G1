package com.tia102g1.chart.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartOrderListRepository extends JpaRepository<ChartOrderListVO, Integer>{
	
	@Query(value = "SELECT DATE_FORMAT(orderDt, '%Y-%m') AS orderDate, " +
            "SUM(CASE WHEN paymentStatus = 0 THEN payAmount ELSE 0 END) AS group1Amount, " +
            "SUM(CASE WHEN paymentStatus = 1 THEN payAmount ELSE 0 END) AS group2Amount, " +
            "SUM(CASE WHEN paymentStatus IN (2, 3) THEN payAmount ELSE 0 END) AS group3Amount " +
            "FROM OrderList " +
            "GROUP BY DATE_FORMAT(orderDt, '%Y-%m') " +
            "ORDER BY DATE_FORMAT(orderDt, '%Y-%m')", nativeQuery = true)
	List<Object[]>  findOrderSummary();
	
}
