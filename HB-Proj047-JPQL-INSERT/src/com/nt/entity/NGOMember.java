package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class NGOMember implements Serializable {
	private int ngoid;
	private String ngoname;
	private String desg;
	private float salary;
	
	public NGOMember() {
		System.out.println("NGOMember-0-param con");
	}
}
