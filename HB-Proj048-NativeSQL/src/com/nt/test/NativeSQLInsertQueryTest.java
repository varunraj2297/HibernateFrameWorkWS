package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NativeSQLInsertQueryTest {

	public static void main(String[] args) {
		Session ses=null;
		SQLQuery query=null;
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		
		ses=HibernateUtil.getSession();
		try{
				query=ses.createSQLQuery("insert into Employee(eno,ename,job,sal) values(?1,?2,?3,?4)");
				query.setParameter(1,170);
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
