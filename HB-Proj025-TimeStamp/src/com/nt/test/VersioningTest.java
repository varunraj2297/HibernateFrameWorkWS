package com.nt.test;

import com.nt.dao.AirtelCallerTuneDAO;
import com.nt.dao.AirtelCallerTuneDAOFactory;
import com.nt.entity.AirtelCallerTune;
import com.nt.util.HibernateUtil;

public class VersioningTest {

	public static void main(String[] args) {
		
		AirtelCallerTuneDAO dao=null;
		dao=AirtelCallerTuneDAOFactory.getInstance();
		
		//dao.saveData();
	     dao.loadAndUpdateData();
		  
		
		HibernateUtil.closeSessionFactory();

	}

}
