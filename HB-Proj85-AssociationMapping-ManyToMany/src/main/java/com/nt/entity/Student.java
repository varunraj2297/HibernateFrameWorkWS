package com.nt.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student implements Serializable{
     private int sid;
     private String sname;
     private String squalification;
     private Set<Faculty> faculties=new HashSet<Faculty>();
     
     public Student() {
		System.out.println("Student-0-param constructor");
	 }

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", squalification=" + squalification + "]";
	}

	
}
