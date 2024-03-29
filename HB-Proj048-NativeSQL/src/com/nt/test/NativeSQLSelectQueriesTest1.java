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
		Session ses = null;
		NativeQuery query = null;// SQLQuery is deprecated
		List<Object[]> list = null;
		List<Object> list1 = null;
		Iterator<Object[]> it = null;
		Iterator<Object> it1 = null;
		Employee employee = null;
		Object obj[] = null;
		ses = HibernateUtil.getSession();

		try {
			/*query=ses.createSQLQuery("select eno,ename,job from Employee");
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

			/*//query=ses.createSQLQuery("select eno,ename,job  from Employee where eno>=?2 and eno<=:no);
			query=ses.createSQLQuery("select eno,ename,job  from Employee where eno>=?2 and eno<=?3");
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
			}); */  // Mixed parameter strategies - use just one of named, positional or JPA-ordinal strategy
			//supports both postional n jpa style postional params
			
			/*	query=ses.createSQLQuery("select eno,ename,job from Employee where ename in(:name1,:name2)");
				query.setParameter("name1","defsd");
				query.setParameter("name2","xcv");
				it=query.iterate();
				while(it.hasNext()) {
				    obj=it.next();
				    for(Object val:obj)
					   System.out.print(val+"    ");
					System.out.println();
				} */ // SQL queries do not currently support iteration

			/*query=ses.createSQLQuery("select eno from Employee where eno=:no");
			query.setParameter("no",81);
			query.addScalar("ENO",StandardBasicTypes.INTEGER);
			
			list1=query.list();
			list1.forEach(eno->{
				System.out.println(eno+"  "+eno.getClass());
			});
			
			System.out.println(list1.get(0)+"  "+list1.get(0).getClass());
			*/

			/*query=ses.createSQLQuery(" select count(*) from Employee");
			list1=query.list();
			System.out.println(list1.get(0));
			it1=query.iterate();
			while (it1.hasNext()) {
			   Object val=it1.next();
			   System.out.println(val);
			}
			//System.out.println(it1.next());
			*/
			// SQL queries do not currently support iteration

			/*query=ses.createSQLQuery("select eno,ename,job from Employee where sal=(select max(sal) from Employee)");
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

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
}
