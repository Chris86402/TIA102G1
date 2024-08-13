package com.tia102g1.csform.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CsFormRepository extends JpaRepository<CsFormVO, Integer>{

	@Transactional
	@Modifying
	@Query(value = "delete from csform where csFormId =?1", nativeQuery = true)
	void deleteByCsFormId(int csFormId);
}
