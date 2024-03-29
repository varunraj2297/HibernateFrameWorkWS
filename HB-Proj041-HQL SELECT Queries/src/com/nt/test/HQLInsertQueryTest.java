package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;
//not working
public class HQLInsertQueryTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		
		ses=HibernateUtil.getSession();
        
		try{
				query=ses.createQuery("insert into Employee(eno,ename,desg,salary) values(?1,?2,?3,?4)");
				query.setParameter(1,174);
				query.setParameter(2,"srinu");
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
