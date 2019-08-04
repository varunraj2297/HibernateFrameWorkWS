package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class AddressDetails implements Serializable {
	private String houseno;
	private String street;
	private String area;
	private String city;
	private int pinCode;
}
