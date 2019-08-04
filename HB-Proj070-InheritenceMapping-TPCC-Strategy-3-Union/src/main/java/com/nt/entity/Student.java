package com.nt.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student extends Person {
	private String result;
	private float avg;

	@Override
	public String toString() {
		return "Student [result=" + result + ", avg=" + avg + ", toString()=" + super.toString() + "]";
	}
}
