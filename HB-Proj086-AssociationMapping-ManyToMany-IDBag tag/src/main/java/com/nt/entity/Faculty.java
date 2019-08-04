package com.nt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Faculty implements Serializable {
	private int fid;
	private String fname;
	private String subject;
	private List<Student> students=new ArrayList<Student>();
	
	public Faculty() {
	    System.out.println("Faculty-0-param constructor");	
	}
	
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", subject=" + subject + "]";
	}

}
