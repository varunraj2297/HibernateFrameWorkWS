package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NativeSQLSelectQueriesTest1 {

	public static void main(String[] args) {
		Session ses=null;
		NativeQuery query=null;
		List<Object[]> list=null;
		List<Object> list1=null;
		Iterator<Object[]> it=null;
		Iterator<Object> it1=null;
		Employee employee=null;
		Object obj[]=null;
		ses=HibernateUtil.getSession();
        
		try{
			/*query=ses.getNamedNativeQuery("GET_EMP_DETAILS");
			query.addScalar("ENO",StandardBasicTypes.INTEGER);
			query.addScalar("ENAME",StandardBasicTypes.STRING);
			query.addScalar("JOB",StandardBasicTypes.STRING);
			
			list=query.list();
			for(Object obj1[]:list) {
				for(Object val:obj1) {
					System.out.print(val+"   "+val.getClass()+" ");
				}
				System.out.println();
			}*/
            
			/*query=ses.getNamedNativeQuery("GET_EMP_DETAILS_BY_ENOs_RANGE");
			query.setParameter(2,81);
			//query.setParameter("no",90);
			query.setParameter(3,90);
			query.addScalar("ENO",StandardBasicTypes.INTEGER);
			query.addScalar("ENAME",StandardBasicTypes.STRING);
			query.addScalar("JOB",StandardBasicTypes.STRING);
			
			list=query.getResultList();  //or list()
			list.forEach( objarr->{
				for(Object val:objarr)
				    System.out.print(val+"   "+val.getClass()+"  ");
				System.out.println();
			});*/ //supports both postional n jpa style postional params
			//Mixed parameter strategies - use just one of named, positional or JPA-ordinal strategy
			
			
			
			/*query=ses.getNamedNativeQuery("GET_EMPS_DETAILS_BY_ENAMEs");
			query.setParameter("name1","defsd");
			query.setParameter("name2","xcv");
			it=query.iterate();
			while(it.hasNext()) {
			    obj=it.next();
			    for(Object val:obj)
				   System.out.print(val+"    ");
				System.out.println();
			} */  //SQL queries do not currently support iteration
			
			/*query=ses.getNamedNativeQuery("GET_ENO_BY_ENO");
			query.setParameter("no",81);
			query.addScalar("ENO",StandardBasicTypes.INTEGER);
			
			list1=query.list();
			list1.forEach(eno->{
				System.out.println(eno+"  "+eno.getClass());
			});
			
			System.out.println(list1.get(0)+"  "+list1.get(0).getClass());
			*/
			
			
			/*query=ses.getNamedNativeQuery("GET_EMPS_COUNT");
			list1=query.list();
			System.out.println(list1.get(0));
			it1=query.iterate();
			while (it1.hasNext()) {
			   Object val=it1.next();
			   System.out.println(val);
			}*/
			//System.out.println(it1.next());
			  //SQL queries do not currently support iteration
			
			/*query=ses.getNamedNativeQuery("GET_HIGH_SAL_EMP_DETAILS");
			query.addScalar("ENO",StandardBasicTypes.INTEGER);
			query.addScalar("ENAME",StandardBasicTypes.STRING);
			query.addScalar("JOB",StandardBasicTypes.STRING);
			
			list=query.list();
			for(Object obj1[]:list) {
				for(Object val:obj1) {
					System.out.print(val+"   "+val.getClass()+"  ");
				}
				System.out.println();
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
