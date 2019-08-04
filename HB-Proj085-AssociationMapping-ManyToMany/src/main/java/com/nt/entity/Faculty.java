package com.nt.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Faculty implements Serializable {
	private int fid;
	private String fname;
	private String subject;
	private Set<Student> students=new HashSet<Student>();
	
	public Faculty() {
	    System.out.println("Faculty-0-param constructor");	
	}
	
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", subject=" + subject + "]";
	}

}
