package com.nt.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department implements Serializable {
	private int deptno;
	private String dname;
	private String dloc;
	
	public Department() {
		System.out.println("Department 0-param con");
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", dname=" + dname + ", dloc=" + dloc + "]";
	}
}
