package com.tia102g1.addon.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddOnRepository  extends JpaRepository<AddOn, Integer> {
	
	List<AddOn> findByProductInfoMain_ProductId(Integer productInfoMain);
	List<AddOn> findByStatus(Integer status); 

}
