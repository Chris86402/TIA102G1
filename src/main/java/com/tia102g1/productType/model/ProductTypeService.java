package com.tia102g1.productType.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productTypeService")
public class ProductTypeService {

	@Autowired
	ProductTypeRepository repo;
	
	public void addType(ProductTypeVO productTypeVO) {
		repo.save(productTypeVO);
	}
	
	public void updateType(ProductTypeVO productTypeVO) {
		repo.save(productTypeVO);
	}
	
	public ProductTypeVO getOneType(Integer productTypeId) {
		Optional<ProductTypeVO> optional = repo.findById(productTypeId);
		return optional.orElse(null);
	}
	
	public List<ProductTypeVO> getAll(){
		return repo.findAll();
	}
}
