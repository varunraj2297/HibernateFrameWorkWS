package com.nt.test;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class NativeSQLNonSelectQueriesTest {

	public static void main(String[] args) {
		Session ses=null;
		SQLQuery query=null;
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		
		ses=HibernateUtil.getSession();
        
		try{
			/*query=ses.getNamedNativeQuery("UPDATE_QUERY");
			query.setParameter("amt",2000f);
			query.setParameter("no",81);
			
			tx=ses.beginTransaction();
			count=query.executeUpdate();
			flag=true;*/
			
			/*query=ses.getNamedNativeQuery("DELETE_QUERY");
			query.setParameter("min",2100f);
			query.setParameter("max",3500f);
			
			tx=ses.beginTransaction();
			count=query.executeUpdate();
			flag=true;*/
		}catch (Exception e) {
		     e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("No. ofEmployee Details Updated/Deleted::"+count);
			}
			else {
				tx.rollback();
				System.out.println("No. of Employee Details Not Updated/Deleted::"+count);
			}
	    	HibernateUtil.closeSession(ses);
		    HibernateUtil.closeSessionFactory();
	    }
	}
}
