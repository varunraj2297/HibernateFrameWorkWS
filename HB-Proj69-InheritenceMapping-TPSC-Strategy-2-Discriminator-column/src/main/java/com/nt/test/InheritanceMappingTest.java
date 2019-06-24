package com.nt.test;

import com.nt.dao.PersonDetailsDAO;
import com.nt.dao.PersonDetailsDAOFactory;
import com.nt.utility.HibernateUtil;

public class InheritanceMappingTest {

	public static void main(String[] args) {
		PersonDetailsDAO dao = null;
		try {
			dao = PersonDetailsDAOFactory.getInstance();

			//dao.insertPersonDetails();
			dao.loadData();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
