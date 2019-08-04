package com.nt.test;

import org.hibernate.Session;

import com.nt.entity.Insurancepolicy;
import com.nt.utility.HibernateUtil;

public class GetMethodTest {
	
	
	public static void main(String[] args) {
		Insurancepolicy policy=null;
		Session ses=null;
		ses=HibernateUtil.getSession();
		try {
		policy=ses.get(Insurancepolicy.class, 1001L);
		if(policy!=null)
			System.out.println(policy);
		else
			System.out.println("Record not found");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}	
	}
}
