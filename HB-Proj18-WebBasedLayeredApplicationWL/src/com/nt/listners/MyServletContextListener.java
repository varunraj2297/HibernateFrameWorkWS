package com.nt.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.nt.HibernateUtil.HibernateUtil;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
