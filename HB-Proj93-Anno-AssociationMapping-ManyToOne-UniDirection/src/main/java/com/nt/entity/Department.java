package com.nt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="M2O_ANNO_DEPARTMENT")
public class Department implements Serializable {
	@Id
	@GenericGenerator(name="gen1", strategy = "sequence",
	parameters= {@Parameter(name = "sequence_name", value = "dept_seq")})
	@GeneratedValue(generator="gen1")
	@Column(name="DEPTNO")
	@Type(type="int")
	private int deptno;
	@Column(name="DNAME",length=15)
	@Type(type="string")
	private String dname;
	@Column(name="DLOC",length=15)
	@Type(type="string")
	private String dloc;
	
	public Department() {
		System.out.println("Department 0-param con");
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", dname=" + dname + ", dloc=" + dloc + "]";
	}
}
