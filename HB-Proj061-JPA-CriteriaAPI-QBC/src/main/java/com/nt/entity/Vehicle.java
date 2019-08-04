package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle implements java.io.Serializable {

	private int vid;
	private String type;
	private String model;
	private String company;
	private int price;

	public Vehicle() {
	}

	public Vehicle(int vid) {
		this.vid = vid;
	}

	public Vehicle(int vid, String type, String model, String company, int price) {
		this.vid = vid;
		this.type = type;
		this.model = model;
		this.company = company;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getVid() {
		return this.vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", type=" + type + ", model=" + model + ", company=" + company + ", price="
				+ price + "]";
	}
	
	

}
