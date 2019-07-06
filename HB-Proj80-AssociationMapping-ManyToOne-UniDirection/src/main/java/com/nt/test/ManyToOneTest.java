package com.nt.test;

import com.nt.dao.ManyToOneDAO;
import com.nt.dao.ManyToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class ManyToOneTest {
	
	public static void main(String[] args) {
		ManyToOneDAO dao=null;
		dao=ManyToOneDAOFactory.getInstance();
		
		dao.saveData();
		//dao.loadData();
		//dao.loadDataUsingStreamAPI();
		//dao.loadDataUsingParentByUserId(1);
		//dao.deleteDataUsingParentByUserId(1);
		//dao.deleteAllChildsOfAParentByUserId(3);
		//dao.deleteOneChildfromCollectionOfChildsOfAParentByUserId();
		//dao.deleteAllChildsWithParent();
		
		HibernateUtil.closeSessionFactory();
	}
}
