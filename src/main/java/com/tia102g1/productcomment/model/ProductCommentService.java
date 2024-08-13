package com.tia102g1.productcomment.model;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProductCommentService")
public class ProductCommentService {
	
	@Autowired
	ProductCommentRepository repository;
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public void addProductCommentVO(ProductCommentVO productCommentVO) {
		repository.save(productCommentVO);
	}

	public void updateProductCommentVO(ProductCommentVO productCommentVO) {
		repository.save(productCommentVO);
	}

	public ProductCommentVO getOneProductCommentVO(Integer proCommentId) {
		Optional<ProductCommentVO> optional = repository.findById(proCommentId);
//		return optional.get();
		return optional.orElse(null);  // public T orElse(T other) : 如果值存在就回傳其值，否則回傳other的值
	}

	public List<ProductCommentVO> getAll() {
		return repository.findAll();
	}
	
	public List<ProductCommentVO> getOneMemberComment(Integer memberId) {
		return repository.findByMember_MemberId(memberId);
	}
	
	public List<ProductCommentVO> getOneProdComment(Integer productId) {
		return repository.findByProductInfo_ProductId(productId);
	}

//	public List<ProductCommentVO> getAll(Map<String, String[]> map) {
//		return CompositeQuery_ProductCommentVO.getAllC(map,sessionFactory.openSession());
//	}

}
