package com.nt.test;

import com.nt.dao.OneToOneDAO;
import com.nt.dao.OneToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToOneFKTest {
	public static void main(String[] args) {
       OneToOneDAO dao=null;
       
       dao=OneToOneDAOFactory.getInstance();
       //dao.saveDataUsingChild();
       dao.loadData();
       HibernateUtil.closeSessionFactory();
       
	}
}
