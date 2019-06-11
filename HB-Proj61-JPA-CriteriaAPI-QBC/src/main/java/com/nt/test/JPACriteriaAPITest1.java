package com.nt.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Vehicle;
import com.nt.utility.HibernateUtil;

public class JPACriteriaAPITest1 {
	public static void main(String[] args) {
		Session ses=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<Object[]> ctQuery=null;
		CriteriaQuery<Object> ctQuery1=null;
		Root<Vehicle> root=null;
		ParameterExpression<String> param1=null;
		ParameterExpression<Integer> param2=null;
		Predicate pdc1=null;
		Query query=null;
		List<Object[]> list=null;
		List<Object> list1=null;
		
		ses=HibernateUtil.getSession();
		try {
			/*builder=ses.getCriteriaBuilder();
			ctQuery=builder.createQuery(Object[].class);
			root=ctQuery.from(Vehicle.class);
			ctQuery.multiselect(root.get("vid"),root.get("model"),root.get("company"));
			
			param1=builder.parameter(String.class);
			pdc1=builder.like(root.get("model"),param1);
			ctQuery.where(pdc1);
			
			query=ses.createQuery(ctQuery);
			query.setParameter(param1,"b%");
			
			list=query.getResultList();
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+"  ");
				}
				System.out.println();
			});*/
			
			builder=ses.getCriteriaBuilder();
			ctQuery1=builder.createQuery(Object.class);
			root=ctQuery1.from(Vehicle.class);
			
			ctQuery1.multiselect(root.get("model"));
			
			param2=builder.parameter(Integer.class);
			
			pdc1=builder.ge(root.get("price"), param2);
			
			ctQuery1.where(pdc1);
			
			query=ses.createQuery(ctQuery1);
			query.setParameter(param2,6000000);
			list1=query.getResultList();
			list1.forEach(m->{
				System.out.println(m);
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
