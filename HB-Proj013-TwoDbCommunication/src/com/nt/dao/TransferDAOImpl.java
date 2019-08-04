package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.MySQLHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class TransferDAOImpl implements TransferDAO {

	@Override
	public boolean transferObject(int eid) {
		Session ses1=null,ses2=null;
		Employee emp=null;
		boolean flag=false;
		Transaction tx=null;
		try {
			ses1=OracleHibernateUtil.getSession();
			emp=ses1.get(Employee.class,eid);
			ses2=MySQLHibernateUtil.getSession();
			tx=ses2.beginTransaction();
			if(emp!=null) {
				System.out.println(emp);
				ses2.save(emp);
			    flag=true;
			}
			else {
				System.out.println("record not found");
				return flag;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) 
				tx.commit();
			else 
				tx.rollback();
		}
		return flag;
	}

}
