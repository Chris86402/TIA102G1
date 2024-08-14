package com.tia102g1.addon.model;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addOnService")
public class AddOnService {

	@Autowired
	AddOnRepository repository;

	@Autowired
	private SessionFactory sessionFactory;

	// 單筆查詢
	public AddOn getOneAddOn(Integer addOnId) {
		Optional<AddOn> optional = repository.findById(addOnId);
		return optional.orElse(null); // 如果有查到資料就回傳VO物件,否則就回傳null
	}

	// 全部查詢
	public List<AddOn> getAll() {
		return repository.findAll();
	}
	
	public List<AddOn> getByProductId(Integer productInfoMain){
		return repository.findByProductInfoMain_ProductId(productInfoMain);
	}
	
	public List<AddOn> getByStatus(Integer status){
		return repository.findByStatus(status);
	}
	
	// 新增
	public void addAddOn(AddOn addOn) {
		repository.save(addOn);
	}
	
	// 修改
	public void updateAddOn(AddOn addOn) {
		repository.save(addOn);
	}

}
