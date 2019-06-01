package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	/*@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1") */         //orcl-working,mysql-working
	/*	@GenericGenerator(name="gen1",strategy="indentity")
		@GeneratedValue(generator="gen1")*/    //orcl-wont work,mysql-not working
	/*@GenericGenerator(name="gen1",strategy="seqhilo")
	@GeneratedValue(generator="gen1") */         //orcl-working but gen1 is taken as default seq 
	                                                                                 //mysql-working but gen1 is taken as default table
	/*@GenericGenerator(name="gen1",strategy="hilo")
	@GeneratedValue(generator="gen1")*/     //orcl-no,mysql-no
	/*@GenericGenerator(name="gen1",strategy="sequence")
	@GeneratedValue(generator="gen1")*/     //orcl-working but gen1 is taken as default seq 
	                                                                                //mysql-working but gen1 is taken as default table
	/*@GenericGenerator(name="gen1",strategy="sequence",
	                                      parameters= {@Parameter(name="sequence_name",value="eid_seq11")})	     
	@GeneratedValue(generator="gen1") */   //orcl-working
	                                                                                //mysql working but eid_seq11 becomes table here
	
	/*@GenericGenerator(name="gen1",strategy="seqhilo",
	                                      parameters= {@Parameter(name="sequence_name",value="eid_seq11"),
	                                    		                     @Parameter(name="max_lo",value="5")})
	@GeneratedValue(generator="gen1")*/        //orcl-working but gen1 is taken as default seq 
                                                                                       //mysql-working but gen1 is taken as default table
	 
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
