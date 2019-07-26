package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="ANNO_STUDENT_O2O_PK")
@Entity
public class Student implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int sid;
	
	@Column(length=10)
	@Type(type="string")
    private String sname;
	
	@Column(scale=10,precision=2)
	@Type(type="float")
    private float coursefee;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="student")
    private LibraryMembership library;
    
	public Student() {
	        System.out.println("Student-0-param constructor");
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", coursefee=" + coursefee + "]";
	}
}
