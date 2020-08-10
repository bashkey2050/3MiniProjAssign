package com.nit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.SnnMasterEntity;

public interface SnnMasterRepository extends JpaRepository<SnnMasterEntity, Long> {
	
	

	public SnnMasterEntity findBySsnAndStateName(Long ssn, String stateName);

}
