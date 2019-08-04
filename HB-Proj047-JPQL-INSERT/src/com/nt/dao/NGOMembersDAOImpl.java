package com.nt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.nt.utility.HibernateUtil;

public class NGOMembersDAOImpl implements NGOMembersDAO {

	private static final String TRANSFER_EMPS="insert into NGOMember(ngoid,ngoname,desg,salary) select e.eno,e.ename,e.desg,e.salary from Employee e where salary in(:min,:max)";
	@Override
	public int transferEmpsToNGOs(float startSal, float endSal) {
		EntityManager em=null;
		Query query=null;
		EntityTransaction tx=null;
		int count=0;
		boolean flag=false;
		
		em=HibernateUtil.getSession();
		try {
			query=em.createQuery(TRANSFER_EMPS);
			query.setParameter("min",startSal);
			query.setParameter("max",endSal);
			tx=em.getTransaction();
			tx.begin();
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
			HibernateUtil.closeSession(em);
		}
		
		return count;
	}

}
