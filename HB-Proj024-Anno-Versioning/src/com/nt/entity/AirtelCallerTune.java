package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

import lombok.Data;
@Data
@Entity
@Table(name="AIRTELCALLERTUNE")
public class AirtelCallerTune {
	
	@Id
	@Column(name="custId",length=10)
	@Type(type="int")
	private int custId;
	
	@Column(name="custName",length=20)
	@Type(type="string")
	private String custName;
	
	@Column(name="mobileNo",length=10)
	@Type(type="long")
	private Long mobileNo;
	
	@Column(name="callerTune",length=20)
	@Type(type="string")
	private String callerTune;
	
	@Version
	@Column(name="updationsCount",length=5)
	@Type(type="int")
	private int updationsCount;
	
	

}
