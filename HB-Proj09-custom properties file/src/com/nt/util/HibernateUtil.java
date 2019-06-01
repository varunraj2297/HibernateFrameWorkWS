package com.nt.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurancePolicy;


public class HibernateUtil {
	private static Configuration cfg=null;
	private static SessionFactory factory=null;
	private static InsurancePolicy policy;
	private static InputStream is=null;
	private static Properties props=null;
	static {
		try {
			
			
			cfg=new Configuration();
	
			is=new FileInputStream("src/com/nt/commons/myFile.properties");
			props=new Properties();
			props.load(is);
			cfg.setProperties(props);
			
			cfg.addFile("src/com/nt/entity/InsurancePolicy.hbm.xml");
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
