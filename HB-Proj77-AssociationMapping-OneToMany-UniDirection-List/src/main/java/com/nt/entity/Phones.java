package com.nt.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Phones {
    private long phoneno;
    private String numberType;
    private String provider;
    private int uid;
    
	public Phones() {
		System.out.println("Phones.Phones()");
	}
	
	@Override
	public String toString() {
		return "Phones [phoneno=" + phoneno + ", numberType=" + numberType + ", provider=" + provider + "]";
	}
	
}
