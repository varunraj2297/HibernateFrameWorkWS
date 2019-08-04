package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.nt.entity.Vehicle;
import com.nt.utility.HibernateUtil;

public class QBCTest1 {
	public static void main(String[] args) {
	   Session ses=null;
	   Criteria criteria=null;
	   Projection p1=null,p2=null,p3=null,p4=null;
		ProjectionList projlist=null;
	   List<Object[]> list=null;
	   List<Object> list1=null;
//	   Object[] row=null;
	   
	   ses=HibernateUtil.getSession();	
	   try {
			criteria=ses.createCriteria(Vehicle.class);
			
			p1=Projections.property("vid");
			p2=Projections.property("type");
			p3=Projections.property("model");
			
			projlist=Projections.projectionList();
			projlist.add(p1); projlist.add(p2); projlist.add(p3);
			criteria.setProjection(projlist);
			
			list=criteria.list();
			list.forEach(row->{
			   for(Object val:row) {
			      System.out.print(val+" ");
	
			  }
			   System.out.println();
			});
		   
			/*criteria=ses.createCriteria(Vehicle.class);
			p1=Projections.rowCount();
			criteria.setProjection(p1);
			list1=criteria.list();
			System.out.println("Row Count::"+list1.get(0));*/
		   
	/*	   criteria=ses.createCriteria(Vehicle.class);
		   projlist=Projections.projectionList();
		   p1=Projections.max("price");
		   p2=Projections.min("price");
		   p3=Projections.sum("price");
		   p4=Projections.avg("price");
		   projlist.add(p1);  projlist.add(p2); 
		   projlist.add(p3);  projlist.add(p4);
		   
		   criteria.setProjection(projlist);
		   
		   list=criteria.list();
		   row=list.get(0);
		   
		   System.out.println("Max Price value::"+row[0]);
		   System.out.println("Min Price value::"+row[1]);
		   System.out.println("Sum Price value::"+row[2]);
		   System.out.println("Avg Price value::"+row[3]);
		   
		  */ 
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
