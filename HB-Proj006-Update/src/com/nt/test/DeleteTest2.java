package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProductDetails;
import com.nt.util.HibernateUtil;

public class DeleteTest2 {

	public static void main(String[] args) {
		Session ses=null;
		ProductDetails details=null,details1=null;
		Transaction tx=null;
		boolean flag=false;
		try {
			ses=HibernateUtil.getSession();
			details=ses.get(ProductDetails.class,1020);
			
			if(details!=null)
				System.out.println(details);
			else {
				System.out.println("record not found");
			    return;
			 }
			tx=ses.beginTransaction();
			ses.delete(details);
			
			flag=true;
			System.out.println(details);
			
			
			if(flag) {
				tx.commit();			
				System.out.println("object deleted");
			}else {
				tx.rollback();
				System.out.println("object not deleted");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
	
}
