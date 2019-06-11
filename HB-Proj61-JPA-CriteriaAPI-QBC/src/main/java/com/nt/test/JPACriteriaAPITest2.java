package com.nt.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Vehicle;
import com.nt.utility.HibernateUtil;

public class JPACriteriaAPITest2 {
	public static void main(String[] args) {
		Session ses=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<Object> ctQuery=null;
		CriteriaQuery<Object[]> ctQuery1=null;
		Root<Vehicle> root=null;
		Query query=null;
		List<Object> list=null;
		List<Object[]> list1=null;
		Object[] row=null;
		
		ses=HibernateUtil.getSession();
		try {
			/*builder=ses.getCriteriaBuilder();
			ctQuery=builder.createQuery(Object.class);
			root=ctQuery.from(Vehicle.class);
			ctQuery.multiselect(builder.count(root.get("vid")));
			
			query=ses.createQuery(ctQuery);
			list=query.getResultList();
			System.out.println("records count::"+list.get(0));*/

			builder=ses.getCriteriaBuilder();
			ctQuery1=builder.createQuery(Object[].class);
			root=ctQuery1.from(Vehicle.class);
			
			ctQuery1.multiselect(builder.max(root.get("price")),
					             builder.min(root.get("price")),
					             builder.sum(root.get("price")),
					             builder.avg(root.get("price"))
					            );
			
			query=ses.createQuery(ctQuery1);
			list1=query.getResultList();
			row=list1.get(0);
			
			System.out.println("max price::"+row[0]);
			System.out.println("min price::"+row[1]);
			System.out.println("sum price::"+row[2]);
			System.out.println("avg price::"+row[3]);
			
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
