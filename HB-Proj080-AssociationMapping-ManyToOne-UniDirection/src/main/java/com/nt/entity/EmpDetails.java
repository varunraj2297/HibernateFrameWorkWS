package com.nt.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpDetails implements Serializable{
    private int empno;
    private String ename;
    private String job;
    private int sal;
    private Department dept;
    
	public EmpDetails() {
		System.out.println("EmpDetails 0-param constructor");
	}

	@Override
	public String toString() {
		return "EmpDetails [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + "]";
	}
	
}
