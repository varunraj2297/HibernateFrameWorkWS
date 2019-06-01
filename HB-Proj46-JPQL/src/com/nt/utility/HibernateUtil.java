package com.nt.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final String PERSISTENCE_UNIT_NAME = "JPADemo";  
	private static Configuration cfg=null;
	private static EntityManagerFactory factory=null;
	private static EntityManager em=null;
	static {
		try {
			cfg=new Configuration();
			//cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
			factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static EntityManager getSession() {
		if(factory!=null)
			em=factory.createEntityManager();
		return em;
	}
	
	public static void closeSession(EntityManager em) {
		if(em!=null)
			em.close();
	}
	
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
}
