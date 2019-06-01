package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;
//works with scalar and also entity query
public class CallPLSQLFunctionTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		ses=HibernateUtil.getSession();
        List<Object[]> list=null;
		
		try {
			query=ses.getNamedQuery("CALL_FX");
			query.setParameter(0,1000f);
			query.setParameter(1,65000f);
			
			list=query.list();
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+"  ");
				}
				System.out.println();
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
