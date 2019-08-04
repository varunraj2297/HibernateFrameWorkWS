package com.nt.test;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class PisimisticLockTest0 {
	
	public static void main(String[] args) {
		
		Session ses=null;
		InsurancePolicy policy=null;
		Transaction tx=null;
		boolean isModified=false;
		
		try {
		       ses=HibernateUtil.getSession();
		       
		       policy=ses.get(InsurancePolicy.class, 123, LockMode.UPGRADE_NOWAIT);
		       policy.setInitialAmount(9000);
		       tx=ses.beginTransaction();
		       ses.update(policy);
               isModified=true;
               try {
            	   Thread.sleep(30000);
               }
               catch (InterruptedException ie) {
				     ie.printStackTrace();
			   }
		}
		catch(Exception e) {
			isModified=false;
			e.printStackTrace();
		}
		finally {
			if(isModified) {
				tx.commit();
				System.out.println("Object is modified");
			}
			else {
				tx.rollback();
				System.out.println("Object is not modified");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}	
	}
}
