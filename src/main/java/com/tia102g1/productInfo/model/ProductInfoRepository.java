package com.tia102g1.productInfo.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tia102g1.productInfo.entity.ProductInfo;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer>{

}
