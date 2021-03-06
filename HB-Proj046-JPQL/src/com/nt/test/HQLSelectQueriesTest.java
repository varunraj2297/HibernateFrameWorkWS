package com.nt.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class HQLSelectQueriesTest {

	public static void main(String[] args) {
		EntityManager em=null;
		Query query=null;
		List<Employee> list=null;
		Iterator<Employee> it=null;
		Employee employee=null;
		
		em=HibernateUtil.getSession();
        
		try{
			/*query=em.createQuery("from Employee");
			//list=query.list();
			list=query.getResultList();
			list.forEach(emp->{
			 	System.out.println(emp);
			});*/
		    
			/* query=em.createQuery("from Employee where eno>=?1 and eno<=?2");
			query.setParameter(1,81);
			query.setParameter(2,90);
			list=query.getResultList();
			list.forEach(emp->{
			System.out.println(emp);
			});*/
			
			/*query=em.createQuery("from Employee where eno>=:start and eno<=:end");
			query.setParameter("start",81);
			query.setParameter("end",90);
			System.out.println(query.getClass().getName());
			list=query.getResultList();
			list.forEach(emp->{
			 	System.out.println(emp);
				});*/
			
			/*query=em.createQuery("from Employee where ename in(:name1,:name2)");
			query.setParameter("name1","fgh");
			query.setParameter("name2","xcv");
			it=query.iterate();
			while(it.hasNext()) {
				employee=it.next();
				System.out.println(employee);
				System.out.println(employee.getClass());
			}*/   //lazy loading is not supported
				
		}catch (Exception e) {
		     e.printStackTrace();
		}
		finally {
	    	HibernateUtil.closeSession(em);
		    HibernateUtil.closeSessionFactory();
	    }
	}
}
