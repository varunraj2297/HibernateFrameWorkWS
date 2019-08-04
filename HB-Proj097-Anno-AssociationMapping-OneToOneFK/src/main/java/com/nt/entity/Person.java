package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="O2O_ANNO_PERSON")
public class Person implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(length=10)
    @Type(type="int")
	private int pid;
    @Column(length=10)
    @Type(type="string")
    private String pname;
    @Column(length=6)
    @Type(type="byte")
    private byte age;

    public Person() {
		System.out.println("Person-0-param constructor");
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", age=" + age + "]";
	}

}

