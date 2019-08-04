package com.nt.dao;



import javax.persistence.Query;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class BankAccountDAOImpl  implements BankAccountDAO {
	private static final String WITHDRAW_QUERY="update BankAccount set balance=balance-:amt where acno=:id";
	private static final String DEPOSITE_QUERY="update BankAccount set balance=balance+:amt where acno=:id";
	

	@Override
	public int withdraw(int acno, double amount) throws Exception {
		   Session ses=null;
		   Query query=null;
           int count=0;
		    ses=HibernateUtil.getSession();
		/* System.out.println(ses.isJoinedToTransaction());
		 if(!ses.isJoinedToTransaction())
		 	ses.beginTransaction();*/
		    query=ses.createQuery(WITHDRAW_QUERY);
		    query.setParameter("id",acno);
		    query.setParameter("amt",amount);
		    count=query.executeUpdate();
            return count;
		  }		    
	

	@Override
	public int deposite(int acno, double amount) throws Exception {
		   Session ses=null;
		   Query query=null;
		   int count=0;
		   
		    ses=HibernateUtil.getSession();
		/*  System.out.println(ses.isJoinedToTransaction());
		     if(!ses.isJoinedToTransaction())
		  	        ses.beginTransaction();*/
		    query=ses.createQuery(DEPOSITE_QUERY);
		    query.setParameter("id",acno);
		    query.setParameter("amt",amount);
		    count=query.executeUpdate();
		    return count;
     }


	@Override
	public boolean transferMoney(int srcNo, int destNo, double amount) throws Exception {
		Session ses=null;
		Transaction tx=null;
		int result1=0,result2=0;
		boolean isModified=false;
		ses=HibernateUtil.getSession();
		
		try {
			tx=ses.beginTransaction();
			result1=withdraw(srcNo, amount);
			result2=deposite(destNo, amount);
			
			if(result1==0||result2==0) 
                  isModified=false;
			 else 
				isModified=true;
			
		}
		catch (HibernateException he) {
			isModified=false;
			he.printStackTrace();
		}
		catch (Exception e) {
			isModified=false;
            e.printStackTrace();
		}
		finally {
			if(isModified) 
				tx.commit();
			else 
				tx.rollback();
			
			HibernateUtil.closeSession(ses);
		}
		return isModified;
	}
}
