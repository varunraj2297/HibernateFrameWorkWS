package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentId implements Serializable {
	private int sid;
	private String course;
}
