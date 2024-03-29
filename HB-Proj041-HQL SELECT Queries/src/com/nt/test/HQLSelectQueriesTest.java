package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class HQLSelectQueriesTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<Employee> list=null;
		//List<Object[]> list=null;
		Iterator<Employee> it=null;
		Employee employee=null;
		
		ses=HibernateUtil.getSession();
        
		try{
			query=ses.createQuery("from Employee");   //or select e from Employee e
			list=query.list();
			list.forEach(emp->{
			 	System.out.println(emp);
			});
			
			/*query=ses.createQuery("select eno,ename,desg,salary from Employee");
			list=query.list();
			list.forEach(row->{
			 	for(Object val:row)
			 		System.out.print(val+" ");
			 	System.out.println();
			});*/
		    
			/*  query=ses.createQuery("from Employee where eno>=?1 and eno<=?2");
			query.setParameter(1,81);
			query.setParameter(2,90);
			list=query.list();
			list.forEach(emp->{
				System.out.println(emp);
			});*/
			
			/*query=ses.createQuery("from Employee where eno>=:start and eno<=:end");
			query.setParameter("start",81);
			query.setParameter("end",90);
			list=query.list();
			list.forEach(emp->{
			 	System.out.println(emp);
				});*/
			
			/*query=ses.createQuery("from Employee where ename in(:name1,:name2)");
			query.setParameter("name1","fgh");
			query.setParameter("name2","xcv");
			it=query.iterate();
			while(it.hasNext()) {
				employee=it.next();
				System.out.println(employee);
				System.out.println(employee.getClass());
			}*/
				
		}catch (Exception e) {
		     e.printStackTrace();
		}
		finally {
	    	HibernateUtil.closeSession(ses);
		    HibernateUtil.closeSessionFactory();
	    }
	}
}
