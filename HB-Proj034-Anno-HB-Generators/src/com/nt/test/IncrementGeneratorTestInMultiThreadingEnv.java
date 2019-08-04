package com.nt.test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;
import com.nt.thread.RequestThread;
import com.nt.util.HibernateUtil;

public class IncrementGeneratorTestInMultiThreadingEnv {

	
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
	//	Session ses=new Configuration().configure("com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory().openSession();
		
	    Thread th1=null,th2=null;
		
		//ses=HibernateUtil.getSession();
		
	
		try {
			 th1=new RequestThread(factory);
			 th2=new RequestThread(factory);
			 
			 th1.start();
			 th2.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//HibernateUtil.closeSessionFactory();
	}

}
