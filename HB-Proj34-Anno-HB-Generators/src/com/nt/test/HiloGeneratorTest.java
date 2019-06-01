package com.nt.test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;
import com.nt.util.HibernateUtil;

public class HiloGeneratorTest {

	public static void main(String[] args) {
		
		Session ses=null;
		Transaction tx=null;
		Employee emp=null;
		Scanner sc=null;
		int idVal=0;
		boolean flag=false;
		ses=HibernateUtil.getSession();
		/*emp=new Employee();
		sc=new Scanner(System.in);
		System.out.println("ENter ename::");
		String ename=sc.next();
		emp.setEname(ename);
		System.out.println("Enter Job");
		emp.setDesg(sc.next()); 
		System.out.println("Enter Salary");
		emp.setSalary(sc.nextInt());*/
		try {
			tx=ses.beginTransaction();//internally call autoCommit(false)
		     	for(int i=1;i<=10;i++) {
		     		emp=new Employee();
		     		emp.setEname("defsd");
		     		emp.setDesg("sdd");
		     		emp.setSalary(5000);
			          idVal=(int) ses.save(emp);
		            System.out.println("Genereted id value::"+idVal);
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
