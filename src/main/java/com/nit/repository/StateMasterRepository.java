package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.StateMasterEntity;

public interface StateMasterRepository extends JpaRepository<StateMasterEntity, Integer>{
	
	@Query(value="select stateName from StateMasterEntity")
	public List<String> findByStateNames();

}
