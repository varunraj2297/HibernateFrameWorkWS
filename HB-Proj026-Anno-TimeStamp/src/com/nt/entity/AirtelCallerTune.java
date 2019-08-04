package com.nt.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name="AIRTELCALLERTUNE2")
public class AirtelCallerTune {
	
	@Id
	@Column(name="custId",length=10)
	@Type(type="int")
	private int custId;
	
	@Column(name="custName",length=20)
	@Type(type="string")
	private String custName;

	@Column(name="mobileNo",length=6)
	@Type(type="long")
	private Long mobileNo;
	
	@Column(name="callerTune",length=15)
	@Type(type="string")
	private String callerTune;

	@CreationTimestamp
	@Column(name="subscribedTime")
	@Type(type="timestamp")
	private Timestamp subscribedTime;
	
	@UpdateTimestamp
	@Column(name="lastUpdatedTime")
	@Type(type="timestamp")
	private Timestamp lastUpdatedTime;
	
	@Version
	@Column(name="updationsCount",length=10)
    @Type(type="int")
	private int updationsCount;
	
}
