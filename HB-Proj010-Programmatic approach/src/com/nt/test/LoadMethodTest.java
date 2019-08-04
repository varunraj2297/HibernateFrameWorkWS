package com.nt.test;

import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.util.HibernateUtil;

public class LoadMethodTest {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy;
		try {
			ses=HibernateUtil.getSession();
			policy=ses.load(InsurancePolicy.class, 1002);
			if(policy!=null) {
				System.out.println(policy);
				//System.out.println(policy.getInsuranceId()+"    "+policy.getInsuranceName()+"    "+policy.getInitialAmount()+"     "+policy.getTenure()+"      "+policy.getClass());
			}
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
