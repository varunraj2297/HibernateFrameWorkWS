package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;
import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name="INH_PAYMENT_TPSC")
@Inheritance(strategy=InheritanceType.JOINED)
@Data
//@DiscriminatorColumn(name="PAYMENT_MODE",length=15,discriminatorType=DiscriminatorType.STRING)
//@Polymorphism(type=PolymorphismType.EXPLICIT)  //no effect will be in the o/p
public abstract class Payment { 
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(length=15)
	 @Type(type="long")
     private long txid;
	 @Column(length=15)
	 @Type(type="string")
	 private String name;
	 @Column(length=15)
	 @Type(type="float")
     private float amount;
}
