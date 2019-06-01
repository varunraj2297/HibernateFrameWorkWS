package com.nt.thread;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Employee;

public class RequestThread extends Thread {
	
    SessionFactory factory=null;
	Session ses=null;
    
	 public RequestThread(SessionFactory factory) {
		this.factory = factory;
	}
	
	/*public RequestThread(Session ses) {
		this.ses = ses;
	}
	*/
    
 
	@Override
	public void run() {
		
		Transaction tx=null;
		Employee emp=null;
		Scanner sc=null;
		int idVal=0;
		boolean flag=false;
		
		emp=new Employee();
		emp.setEname("dfgh");
		emp.setDesg("fhhg");
		emp.setSalary(5200);
		
		ses=factory.openSession();
		try {
			tx=ses.beginTransaction();//internally call autoCommit(false)
		   idVal=(int) ses.save(emp);
		   System.out.println("Genereted id value::"+idVal+"  "+RequestThread.currentThread());
			flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("object is saved");
			}
			else {
				tx.rollback();
				System.out.println("object not saved");
			}
	   }
	
  }
}