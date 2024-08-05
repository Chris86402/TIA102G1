package com.tia102g1.sysmsg.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tia102g1.sysmsg.CompositeQuery_SysMsg;

@Service("sysMsgService")
public class SysMsgService {
	
	@Autowired
	SysMsgRepository repo;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addSysMsg(SysMsgVO sysMsgVO) {
		repo.save(sysMsgVO);
	}
	
	public void updateSysMsg(SysMsgVO sysMsgVO) {
		repo.save(sysMsgVO);
	}
	
	public void deleteSysMsg(Integer sysMsgId) {
		if(repo.existsById(sysMsgId))
			repo.deleteBySysMsgId(sysMsgId);
	}
	
	public SysMsgVO getOneSysMsg(Integer sysMsgId) {
		Optional<SysMsgVO> optional = repo.findById(sysMsgId);
		return optional.orElse(null);
	}
	
	public List<SysMsgVO> getAll(){
		return repo.findAll();
	}
	
	public List<SysMsgVO> getAll(Map<String, String[]> map){
		return CompositeQuery_SysMsg.getAllC(map,sessionFactory.openSession());
	}

}
