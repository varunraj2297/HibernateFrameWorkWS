package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue(value="CARD")
@Setter
@Getter
public class CardPayment extends Payment {
	@Column(length=15)
	@Type(type="long")
    private long cardNo;
	@Column(length=15)
	@Type(type="string")
    private String cardType;
	@Column(length=3)
	@Type(type="int")
    private int cvvNo;
	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", cvvNo=" + cvvNo + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
}
