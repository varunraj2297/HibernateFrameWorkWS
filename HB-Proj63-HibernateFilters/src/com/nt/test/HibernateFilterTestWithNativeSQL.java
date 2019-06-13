package com.nt.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HibernateFilterTestWithNativeSQL {
	
	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
		NativeQuery query=null,query1=null,query2=null;
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
	    
	       query=ses.createSQLQuery("SELECT ACCNO,HOLDERNAME,BALANCE,STATUS FROM BANK_ACCOUNT");
	       query.addEntity(BankAccount.class);
	       list=query.list();
	       list.forEach(b->{
	    	   System.out.println(b);
	       });
	    
	       //ses.disableFilter("FILTER_REMOVE_ACCOUNTS");
	       query1=ses.createSQLQuery("SELECT COUNT(*) FROM BANK_ACCOUNT");
	       query1.addScalar("COUNT(*)",StandardBasicTypes.INTEGER);
	       list1=query1.list();  //or use getResultList()
	       System.out.println("records count::"+list1.get(0));
	       
	       query2=ses.createSQLQuery("UPDATE BANK_ACCOUNT SET BALANCE=BALANCE+15");
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
