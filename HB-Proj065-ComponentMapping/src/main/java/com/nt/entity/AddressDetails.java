package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class AddressDetails implements Serializable {
	private String houseno;
	private String street;
	private String area;
	private String city;
	private int pinCode;
}
