package com.nt.test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class DynamicSQLUpdateTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		Employee emp=null;
		Scanner sc=null;
		int idVal=0;
		boolean flag=false;
		//create Configuration obj 
		cfg=new Configuration();//to bootstrap the hibernate framework
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");//locate  and checks whether hibernate.cfg.xml file is well formed or not valid or not
		//create session factory
		factory=cfg.buildSessionFactory();//here connection pool is created,mapping file
		System.out.println(factory.getProperties());
		//create session obj
		ses=factory.openSession();
		sc=new Scanner(System.in);
		System.out.println("Enter eno::");
		int eno=sc.nextInt();
	
		emp=ses.get(Employee.class,eno);
		emp.setEname("hari");
		try {
			tx=ses.beginTransaction();//internally call autoCommit(false)
			ses.update(emp);
			flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("object is updated");
			}
			else {
				tx.rollback();
				System.out.println("object not updated");
			}
			ses.close();
			factory.close();
		}
	}

}
