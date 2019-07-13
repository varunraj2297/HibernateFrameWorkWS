package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibraryMembership implements Serializable{
    private int libid;
    private Date joinDate;
    private float libfee;
    private Student student;
    
	public LibraryMembership() {
		System.out.println("LibraryMembership-0-param constructor");
	}
	@Override
	public String toString() {
		return "LibraryMembership [libid=" + libid + ", joinDate=" + joinDate + ", libfee=" + libfee + "]";
	}
	
	
    
    
}
