package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProductDetails;
import com.nt.util.HibernateUtil;

public class UpdateTableTest1 {

	public static void main(String[] args) {
		Session ses=null;
		ProductDetails details=null;
		Transaction tx=null;
		boolean flag=false;
		try {
			ses=HibernateUtil.getSession();
			details=new ProductDetails();
			details.setPid(1003);
			details.setPname("milk");
			details.setQuantity(4.0f);
			details.setPrice(88.0f);
			details.setIsExpired(false);
			tx=ses.beginTransaction();
			ses.update(details);
			
			flag=true;
			if(flag) {
				tx.commit();			
				System.out.println("object updated");
			}else {
				tx.rollback();
				System.out.println("object not updated");
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
