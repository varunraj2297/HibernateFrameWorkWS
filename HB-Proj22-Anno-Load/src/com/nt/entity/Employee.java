package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
@Entity
@Table(name="EMPLOYEE")
@Proxy(lazy=true,proxyClass=IEmployee.class)

public final class Employee implements Serializable,IEmployee {
	
	private int eno;
	private String ename;
	private String desg;
	private float salary;
	
	@Id
	@Column(name="ENO",length=10)
	@Type(type="int")
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	
	@Column(name="ENAME",length=15)
	@Type(type="string")
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	@Column(name="JOB",length=15)
	@Type(type="string")
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	
	@Column(name="SAL",length=10,precision=3)
	@Type(type="float")
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
}
