package com.nit.model;

import java.util.Date;

import lombok.Data;


@Data
public class SnnEnrolmentRequest {
	
	private Long SSN;
	
	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private Date dob;
	
	private String stateName;
	

}
