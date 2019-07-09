package com.nt.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Programmer implements Serializable {
	private int pid;
	private String pname;
	private float salary;
	private Set<Project> projects=new HashSet();
	
	public Programmer() {
		System.out.println("Programmer:0-param constructor");
	}

	@Override
	public String toString() {
		return "Programmer [pid=" + pid + ", pname=" + pname + ", salary=" + salary + "]";
	}
	
	

}
