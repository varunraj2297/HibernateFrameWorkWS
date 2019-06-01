package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Bank {
	@Id
	private int cid;
	private String cname;
	private String cadd;
	private float si;
	private float ci;
}
