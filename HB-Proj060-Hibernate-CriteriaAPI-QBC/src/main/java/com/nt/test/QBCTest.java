package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.nt.entity.Vehicle;
import com.nt.utility.HibernateUtil;

public class QBCTest {
	public static void main(String[] args) {
	   Session ses=null;
	   Criteria criteria=null;
	   Criterion cond=null,cond1=null,cond2=null,andCond=null,orCond=null;
	   List<Vehicle> list=null;
	   Order order=null;
	   
	   ses=HibernateUtil.getSession();	
	   try {
			/* criteria=ses.createCriteria(Vehicle.class);
			//	cond=Restrictions.between("vid",1000,2000);
			 cond=Restrictions.between("price",50000,200000);
			 cond1=Restrictions.in("type","two-wheeler","four-wheeler");
			 cond2=Restrictions.ilike("company","lamborgoni");
			 andCond=Restrictions.and(cond,cond1);
			 orCond=Restrictions.or(andCond,cond2);
			 criteria.add(orCond);
			 list=criteria.list();
			 list.forEach(v->{
			   System.out.println(v);
			 });*/
		   
			/*criteria=ses.createCriteria(Vehicle.class);
			cond=Restrictions.sqlRestriction("PRICE>=100000");
			criteria.add(cond);
			list=criteria.list();
			list.forEach(v->{
			   System.out.println(v);
			});*/
		   
		   criteria=ses.createCriteria(Vehicle.class);
		   order=Order.asc("type");
		   criteria.addOrder(order);
		   list=criteria.list();
		   list.forEach(v->{
			   System.out.println(v);
		   });
	   }
	   catch (HibernateException he) {
		  he.printStackTrace();
	   }
	   catch (Exception e) {
		e.printStackTrace();
	   }
	   finally {
	     HibernateUtil.closeSession(ses);
	     HibernateUtil.closeSessionFactory();
	   }
   }
}
