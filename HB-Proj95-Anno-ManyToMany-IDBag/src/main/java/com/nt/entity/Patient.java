package com.nt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="M2M_ANNO_PATIENT1")
@Getter
@Setter
public class Patient implements Serializable{
	@Id
	@SequenceGenerator(name="gen1",sequenceName="pat_seq",initialValue=1,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
    @Column(length=9)
	@Type(type="int")
	private int patId;
	 @Column(length=10)
		@Type(type="string")
	private String patName;
	 @Column(length=10)
		@Type(type="string")
	private String disease;
	 
	 @ManyToMany(targetEntity=Doctor.class,
			                       cascade=CascadeType.ALL,
			                       fetch=FetchType.LAZY)
	 @JoinTable(name="M2M_ANNO_DOC_PAT1",
	                         joinColumns=@JoinColumn(name="patient_id",referencedColumnName="patId"),
	                         inverseJoinColumns=@JoinColumn(name="doctor_id",referencedColumnName="docId"))
	 @GenericGenerator(name="gen2",strategy="increment")
	 @CollectionId(columns = @Column(name="doc_pat_index",length=10) , generator = "gen2", type = @Type(type="int"))
	 private List<Doctor> doctors=new ArrayList<Doctor>();

}
