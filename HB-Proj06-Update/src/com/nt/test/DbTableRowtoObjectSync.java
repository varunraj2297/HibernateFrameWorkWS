package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProductDetails;
import com.nt.util.HibernateUtil;

public class DbTableRowtoObjectSync {

	public static void main(String[] args) {
		Session ses=null;
		ProductDetails details=null;
		Transaction tx=null;
		boolean flag=false;
		
			ses=HibernateUtil.getSession();
			details=ses.get(ProductDetails.class,1002);
			if(details==null) {
				System.out.println("record not found");
				return;
			}
			else {
				try {
					System.out.println(details);
					Thread.sleep(10000);
					ses.refresh(details);
					System.out.println(details);
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
	
}
