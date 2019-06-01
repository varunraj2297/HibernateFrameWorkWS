package com.nt.test;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurancePolicy;
import com.nt.util.HibernateUtil;

public class GetMethodTest {
	
	public static void main(String[] args) {
		InsurancePolicy policy=null;
		Session ses=null;
		ses=HibernateUtil.getSession();
		try {
		policy=ses.get(InsurancePolicy.class, 1001);
		if(policy!=null)
			System.out.println(policy.getInsuranceId()+"     "+policy.getInsuranceName()+"     "+policy.getInitialAmount()+"    "+policy.getTenure());
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
