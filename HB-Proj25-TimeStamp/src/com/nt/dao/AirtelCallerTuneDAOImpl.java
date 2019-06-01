package com.nt.dao;

import java.io.Serializable;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.AirtelCallerTune;
import com.nt.util.HibernateUtil;

public class AirtelCallerTuneDAOImpl implements Serializable,AirtelCallerTuneDAO{

	@Override
	public int saveData() {
		Session ses=null;
		int idVal=0;
		Transaction tx=null;
		boolean flag=false; 
		ses=HibernateUtil.getSession();
		try {
			AirtelCallerTune tune=null;
			
			tune=new AirtelCallerTune();
			tune.setCustId(125);
			tune.setCustName("varun");
			tune.setMobileNo(7032377196l);
			tune.setCallerTune("june pothe");
			
		tx=ses.beginTransaction();
		idVal=(int) ses.save(tune);
		flag=true;
		
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
			
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is saved");
			}
			else {
				tx.rollback();
				System.out.println("Object is Not Saved");
			}
		}
		
		HibernateUtil.closeSession(ses);
		return idVal;
	}

	@Override
	public void loadAndUpdateData() {
		Session ses=null;
		AirtelCallerTune tune=null;
		boolean flag=false;
		Transaction tx=null;
		int id=0;
		Scanner sc=null;
		
		try{
			sc=new Scanner(System.in);
			System.out.println("Enter id::");
			id=sc.nextInt();
	    	ses=HibernateUtil.getSession();
			tune=ses.get(AirtelCallerTune.class,id);
		    
		   
		   
		    	tx=ses.beginTransaction();
		    if(tune!=null) {
		     	System.out.println(tune);
		    	tune.setCallerTune("rock on bro");
		    	ses.update(tune);  
		    	flag=true;
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is updated");
			}
			else {
					tx.rollback();
				System.out.println("Object is not found");
			}
			
			HibernateUtil.closeSession(ses);
		}
	}
	  
	
	

}
