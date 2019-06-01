package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class PL_SQLProcedureCallTest {
	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		//SQLQuery query=null;
		List<Employee> list=null;
		try {
		ses=HibernateUtil.getSession();
		query= ses.getNamedQuery("CALL_PROCEDURE");
		//query=(SQLQuery) ses.getNamedQuery("CALL_PROCEDURE");
		query.setParameter(0,2000);
		query.setParameter(1,5000);
		/*query.setParameter("min",2000);
		query.setParameter("max",5000);*/
		//SQLQuery supports mixed params strategy.
		//Where as NativeQuery doesn't
		//Here we are not using NativeQuery 
		
		list=query.list();
		list.forEach(emp->{
			System.out.println(emp);
		});
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}

}
