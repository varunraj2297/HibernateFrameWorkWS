package com.nt.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Vehicle;
import com.nt.utility.HibernateUtil;

public class JPACriteriaAPITest {
	
	public static void main(String[] args) {
		Session ses=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<Vehicle> ctQuery=null;
		Root<Vehicle> root=null;
		ParameterExpression<Integer> param1=null,param2=null;
		Predicate pdc1=null,pdc2=null,pdc3=null;
		Order order=null;
		Query query=null;
		List<Vehicle> list=null;
		try {
			/*ses=HibernateUtil.getSession();
			builder=ses.getCriteriaBuilder();
			ctQuery=builder.createQuery(Vehicle.class);
			root=ctQuery.from(Vehicle.class);
			ctQuery.select(root);
			
			query=ses.createQuery(ctQuery);
			list=query.getResultList();
			list.forEach(v->{
				System.out.println(v);
			});*/
			
			ses=HibernateUtil.getSession();
			builder=ses.getCriteriaBuilder();
			ctQuery=builder.createQuery(Vehicle.class);
			root=ctQuery.from(Vehicle.class);
			ctQuery.select(root);
			
			param1=builder.parameter(Integer.class);
			param2=builder.parameter(Integer.class);
			
			pdc1=builder.ge(root.get("vid"),param1);
			pdc2=builder.le(root.get("vid"),param2);
			pdc3=builder.and(pdc1,pdc2);
			
			ctQuery.where(pdc3);
			order=builder.desc(root.get("company"));
			ctQuery.orderBy(order);
			
			query=ses.createQuery(ctQuery);
			query.setParameter(param1,1000);
			query.setParameter(param2,1004);
			list=query.getResultList();
			list.forEach(v->{
				System.out.println(v);
			});
			
		}
		catch (HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
    
}
