package com.nit.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.SnnMasterEntity;
import com.nit.entity.StateMasterEntity;
import com.nit.exceptions.NoSsnFoundExcwption;
import com.nit.model.SnnEnrolmentRequest;
import com.nit.repository.SnnMasterRepository;
import com.nit.repository.StateMasterRepository;

@Service
public class SaaServiceImpl implements SaaService {
	
	@Autowired
	private SnnMasterRepository snnRepo;
	@Autowired
	private StateMasterRepository stateRepo;

	
	@Override
	public Long SnnEnrolment(SnnEnrolmentRequest req) {
		
		SnnMasterEntity sme = new SnnMasterEntity();
		
		BeanUtils.copyProperties(req, sme);
		
		SnnMasterEntity savedEntity= snnRepo.save(sme);
		if(savedEntity!=null) {
			
			return savedEntity.getSsn();
		}else {
			throw new NoSsnFoundExcwption("Ssn Number not Register Successfully Please Try Again");
		}
	}

	@Override
	public List<String> getAllStates() {
		// TODO Auto-generated method stub
		return stateRepo.findByStateNames();
	}

	
	@Override
	public String checkEnrolment(Long ssn, String stateName) {
		SnnMasterEntity entity = snnRepo.findBySsnAndStateName(ssn, stateName);
		
		if(entity !=null) {
		return "Valid";
		}
		return "Invalid";
	}

}
