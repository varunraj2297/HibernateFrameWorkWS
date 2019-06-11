package com.nt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.nt.utility.HibernateUtil;

public class SessionFactoryListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Hibernate is boot straping...");
		try {
			Class.forName("com.nt.utility.HibernateUtil");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Hibernate is boot straped");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.closeSessionFactory();
	}

	
}
