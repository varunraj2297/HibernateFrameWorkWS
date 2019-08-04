package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProductDetails;
import com.nt.util.HibernateUtil;

public class MergeTest1 {

	public static void main(String[] args) {
		Session ses=null;
		ProductDetails details=null;
		Transaction tx=null;
		boolean flag=false;
		try {
			ses=HibernateUtil.getSession();
			details=new ProductDetails();
			details.setPid(1007);
			details.setPname("wine");
			details.setQuantity(5.0f);
			details.setPrice(500.0f);
			details.setIsExpired(false);
			tx=ses.beginTransaction();
			ses.merge(details);
			
			flag=true;
			if(flag) {
				tx.commit();			
				System.out.println("object saved/updated");
			}else {
				tx.rollback();
				System.out.println("object not saved/updated");
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
