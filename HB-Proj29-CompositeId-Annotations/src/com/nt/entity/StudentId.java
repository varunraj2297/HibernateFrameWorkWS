package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Embeddable
public class StudentId implements Serializable {
	@Column(name="SID",length=5)
	@Type(type="int")
	private int sid;
	@Column(name="COURSE",length=10)
	@Type(type="string")
	private String course;
}
