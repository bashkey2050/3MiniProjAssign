package com.nit.entity;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@Table(name = "SNN_MASTER")
public class SnnMasterEntity  {
		

		public SnnMasterEntity() {
		// TODO Auto-generated constructor stub
	}
		
		

	    @Id
	    @GenericGenerator(name = "ssn", strategy = "com.nit.generator.SsnGenerator")
	    @GeneratedValue(generator = "ssn")  
		private Long ssn;
		@NonNull
		@Column(length = 50, name = "FIRSTNAME")
		private String firstName;
		@NonNull
		@Column(length = 50, name = "LASTNAME")
		private String lastName;
		@NonNull
		@Column(length = 50, name = "GENDER")
		private String gender;
		@NonNull
	
		private Date dob;
		@Column(length = 50, name = "STATENAME")
		private String stateName;
		
		@Column(name = "CREATED_DATE")
		@CreationTimestamp
		@Temporal(TemporalType.DATE)
		private Date createdDate;
		@Column(name = "UPDATED_DATE",insertable = false)
		@UpdateTimestamp
		private Date updatedDate;

	}


