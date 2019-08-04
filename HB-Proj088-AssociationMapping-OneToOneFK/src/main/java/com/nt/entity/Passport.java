package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passport implements Serializable {
	private int psptid;
	private String nationality;
	private Date validFrom;
	private Date validTo;
	private Person person;

	public Passport() {
	     System.out.println("Passport-0-param constructor");
	}

	@Override
	public String toString() {
		return "Passport [psptid=" + psptid + ", nationality=" + nationality + ", validFrom=" + validFrom + ", validTo="
				+ validTo + "]";
	}

}
