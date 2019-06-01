package com.nt.test;

import com.nt.dao.StudentCoursesInfoDAO;
import com.nt.dao.StudentCoursesInfoDAOFactory;
import com.nt.util.HibernateUtil;

public class CompositeIdTest {

	public static void main(String[] args) {
		StudentCoursesInfoDAO dao=null;
		
		dao=StudentCoursesInfoDAOFactory.getInstance();
		//dao.saveData();
		dao.loadData();

		HibernateUtil.closeSessionFactory();
	}

}
