package com.tia102g1.productInfo.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tia102g1.productInfo.entity.ProductInfo;

@Service("productInfoServiceS")
public class ProductInfoServiceS {
	
	@Autowired
	ProductInfoRepository repository;
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public void addProductInfo(ProductInfo productInfo) {
		repository.save(productInfo);
	}

	public void updateProductInfo(ProductInfo productInfo) {
		repository.save(productInfo);
	}

	public ProductInfo getOneProductInfo(Integer productId) {
		Optional<ProductInfo> optional = repository.findById(productId);
//		return optional.get();
		return optional.orElse(null);  // public T orElse(T other) : 如果值存在就回傳其值，否則回傳other的值
	}

	public List<ProductInfo> getAll() {
		return repository.findAll();
	}

	public List<ProductInfo> getAll(Map<String, String[]> map) {
		return HibernateUtil_CompositeQuery_ProductInfo.getAllC(map,sessionFactory.openSession());
	}

}
