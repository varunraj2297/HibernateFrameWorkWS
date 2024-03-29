package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class HQLSelectQueriesTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
		List<Object> list1=null;
		Iterator<Object[]> it=null;
		Iterator<Object> it1=null;
		Employee employee=null;
		Object obj[]=null;
		ses=HibernateUtil.getSession();
        
		try{
			/*query=ses.createQuery("select eno,ename,desg from Employee");
			list=query.list();
			for(Object[] obj1:list) {
				for(Object val:obj1) {
					System.out.print(val+"   ");
				}
				System.out.println();
			}*/
            
			/*query=ses.createQuery("select eno,ename,desg  from Employee where eno>=?1 and eno<=?2");
			query.setParameter(1,81);
			query.setParameter(2,90);
			list=query.list();
			list.forEach( objarr->{
				for(Object val:objarr)
				    System.out.print(val+"   ");
				System.out.println();
			});*/
			
			
			
			/*	query=ses.createQuery("select eno,ename,desg from Employee where ename in(:name1,:name2)");
				query.setParameter("name1","fgh");
				query.setParameter("name2","xcv");
				it=query.iterate();
				while(it.hasNext()) {
				    obj=it.next();
				    for(Object val:obj)
					   System.out.print(val+"    ");
					System.out.println();
				}*/
			
			/*query=ses.createQuery("select eno from Employee where eno=:no");
			query.setParameter("no",81);
			list1=query.list();
			list1.forEach(eno->{
				System.out.println(eno);
			});
			
			System.out.println(list1.get(0));
			*/
			
			/*query=ses.createQuery("select count(*) from Employee");
			list1=query.list();
			System.out.println(list1.get(0));
			it1=query.iterate();
			while (it1.hasNext()) {
			   Object val=it1.next();
			   System.out.println(val);
			}
			//System.out.println(it1.next());
				*/
			query=ses.createQuery("select eno,ename,desg from Employee where salary=(select max(salary) from Employee)");
			list=query.list();
			for(Object obj1[]:list) {
				for(Object val:obj1) {
					System.out.print(val+"   ");
				}
				System.out.println();
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
