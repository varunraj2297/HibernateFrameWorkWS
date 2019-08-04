package com.nt.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.nt.HibernateUtil.HibernateUtil;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyServletContextListener.contextDestroyed()");
		HibernateUtil.closeSessionFactory();
	}
}
