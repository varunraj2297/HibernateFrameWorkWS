package com.nt.test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;
import com.nt.util.HibernateUtil;

public class AssignedGeneratorTest {

	public static void main(String[] args) {
		
		Session ses=null;
		Transaction tx=null;
		Employee emp=null;
		Scanner sc=null;
		int idVal=0;
		boolean flag=false;
		ses=HibernateUtil.getSession();
		emp=new Employee();
		sc=new Scanner(System.in);
		System.out.println("Enter eno::");
		int eno=sc.nextInt();
		emp.setEno(eno); 
		System.out.println("ENter ename::");
		String ename=sc.next();
		emp.setEname(ename);
		System.out.println("Enter Job");
		emp.setDesg(sc.next()); 
		System.out.println("Enter Salary");
		emp.setSalary(sc.nextInt());
		try {
			tx=ses.beginTransaction();//internally call autoCommit(false)
			idVal=(int) ses.save(emp);
		    System.out.println("Genereted id value::"+idVal);
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
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}

}
