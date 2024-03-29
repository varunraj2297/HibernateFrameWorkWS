package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NamedHQLSelectQueriesTest1 {

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
			/*query=ses.getNamedQuery("GET_EMP_DETAILS");
			list=query.list();
			for(Object[] obj1:list) {
				for(Object val:obj1) {
					System.out.print(val+"   ");
				}
				System.out.println();
			}*/
            
			/*query=ses.getNamedQuery("GET_EMP_DETAILS_BY_ENOs_RANGE");
			query.setParameter(1,81);
			query.setParameter("no",90);
			list=query.list();
			list.forEach( objarr->{
				for(Object val:objarr)
				    System.out.print(val+"   ");
				System.out.println();
			}); */   //supports mixed params usage eg:- ?2,:no together allowed
			
			
			
			/*query=ses.getNamedQuery("GET_EMPS_DETAILS_BY_ENAMEs");
			query.setParameter("name1","defsd");
			query.setParameter("name2","xcv");
			it=query.iterate();
			while(it.hasNext()) {
			    obj=it.next();
			    for(Object val:obj)
				   System.out.print(val+"    ");
				System.out.println();
			}*/
			
			/*query=ses.getNamedQuery("GET_ENO_BY_ENO");
			query.setParameter("no",81);
			list1=query.list();
			list1.forEach(eno->{
				System.out.println(eno);
			});
			
			System.out.println(list1.get(0));*/
			
			
			/*query=ses.getNamedQuery("GET_EMPS_COUNT");
			list1=query.list();
			System.out.println(list1.get(0));
			it1=query.iterate();
			while (it1.hasNext()) {
			   Object val=it1.next();
			   System.out.println(val);
			}
			//System.out.println(it1.next());
				*/
				
			/*query=ses.getNamedQuery("GET_HIGH_SAL_EMP_DETAILS");
			list=query.list();
			for(Object obj1[]:list) {
				for(Object val:obj1) {
					System.out.print(val+"   ");
				}
				System.out.println();
			}
			*/
			
		}catch (Exception e) {
		     e.printStackTrace();
		}
		finally {
	    	HibernateUtil.closeSession(ses);
		    HibernateUtil.closeSessionFactory();
	    }
	}
}
