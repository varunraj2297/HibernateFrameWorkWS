package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;
//works with only entity query
//doesn't works with scalar query Pure native scalar queries are not yet supported
public class CallPLSQLFunctionTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		ses=HibernateUtil.getSession();
       // List<Object[]> list=null;
		List<BankAccount> list=null;
		try {
			query=ses.getNamedQuery("CALL_FX");
			query.setParameter(0,1000f);
			query.setParameter(1,65000f);
			
			list=query.list();
			/*list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+"  ");
				}
				System.out.println();
			});*/
			list.forEach(b->{
				System.out.println(b);
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
