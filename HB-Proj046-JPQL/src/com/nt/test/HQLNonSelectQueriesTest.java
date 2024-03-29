package com.nt.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class HQLNonSelectQueriesTest {

	public static void main(String[] args) {
		EntityManager em=null;
		Query query=null;
		EntityTransaction tx=null;
		int count=0;
		boolean flag=false;
		
		em=HibernateUtil.getSession();
        
		try{
			/*query=em.createQuery("update Employee set salary=salary+:amt where eno=:no");
			query.setParameter("amt",2000f);
			query.setParameter("no",81);
			
			tx=em.getTransaction();
			tx.begin();
			count=query.executeUpdate();
			flag=true;*/
			
			query=em.createQuery("delete from Employee where salary between :min and :max");
			query.setParameter("min",7100f);
			query.setParameter("max",7500f);
			
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
				System.out.println("No. ofEmployee Details Updated/Deleted::"+count);
			}
			else {
				tx.rollback();
				System.out.println("No. of Employee Details Not Updated/Deleted::"+count);
			}
	    	HibernateUtil.closeSession(em);
		    HibernateUtil.closeSessionFactory();
	    }
	}
}
