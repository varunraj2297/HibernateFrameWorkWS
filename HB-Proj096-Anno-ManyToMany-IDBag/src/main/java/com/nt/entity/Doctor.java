package com.nt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="M2M_ANNO_DOCTOR1")
@Getter
@Setter
public class Doctor implements Serializable{
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		 @Column(length=9)
		@Type(type="int")
		private int docId;
		 @Column(length=10)
			@Type(type="string")
		private String docName;
		 @Column(length=10)
			@Type(type="string")
		private String specialization;
		
		 @ManyToMany(targetEntity=Patient.class,
				                         cascade=CascadeType.ALL,
				                         fetch=FetchType.LAZY,
				                         mappedBy="doctors")
		private List<Patient> patients=new ArrayList<Patient>();
}
