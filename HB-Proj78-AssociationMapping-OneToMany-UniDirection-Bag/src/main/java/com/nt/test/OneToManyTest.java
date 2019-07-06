package com.nt.test;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToManyTest {
	
	public static void main(String[] args) {
		OneToManyDAO dao=null;
		dao=OneToManyDAOFactory.getInstance();
		
		//dao.saveData();
		//dao.loadData();
		//dao.loadDataUsingStreamAPI();
		//dao.loadDataUsingParentByUserId(1);
		//dao.deleteDataUsingParentByUserId(1);
		//dao.deleteAllChildsOfAParentByUserId(3);
		dao.deleteOneChildfromCollectionOfChildsOfAParentByUserId(1);
		
		HibernateUtil.closeSessionFactory();
	}
}
