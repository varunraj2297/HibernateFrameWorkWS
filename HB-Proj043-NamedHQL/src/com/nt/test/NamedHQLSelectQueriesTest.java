package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NamedHQLSelectQueriesTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<Employee> list=null;
		Iterator<Employee> it=null;
		Employee employee=null;
		
		ses=HibernateUtil.getSession();
        
		try{
			/*query=ses.getNamedQuery("GET_EMPS");
			list=query.list();
			list.forEach(emp->{
			 	System.out.println(emp);
			});*/
		    
			/*query=ses.getNamedQuery("GET_EMPS_BY_ENOs_RANGE");
			query.setParameter(1,81);
			query.setParameter(2,90);
			list=query.list();
			list.forEach(emp->{
				System.out.println(emp);
			});*/
			
			/*query=ses.getNamedQuery("GET_EMPS_BY_ENOs_RANGE_USING_NAMED_PARAMS");
			query.setParameter("start",81);
			query.setParameter("end",90);
			list=query.list();
			list.forEach(emp->{
			 	System.out.println(emp);
				});*/
			
			query=ses.getNamedQuery("GET_EMPS_BY_ENOs");
			query.setParameter("name1","defsd");
			query.setParameter("name2","xcv");
			it=query.iterate();
			while(it.hasNext()) {
				employee=it.next();
				System.out.println(employee);
				System.out.println(employee.getClass());
			}
				
		}catch (Exception e) {
		     e.printStackTrace();
		}
		finally {
	    	HibernateUtil.closeSession(ses);
		    HibernateUtil.closeSessionFactory();
	    }
	}
}
