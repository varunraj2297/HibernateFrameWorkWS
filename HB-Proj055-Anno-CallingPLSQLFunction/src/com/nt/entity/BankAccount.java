package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

import lombok.Data;

@Data
@Entity
@NamedNativeQuery(name="CALL_FX",
                  callable=true,
                  resultClass=BankAccount.class,
                  query="{?=call fx_get_bacc_info_by_bal_range(?,?)}")
public class BankAccount {
	@Id
	private int acno;
	private String holderName;
	private String addrs;
	private float balance;
	public BankAccount() {
		System.out.println("BankAccount-0-param constructor");
	}
}
