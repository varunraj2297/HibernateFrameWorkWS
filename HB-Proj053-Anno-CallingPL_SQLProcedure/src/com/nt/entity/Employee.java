package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.NamedNativeQuery;
//import javax.persistence.Table;
import javax.persistence.Table;


import org.hibernate.annotations.NamedNativeQuery;


import lombok.Data;

@Data
@Entity
@Table(name="EMPLOYEE")
@NamedNativeQuery(name="CALL_PROCEDURE", 
                  callable=true,
                  query = "{call p_get_emps_by_sal_range(?,?,?)}",
                  resultClass=Employee.class
                  )
public class Employee implements Serializable {
	@Id
	private int eno;
	private String ename;
	@Column(name="JOB")
	private String desg;
	@Column(name="SAL")
	private float salary;
	
	public Employee() {
		System.out.println("Employee-0-param con");
	}
}
