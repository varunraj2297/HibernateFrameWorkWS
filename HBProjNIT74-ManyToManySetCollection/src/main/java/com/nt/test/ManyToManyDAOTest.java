package com.nt.test;

import com.nt.dao.ManyToManyDAO;
import com.nt.dao.ManyToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class ManyToManyDAOTest {

	public static void main(String[] args) {
		 ManyToManyDAO dao=null;
				//get DAO
		 dao=ManyToManyDAOFactory.getInstance();
		 //invoke method
		 dao.saveDataUsingParents();
		 dao.saveDataUsingChilds();
		
		 HibernateUtil.closeSessionFactory();
	}
}
