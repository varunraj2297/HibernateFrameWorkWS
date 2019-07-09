package com.nt.dao;

import org.jboss.jandex.Main;

public class ManyToManyDAOFactory {
	
	public  static  ManyToManyDAO  getInstance() {
		return  new ManyToManyDAOImpl();
	}

}
