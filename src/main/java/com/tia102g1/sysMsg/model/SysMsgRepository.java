package com.tia102g1.sysMsg.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SysMsgRepository extends JpaRepository<SysMsgVO, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "delete from SYSMSG where sysMsgId = ?1", nativeQuery = true)
	void deleteBySysMsgId(int sysMsgId);

	@Query(value = "from SysMsgVO where type = ?1 and msgTitle = ?2 and msgContent = ?3 and status = ?4 order by sysMsgId")
	List<SysMsgVO> findByOthers(int type, String msgTitle, String msgContent, int status);
}
