package com.nt.listners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import com.nt.HibernateUtil.HibernateUtil;

public class MyServletResquestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("MyServletResquestListener.requestDestroyed()");
		HibernateUtil.closeSession();
	}
	
}
