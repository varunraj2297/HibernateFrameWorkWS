package com.nt.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HibernateFilterTestWithJPACriteria {
	
	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<BankAccount> ctQuery=null;
		CriteriaQuery<Object> ctQuery1=null;
		Root root=null,root1=null;
		
	    Query query=null,query1=null;
		List<BankAccount> list=null;
		List<Object> list1=null;
		int count=0;
		
		
		try {
	       ses=HibernateUtil.getSession();
	       filter=ses.enableFilter("FILTER_REMOVE_ACCOUNTS");
	       filter.setParameter("type1","BLOCKED");
	       filter.setParameter("type2","SUSPENDED");
	       filter.setParameter("type3","CLOSED");
	    
	      builder=ses.getCriteriaBuilder();
	       ctQuery=builder.createQuery(BankAccount.class);
	       root=ctQuery.from(BankAccount.class);
	       ctQuery.select(root);
	       
	       query=ses.createQuery(ctQuery);
	       list=query.getResultList();
	       list.forEach(b->{
	    	   System.out.println(b);
	       });
	      // ses.disableFilter("FILTER_REMOVE_ACCOUNTS");
	       
	       ctQuery1=builder.createQuery(Object.class);
	       root1=ctQuery1.from(BankAccount.class);
	       ctQuery1.multiselect(builder.count(root1.get("accno")));
	        
	       query1=ses.createQuery(ctQuery1);
	       list1=query1.getResultList();
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
