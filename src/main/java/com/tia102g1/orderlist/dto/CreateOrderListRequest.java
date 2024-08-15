package com.tia102g1.orderlist.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class CreateOrderListRequest {
	
	//將前端傳進來的json參數轉為java class
	@NotEmpty
	private List<BuyItem> buyItemList;

	
	public List<BuyItem> getBuyItemList() {
		return buyItemList;
	}

	public void setBuyItemList(List<BuyItem> buyItemList) {
		this.buyItemList = buyItemList;
	}
	
	
}
