package com.tia102g1.chart.model;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderList")
public class ChartOrderListVO {
	
	@Id
	private Integer orderListId;
	
	@Column(name = "orderDt")
	private Timestamp orderDt;
	
	@Column(name = "payAmount")
	private Integer payAmount;
	
	@Column(name = "paymentStatus")
	private Integer paymentStatus;
	
	public ChartOrderListVO() {
		super();
	}

	public ChartOrderListVO(LocalDate localDate, Integer integer) {
	}

	public Integer getOrderListId() {
		return orderListId;
	}

	public void setOrderListId(Integer orderListId) {
		this.orderListId = orderListId;
	}

	public Timestamp getOrderDt() {
		return orderDt;
	}

	public void setOrderDt(Timestamp orderDt) {
		this.orderDt = orderDt;
	}

	public Integer getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Integer payAmount) {
		this.payAmount = payAmount;
	}

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
}
