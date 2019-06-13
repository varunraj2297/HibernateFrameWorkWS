package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HibernateFilterTestWithHBCriteria {
	
	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
		Criteria criteria=null;
		
		Projection projection=null;
		List<BankAccount> list=null;
		List<Object> list1=null;
		int count=0;
		
		
		try {
	       ses=HibernateUtil.getSession();
	       filter=ses.enableFilter("FILTER_REMOVE_ACCOUNTS");
	       filter.setParameter("type1","BLOCKED");
	       filter.setParameter("type2","SUSPENDED");
	       filter.setParameter("type3","CLOSED");
	    
	       criteria=ses.createCriteria(BankAccount.class);
	       
	       list=criteria.list();
	       list.forEach(b->{
	    	   System.out.println(b);
	       });
	       ses.disableFilter("FILTER_REMOVE_ACCOUNTS");
	     
	       projection=Projections.rowCount();
	       criteria.setProjection(projection);
	       list1=criteria.list();  //or use getResultList()
	       System.out.println("records count::"+list1.get(0));
	    }
		catch (HibernateException he) {
			he.printStackTrace();
			
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
}
