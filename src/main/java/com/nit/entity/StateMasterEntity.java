package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STATE_MASTER")
public class StateMasterEntity {
	
	@Id
	@Column(name ="STATE_ID")
	private Integer stateId;
	
	@Column(name ="STATENAME")
	private String stateName;
	

}
