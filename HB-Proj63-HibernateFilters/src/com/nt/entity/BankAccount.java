package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class BankAccount implements Serializable{
	private int accno;
	private String holdername;
	private int balance;
	private String status;
}
