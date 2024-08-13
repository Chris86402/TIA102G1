package com.tia102g1.csform.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tia102g1.csform.CompositeQuery_CsForm;
import com.tia102g1.csform.model.CsFormRepository;
import com.tia102g1.csform.model.CsFormVO;

@Service("csFormService")
public class CsFormService {
	
	@Autowired
	CsFormRepository repository;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//新增
	public void addCsForm(CsFormVO csFormVO) {
		repository.save(csFormVO);
	}
	
	//修改
	public void updateCsForm(CsFormVO csFormVO) {
		repository.save(csFormVO);
	}
	
	//刪除
	public void deleteCsForm(Integer csFormId) {
		if(repository.existsById(csFormId)) {
			repository.deleteByCsFormId(csFormId);
		}	
	}
	
	//單筆查詢
	public CsFormVO getOneCsForm(Integer csFormId) {
		Optional<CsFormVO> optional = repository.findById(csFormId);
		return optional.orElse(null); //如果有查到資料就回傳VO物件,否則就回傳null
	}
	
	//全部查詢
	public List<CsFormVO> getAll(){
		return repository.findAll();
	}
	
	//複合查詢
	public List<CsFormVO> getAll(Map<String, String[]> map){
		return CompositeQuery_CsForm.getAllC(map, sessionFactory.openSession());
	}
	
}
