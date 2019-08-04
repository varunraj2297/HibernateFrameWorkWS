package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurancePolicy;

public class HibernateUtil {
	private static Configuration cfg=null;
	private static SessionFactory factory=null;
	private static InsurancePolicy policy;
	static {
		try {
			cfg=new Configuration();
			cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
			factory=cfg.buildSessionFactory();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession() {
		return factory.openSession();
	}
	
	public static void closeSession(Session ses) {
		ses.close();
	}
	
	public static void closeSessionFactory(){
		factory.close();
	}
}
