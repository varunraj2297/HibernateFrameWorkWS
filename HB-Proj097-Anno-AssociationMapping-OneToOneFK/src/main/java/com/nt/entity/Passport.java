package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="O2O_ANNO_PASSPORT")
public class Passport implements Serializable {
	@Id
	@Column(length=10)
    @Type(type="int")
	@SequenceGenerator(name="gen1",sequenceName="passport_seq",initialValue=1000,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private int psptid;
	@Column(length=10)
    @Type(type="string")
	private String nationality;
    @Type(type="date")
	private Date validFrom;
    @Type(type="date")
    private Date validTo;
    
    @OneToOne(targetEntity=Person.class,cascade=CascadeType.ALL,orphanRemoval=true)
    @JoinColumn(name="person_id",referencedColumnName="pid")
    @LazyToOne(LazyToOneOption.PROXY)
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
