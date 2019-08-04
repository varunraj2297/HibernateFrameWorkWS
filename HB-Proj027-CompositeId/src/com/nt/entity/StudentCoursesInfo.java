package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentCoursesInfo implements Serializable{
	    private StudentId id;
		private String sname;
		private int duration;
		private float fee;
}
