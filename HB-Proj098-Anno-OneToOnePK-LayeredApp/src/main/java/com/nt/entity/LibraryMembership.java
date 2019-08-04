package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="ANNO_LIB_O2O_PK")
@Entity
public class LibraryMembership implements Serializable{
   @Id
   @GenericGenerator(name="gen1",strategy="foreign",parameters=@Parameter(name = "property", value = "student"))
   @GeneratedValue(generator="gen1")
   @Column(length=10)
   @Type(type="int")
	private int libid;
   @Type(type="date")
    private Date joinDate;
   @Column(scale=10,precision=2)
   @Type(type="float")
    private float libfee;
   
   @OneToOne(targetEntity=Student.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
   @PrimaryKeyJoinColumn(name="libid",referencedColumnName="sid")
    private Student student;
    
	public LibraryMembership() {
		System.out.println("LibraryMembership-0-param constructor");
	}
	@Override
	public String toString() {
		return "LibraryMembership [libid=" + libid + ", joinDate=" + joinDate + ", libfee=" + libfee + "]";
	}

}
