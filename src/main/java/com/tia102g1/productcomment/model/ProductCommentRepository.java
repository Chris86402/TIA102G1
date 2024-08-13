package com.tia102g1.productcomment.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductCommentRepository extends JpaRepository<ProductCommentVO, Integer>{
	List<ProductCommentVO> findByMember_MemberId(Integer memberId);
	List<ProductCommentVO> findByProductInfo_ProductId(Integer productId);
}
