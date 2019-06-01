package com.nt.utility;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {
	     private static Configuration cfg=null;
	     //private static StandardServiceRegistryBuilder registryBuilder=null;
	     private static ServiceRegistryBuilder registryBuilder=null;
	     private static ServiceRegistry registry=null;
	     private static SessionFactory factory=null;
	     private static Session ses=null;
	static {
		try {
		     cfg=new Configuration();
		     cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
  			 registryBuilder=new ServiceRegistryBuilder ();
  			 registry=registryBuilder.applySettings(cfg.getProperties()).buildServiceRegistry();
  			 factory=cfg.buildSessionFactory(registry);
  		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession() {
		if(factory!=null)
			ses=factory.openSession();
		return ses;
	}
	
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
}
