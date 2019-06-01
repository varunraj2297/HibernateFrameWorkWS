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
			/*	is=new FileInputStream("src/com/nt/commons/myFile.properties");
			props=new Properties();
			props.load(is);
			cfg.setProperties(props);
			*/
			
			cfg.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
			cfg.setProperty("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521:xe");
			cfg.setProperty("hibernate.connection.username","hr");
			cfg.setProperty("hibernate.connection.password","hr");
			
			cfg.setProperty("hibernate.show_sql","true");
			cfg.setProperty("hibernate.format_sql","true");
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
