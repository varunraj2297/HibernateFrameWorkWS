package com.nt.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class LibraryMembershipDTO implements Serializable {
	private int libid;
	private Date joinDate;
	private float libfee;
	private StudentDTO student;

	public LibraryMembershipDTO() {
		System.out.println("LibraryMembership-0-param constructor");
	}

	@Override
	public String toString() {
		return "LibraryMembership [libid=" + libid + ", joinDate=" + joinDate + ", libfee=" + libfee + "]";
	}

}
