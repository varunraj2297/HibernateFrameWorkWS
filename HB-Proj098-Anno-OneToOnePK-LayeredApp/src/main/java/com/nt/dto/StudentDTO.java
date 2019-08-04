package com.nt.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class StudentDTO implements Serializable{
    
	private int srno;
    private int sid;
    private String sname;
    private float coursefee;
    private LibraryMembershipDTO library;
    
	public StudentDTO() {
	        System.out.println("Student-0-param constructor");
	}

	@Override
	public String toString() {
		return "StudentDTO [srno=" + srno + ", sid=" + sid + ", sname=" + sname + ", coursefee=" + coursefee + "]";
	}
	
	
}
