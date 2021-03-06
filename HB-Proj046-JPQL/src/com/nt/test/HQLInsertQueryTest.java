package com.nt.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;
//not working
public class HQLInsertQueryTest {

	public static void main(String[] args) {
		EntityManager em=null;
		Query query=null;
		EntityTransaction tx=null;
		int count=0;
		boolean flag=false;
		
		em=HibernateUtil.getSession();
        
		try{
				query=em.createQuery("insert into Employee(eno,ename,desg,salary) values(?1,?2,?3,?4)");
				query.setParameter(1,129);
				query.setParameter(2,"srinu");
				query.setParameter(3,"clerk");
				query.setParameter(4,5000);
				tx=em.getTransaction();
				tx.begin();
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
	    	HibernateUtil.closeSession(em);
		    HibernateUtil.closeSessionFactory();
	    }
	}
}
