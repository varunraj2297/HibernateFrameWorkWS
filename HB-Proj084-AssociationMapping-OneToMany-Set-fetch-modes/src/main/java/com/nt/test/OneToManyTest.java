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
		//dao.loadDataNplus1SelectSolutionUsingHQL();
		//dao.loadDataNplus1SelectSolutionUsingJPACriteria();
		dao.loadDataNplus1SelectSolutionUsingQBC();
		//dao.loadDataNplus1SelectSolutionUsingProperties();
		//dao.loadDataUsingStreamAPI();
		//dao.loadDataUsingParentByUserId(1);
		//dao.deleteDataUsingParentByUserId(1);
		//dao.deleteAllChildsOfAParentByUserId(3);
		//dao.deleteOneChildfromCollectionOfChildsOfAParentByUserId(2);
		
		HibernateUtil.closeSessionFactory();
	}
}
