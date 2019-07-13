package com.nt.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student implements Serializable{
    private int sid;
    private String sname;
    private float coursefee;
    private LibraryMembership library;
    
	public Student() {
	        System.out.println("Student-0-param constructor");
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", coursefee=" + coursefee + "]";
	}
	
	
    
    
}
