package com.nt.test;

import org.hibernate.Session;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class FirstLevelCacheTest {
       public static void main(String[] args) {
           Session ses=null;
           Employee emp=null;
           
    	   ses=HibernateUtil.getSession();
	        emp=ses.get(Employee.class,500);
	        System.out.println("------------------1----------------------");
	        emp=ses.get(Employee.class,500);
	        System.out.println("------------------2---------------------");
	        ses.evict(emp);
	        emp=ses.get(Employee.class,500);
	        System.out.println("------------------3---------------------");
	        emp=ses.get(Employee.class,500);
	        System.out.println("------------------4---------------------");
	        ses.clear();
	        emp=ses.get(Employee.class,500);
	        System.out.println("------------------5---------------------");
	        emp=ses.get(Employee.class,500);
	        System.out.println("------------------6---------------------");
	        
	        HibernateUtil.closeSession(ses);
	        HibernateUtil.closeSessionFactory();
       }
}
