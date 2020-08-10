package com.nit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.SnnEnrolmentRequest;
import com.nit.service.SaaService;

@RestController
public class SnnValidationRestController {
	

	@Autowired
	private SaaService sService;
	
	
	@GetMapping(value="/validationSsn/{ssn}/{stateName}")
	public ResponseEntity<String> SaaEnrolment(@PathVariable ("ssn") Long ssn, @PathVariable ("stateName") String stateName){
		
		ResponseEntity<String> resp = null;
		
		 String Status= sService.checkEnrolment(ssn, stateName);
		
		
		
		resp = new ResponseEntity<String>(Status,HttpStatus.OK);
		
		return resp;
		
	}

}
