package com.nt.test;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToManyTest {
      public static void main(String[] args) {
		OneToManyDAO dao=null;
		dao=OneToManyDAOFactory.getInstance();
 
		//dao.saveDataUsingParent();
		//dao.saveDataUsingChilds();
	  //  dao.loadData();
		dao.loadDataUsingQBC();
		//dao.deleteOneChildOfAParent();
		HibernateUtil.closeSessionFactory();
      }
}
