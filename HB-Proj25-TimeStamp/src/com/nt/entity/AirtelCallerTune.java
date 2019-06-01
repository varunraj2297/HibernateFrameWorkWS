package com.nt.entity;


import java.sql.Timestamp;

import lombok.Data;
@Data
public class AirtelCallerTune {
	
	private int custId;
	private String custName;
	private Long mobileNo;
	private String callerTune;
	private Timestamp lastUpdatedTime;
	
	

}
