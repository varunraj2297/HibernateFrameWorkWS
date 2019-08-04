package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProductDetails;
import com.nt.util.HibernateUtil;

public class MergeTest3 {

	public static void main(String[] args) {
		Session ses=null;
		ProductDetails details=null,details1=null;
		Transaction tx=null;
		boolean flag=false;
		try {
			ses=HibernateUtil.getSession();
			details=ses.get(ProductDetails.class,1008);
			
			details1=new ProductDetails();
			details1.setPid(1008);
			details1.setPname("apples");
			details1.setQuantity(5.0f);
			details1.setPrice(150.0f);
			details1.setIsExpired(false);
			tx=ses.beginTransaction();
	
			details=(ProductDetails) ses.merge(details1);
			flag=true;
			System.out.println(details1);
			
			
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
