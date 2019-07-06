package com.nt.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Serializable {
	private int userid;
	private String uname;
	private String address;
	private List<Phones> phones;
	
	public User() {
		System.out.println("User.User()");
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", uname=" + uname + ", address=" + address + "]";
	}
	
}
