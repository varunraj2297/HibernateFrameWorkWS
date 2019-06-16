package com.nt.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="PERSONPROFILE")
public class PersonProfile {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int idno;
    private String name;
    private String gender;
    private int age;
    @Embedded
    private AddressDetails addrs;
}
