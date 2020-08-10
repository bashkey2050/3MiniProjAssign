package com.nit.service;

import java.util.List;

import com.nit.entity.StateMasterEntity;
import com.nit.model.SnnEnrolmentRequest;

public interface SaaService {
	
	public Long SnnEnrolment(SnnEnrolmentRequest req);
	
	public List<String> getAllStates();
	
	public String checkEnrolment(Long ssn, String stateName);
	
	

}
