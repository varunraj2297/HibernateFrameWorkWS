package com.nt.test;

import java.util.Iterator;
import java.util.List;

//import org.hibernate.SQLQuery;   //deprecated as alternate use NativeQuery
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NativeSQLSelectQueriesTest {

	public static void main(String[] args) {
		Session ses = null;
	//	SQLQuery query = null;
		NativeQuery query=null;
		 //List<Object[]> list=null;
		List<Employee> list = null;
		Iterator<Employee> it = null;
		Employee employee = null;

		ses = HibernateUtil.getSession();

		try {
			/*query=ses.createSQLQuery("select eno,ename,job,sal from employee");
			query.addScalar("ENO",StandardBasicTypes.INTEGER);
			query.addScalar("ENAME",StandardBasicTypes.STRING);
			query.addScalar("JOB",StandardBasicTypes.STRING);
			query.addScalar("SAL", StandardBasicTypes.FLOAT);
			list=query.list();
			list.forEach(row->{
				for(Object obj:row)
			 	    System.out.print(obj+" "+obj.getClass()+"   ");
				System.out.println();
			});*/

			/*query=ses.createSQLQuery("select eno,ename,job,sal from employee");
			query.addEntity(Employee.class);
			list=query.list();
			
			list.forEach(emp->{
				System.out.println(emp);
			});*/
			
			//query=ses.createSQLQuery("select eno,ename,job,sal from Employee where eno>=? and eno<=:no");
			query=ses.createSQLQuery("select eno,ename,job,sal from Employee where eno>=? and eno<=?");
			query.setParameter(1,81);
			//query.setParameter("no",90);
			query.setParameter(2,90);
			query.addEntity(Employee.class);
			list=query.list();
			list.forEach(emp->{
				System.out.println(emp);
			});  //supports both postional n jpa style postional params
			// Mixed parameter strategies - use just one of named, positional or JPA-ordinal strategy
			
			/*query=ses.createSQLQuery("select eno,ename,job,sal from Employee where eno>=:start and eno<=:end");
			query.setParameter("start",81);
			query.setParameter("end",90);
			query.addEntity(Employee.class);
			list=query.list();
			list.forEach(emp->{
			 	System.out.println(emp);
				});*/

			/*query=ses.createSQLQuery("select eno,ename,job,sal from Employee where ename in(:name1,:name2)");
			query.setParameter("name1","defsd");
			query.setParameter("name2","xcv");
			it=query.iterate();
			while(it.hasNext()) {
				employee=it.next();
				System.out.println(employee);
				System.out.println(employee.getClass());
			}*/  //SQL queries do not currently support iteration

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
}
