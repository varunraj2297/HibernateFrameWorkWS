package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProductDetails;
import com.nt.util.HibernateUtil;

public class MergeTest2 {

	public static void main(String[] args) {
		Session ses=null;
		ProductDetails details=null,details1=null,details2=null;
		Transaction tx=null;
		boolean flag=false;
		try {
			ses=HibernateUtil.getSession();
			details=new ProductDetails();
			details.setPid(1008);
			details.setPname("wine");
			details.setQuantity(5.0f);
			details.setPrice(500.0f);
			details.setIsExpired(false);
			
			details1=new ProductDetails();
			details1.setPid(1008);
			details1.setPname("horlicks");
			details1.setQuantity(5.0f);
			details1.setPrice(500.0f);
			details1.setIsExpired(false);
			tx=ses.beginTransaction();
			ses.save(details);
			//ses.update(details1);
			details2=(ProductDetails) ses.merge(details1);
			System.out.println(details2);
			
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
