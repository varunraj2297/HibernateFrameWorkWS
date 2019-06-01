package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="Employee")
public class Employee implements Serializable {
	@Id
	@Basic
	
	/*@GeneratedValue(strategy=GenerationType.SEQUENCE)*/ //working in both orcl n mysl uses hibernate_sequence as table in mysql and seq in orcl by default
	/*@GeneratedValue(strategy=GenerationType.IDENTITY)*/ //works in mysql but not in orcl
	
	/*@SequenceGenerator(name="gen1",initialValue=500 ,allocationSize=1 ,sequenceName="eid_seq12")
	@GeneratedValue(generator="gen1")*/       //working in both orcl n mysl but  uses eid_seq12 as table in mysql and seq in orcl by default
	
	@TableGenerator(name="gen1",table="eid_tab",initialValue=200,pkColumnName="eid",allocationSize=5)
	
	private int eno;
	@Basic
	private String ename;
   @Column(name="JOB",length=15)
   @Type(type="string")
	private String desg;
   @Column(name="SAL",length=10)
   @Type(type="float")
   private float salary;
	
}
