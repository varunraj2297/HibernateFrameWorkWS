package com.nt.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee extends Person {
	private String desg;
	private float salary;

	@Override
	public String toString() {
		return "Employee [desg=" + desg + ", salary=" + salary + ", toString()=" + super.toString() + "]";
	}

}
