package com.nt.test;

import org.hibernate.Session;

import com.nt.entity.InsurancePolicyDetails;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicyDetails policy=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load object using ses.load(-,-) method
		try {
			policy=ses.load(InsurancePolicyDetails.class,1001);
	   		// System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getTenure()+"  "+policy.getCompany()+" "+policy.getInitialAmount());
			
		}//try
		catch(Exception e) {
			System.out.println("Object/record not found");
			e.printStackTrace();
		}
		finally {
			//close HB objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		
	}//main
}//class
