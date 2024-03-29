package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class NGOMembersDAOImpl implements NGOMembersDAO {

	//private static final String TRANSFER_EMPS="insert into NGOMember(ngoid,ngoname,desg,salary) select e.eno,e.ename,e.desg,e.salary from Employee e where salary in(:min,:max)";
	@Override
	public int transferEmpsToNGOs(float startSal, float endSal) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		
		ses=HibernateUtil.getSession();
		try {
			query=ses.getNamedQuery("TRANSFER_EMPS");
			query.setParameter("min",startSal);
			query.setParameter("max",endSal);
			tx=ses.beginTransaction();
			count=query.executeUpdate();
			flag=true;
		}
		catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag)
				tx.commit();
			else
				tx.rollback();
			HibernateUtil.closeSession(ses);
		}
		
		return count;
	}

}
