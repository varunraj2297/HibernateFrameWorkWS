package com.nt.test;

import com.nt.dao.AuthDAO;
import com.nt.factory.AuthDAOFactory;
import com.nt.utility.HibernateUtil;

public class AuthTest {
    public static void main(String[] args) {
		AuthDAO dao=null;
		
		dao=AuthDAOFactory.getInstance();
		System.out.println(dao.authenticate("raja","rani"));
		
		HibernateUtil.closeSessionFactory();
	}
}
