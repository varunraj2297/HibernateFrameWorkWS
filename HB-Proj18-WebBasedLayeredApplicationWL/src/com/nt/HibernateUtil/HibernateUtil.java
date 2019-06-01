package com.nt.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
		private static Configuration cfg;
		private static SessionFactory factory;
		private static ThreadLocal<Session> threadLocal;
	
		static {
			cfg=new Configuration();
			cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
			
			factory=cfg.buildSessionFactory();
			threadLocal=new ThreadLocal<Session>();
		}
		
		public static Session getSession() {
			Session ses=null;
			if(threadLocal.get()==null) {
				ses=factory.openSession();
				threadLocal.set(ses);
				return ses;
			}
			else 
				return threadLocal.get();
		}
		
		public static void closeSession() {
			Session ses=null;
			if(threadLocal.get()!=null) {
				ses=threadLocal.get();
				ses.close();
				threadLocal.remove();
			}
		}
		
		public static void closeSessionFactory() {
			if(factory!=null)
				factory.close();
		}
		
		
}
