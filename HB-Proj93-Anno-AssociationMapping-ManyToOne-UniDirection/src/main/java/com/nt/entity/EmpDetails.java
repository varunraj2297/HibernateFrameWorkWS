package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="M2O_ANNO_EMPDETAILS")
public class EmpDetails implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=10)
	@Type(type="int")
    private int empno;
	@Column(length=15)
	@Type(type="string")
    private String ename;
	@Column(length=15)
	@Type(type="string")
    private String job;
	@Column(length=10)
	@Type(type="int")
	private int sal;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
     @JoinColumn(name="DEPT_NO",referencedColumnName="deptno")
	private Department dept;
    
	public EmpDetails() {
		System.out.println("EmpDetails 0-param constructor");
	}

	@Override
	public String toString() {
		return "EmpDetails [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + "]";
	}
	
}
