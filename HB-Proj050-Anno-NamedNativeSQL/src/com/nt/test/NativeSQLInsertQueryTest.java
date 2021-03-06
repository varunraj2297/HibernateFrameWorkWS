package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.nt.utility.HibernateUtil;

public class NativeSQLInsertQueryTest {

	public static void main(String[] args) {
		Session ses=null;
		NativeQuery query=null;
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		
		ses=HibernateUtil.getSession();
		try{
				query=ses.getNamedNativeQuery("INSERT_QUERY");
				query.setParameter(1,158);
				query.setParameter(2,"gohur");
				query.setParameter(3,"clerk");
				query.setParameter(4,5000);
				tx=ses.beginTransaction();
				count=query.executeUpdate();
				flag=true;
			
		}catch (Exception e) {
		     e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Employee Registered");
			}
			else {
				tx.rollback();
				System.out.println("Employee Not Registered");
			}
	    	HibernateUtil.closeSession(ses);
		    HibernateUtil.closeSessionFactory();
	    }
	}
}
