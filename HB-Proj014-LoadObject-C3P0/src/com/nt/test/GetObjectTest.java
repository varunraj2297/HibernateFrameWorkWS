package com.nt.test;

import org.hibernate.Session;

import com.nt.entity.InsurancePolicyDetails;
import com.nt.utility.HibernateUtil;

public class GetObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicyDetails policy=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load object using ses.get(-,-) method
		try {
			policy=ses.get(InsurancePolicyDetails.class,1001);
			if(policy!=null)
				System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getTenure()+"  "+policy.getCompany()+" "+policy.getInitialAmount());
			else
			 System.out.println("Record/Object not found");	
			
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close HB objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		
	}//main
}//class
