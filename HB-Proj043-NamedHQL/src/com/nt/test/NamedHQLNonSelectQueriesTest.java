package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NamedHQLNonSelectQueriesTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		
		ses=HibernateUtil.getSession();
        
		try{
			/*query=ses.getNamedQuery("UPDATE_QUERY");
			query.setParameter("amt",2000f);
			query.setParameter("no",81);
			
			tx=ses.beginTransaction();
			count=query.executeUpdate();
			flag=true;*/
			
			query=ses.getNamedQuery("DELETE_QUERY");
			query.setParameter("min",2100f);
			query.setParameter("max",3500f);
			
			tx=ses.beginTransaction();
			count=query.executeUpdate();
			flag=true;
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
