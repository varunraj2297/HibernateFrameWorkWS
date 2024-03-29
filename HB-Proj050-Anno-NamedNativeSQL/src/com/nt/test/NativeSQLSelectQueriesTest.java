package com.nt.test;

import java.util.Iterator;
import java.util.List;

//import org.hibernate.SQLQuery;   //deprecated as alternate use NativeQuery
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NativeSQLSelectQueriesTest {

	public static void main(String[] args) {
		Session ses = null;
		// SQLQuery query = null;
		NativeQuery query = null;
		//List<Object[]> list = null;
		 List<Employee> list = null;
		Iterator<Employee> it = null;
		Employee employee = null;

		ses = HibernateUtil.getSession();

		try {
			/*query=ses.getNamedNativeQuery("GET_EMPS");
			query.addScalar("ENO",StandardBasicTypes.INTEGER);
			query.addScalar("ENAME",StandardBasicTypes.STRING);
			query.addScalar("JOB",StandardBasicTypes.STRING);
			query.addScalar("SAL", StandardBasicTypes.FLOAT);
			list=query.list();
			list.forEach(row->{
				for(Object obj:row)
			 	    System.out.print(obj+" "+obj.getClass()+"   ");
				System.out.println();
			});
			*/
			
			/*query=ses.getNamedNativeQuery("GET_EMPS");
			//query.addScalar("ENO",StandardBasicTypes.INTEGER);
			//query.addScalar("ENAME",StandardBasicTypes.STRING);
			//query.addScalar("JOB",StandardBasicTypes.STRING);
			//query.addScalar("SAL", StandardBasicTypes.FLOAT);
			
			list=query.list();
			
			list.forEach(emp->{
				System.out.println(emp);
				
			});*/
						
			/*query=ses.getNamedNativeQuery("GET_EMPS_BY_ENOs_RANGE");
			
			query.setParameter(1,81);
			query.setParameter(2,90);
			//query.addEntity(Employee.class);
			list=query.list();
			list.forEach(emp->{
				System.out.println(emp);
			});  */

			/*query=ses.getNamedNativeQuery("GET_EMPS_BY_ENOs_RANGE_USING_NAMED_PARAMS");
			query.setParameter("start",81);
			query.setParameter("end",90);
			//query.addEntity(Employee.class);
			list=query.list();
			list.forEach(emp->{
			 	System.out.println(emp);
				});*/

			/*query=ses.getNamedNativeQuery("GET_EMPS_BY_ENOs");
			query.setParameter("name1","defsd");
			query.setParameter("name2","xcv");
			it=query.iterate();
			while(it.hasNext()) {
				employee=it.next();
				System.out.println(employee);
				System.out.println(employee.getClass());
			} */ // SQL queries do not currently support iteration

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
}
