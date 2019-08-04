package com.nt.test;

import com.nt.dao.OneToOneDAO;
import com.nt.dao.OneToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToOneTest {

	public static void main(String[] args) {
		OneToOneDAO dao=null;
		
		dao=OneToOneDAOFactory.getInstance();
		
		//dao.saveDataUsingParent();
		//dao.saveDataUsingChild();
		//dao.loadData();
	    dao.deleteFromParentToChild();
		
		HibernateUtil.closeSessionFactory();

	}

}
