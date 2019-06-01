package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="STUDENTCOURSESINFO")
public class StudentCoursesInfo implements Serializable{
        @EmbeddedId
        @Column(name="ID")
	    private StudentId id;
        @Column(name="SNAME",length=10)
        @Type(type="string")
		private String sname;
        @Column(name="DURATION",length=5)
        @Type(type="int")
		private int duration;
        @Column(name="FEE",scale=10,precision=2)
        @Type(type="float")
		private float fee;
}
