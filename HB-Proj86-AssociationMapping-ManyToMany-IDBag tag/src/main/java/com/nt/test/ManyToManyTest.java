package com.nt.test;

import com.nt.dao.ManyToManyDAO;
import com.nt.dao.ManyToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class ManyToManyTest {

	public static void main(String[] args) {
		ManyToManyDAO dao=null;
		
		dao=ManyToManyDAOFactory.getInstance();
		
		//dao.saveDataUsingParent();
		dao.saveDataUsingChilds();
		
		HibernateUtil.closeSessionFactory();
	}
}
