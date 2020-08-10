package com.nit.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nit.exceptions.ApiError;
import com.nit.exceptions.NoSsnFoundExcwption;
import com.nit.model.SnnEnrolmentRequest;
import com.nit.service.SaaService;

@RestController
@RestControllerAdvice
public class SnnEnrolmentController {
	
	@Autowired
	private SaaService sService;
	
	@PostMapping(value="/ssnEnrollment",
			consumes="application/json")
	
	public ResponseEntity<String> SaaEnrolment(@RequestBody SnnEnrolmentRequest req){
		
		ResponseEntity<String> resp = null;
		
		Long ssn = sService.SnnEnrolment(req);
		
		String body="Your SSN Enrolment Completed Successfully Your SSN :: "+ssn;
		
		resp = new ResponseEntity<String>(body ,HttpStatus.CREATED);
		
		return resp;
		
	}
	
	
	@ExceptionHandler({NoSsnFoundExcwption.class, Exception.class})
	
	public ResponseEntity<ApiError> handleNoSsnFoundException() {
		ApiError error = new ApiError(400,"SomeThing Wrong, Not registered pls Try Again",new Date());
		
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
	}

}
