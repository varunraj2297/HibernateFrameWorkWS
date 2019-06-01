package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProductDetails;
import com.nt.util.HibernateUtil;

public class UpdateTableTest2 {

	public static void main(String[] args) {
		Session ses=null;
		ProductDetails details=null;
		Transaction tx=null;
		boolean flag=false;
		
			ses=HibernateUtil.getSession();
			details=ses.get(ProductDetails.class,1001);
			if(details==null) {
				System.out.println("record not found");
				return;
			}
			else {
				System.out.println(details);
			try {
			tx=ses.beginTransaction();
			details.setPname("towel");
			ses.update(details);
			
			flag=true;
			if(flag) {
				tx.commit();			
				System.out.println("object updated");
			}else {
				tx.rollback();
				System.out.println("object not updated/not found");
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
	
}
