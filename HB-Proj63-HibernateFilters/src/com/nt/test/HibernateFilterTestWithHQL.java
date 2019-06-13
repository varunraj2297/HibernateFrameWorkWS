package com.nt.test;

import java.util.List;



import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HibernateFilterTestWithHQL {
	
	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
		Query query=null,query1=null,query2=null;
		List<BankAccount> list=null;
		List<Object> list1=null;
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		
		try {
	       ses=HibernateUtil.getSession();
	       filter=ses.enableFilter("FILTER_REMOVE_ACCOUNTS");
	       filter.setParameter("type1","BLOCKED");
	       filter.setParameter("type2","SUSPENDED");
	       filter.setParameter("type3","CLOSED");
	    
	       query=ses.createQuery("from BankAccount");
	       list=query.list();
	       list.forEach(b->{
	    	   System.out.println(b);
	       });
	    
	       //ses.disableFilter("FILTER_REMOVE_ACCOUNTS");
	       query1=ses.createQuery("select count(*) from BankAccount");
	       list1=query1.list();  //or use getResultList()
	       System.out.println("records count::"+list1.get(0));
	       
	       query2=ses.createQuery("update BankAccount set balance=balance+15");
	       tx=ses.beginTransaction();
	       count=query2.executeUpdate();
	       flag=true;
	    }
		catch (HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println(count+" no. of records are updated");
			}
			else {
				tx.rollback();
				System.out.println("no records found for updation");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
}
