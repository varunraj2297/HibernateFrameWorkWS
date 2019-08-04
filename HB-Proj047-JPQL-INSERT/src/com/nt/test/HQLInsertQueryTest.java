package com.nt.test;

import com.nt.dao.NGOMembersDAO;
import com.nt.dao.NGOMembersDAOFactory;
import com.nt.utility.HibernateUtil;

public class HQLInsertQueryTest {
	public static void main(String[] args) {
		
		NGOMembersDAO dao=null;
		int count=0;
		dao=NGOMembersDAOFactory.getInstance();
		
		count=dao.transferEmpsToNGOs(5000f, 6000f);
		
		System.out.println(count+ "no. of employees are transfered to NGO");
		
		HibernateUtil.closeSessionFactory();
		
	}	  
}
