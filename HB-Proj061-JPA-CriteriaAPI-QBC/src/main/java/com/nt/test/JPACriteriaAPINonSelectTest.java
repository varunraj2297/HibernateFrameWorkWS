package com.nt.test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Vehicle;
import com.nt.utility.HibernateUtil;

public class JPACriteriaAPINonSelectTest {
 
	public static void main(String[] args) {
	  Session ses=null;
	  CriteriaBuilder builder=null;
	  CriteriaUpdate<Vehicle> ctUpdate=null;
	  CriteriaDelete<Vehicle> ctDelete=null;
	  Root<Vehicle> root=null;
	  //ParameterExpression<String> param1=null;
	  //ParameterExpression<Integer> param2=null;
	  Predicate predicate=null;
	  Query query=null;
	  int count=0;
	  Transaction tx=null;
	  boolean flag=false;
	  
	  ses=HibernateUtil.getSession();
	  try {
			/*builder=ses.getCriteriaBuilder();
			ctUpdate=builder.createCriteriaUpdate(Vehicle.class);
			root=ctUpdate.from(Vehicle.class);
			
			ctUpdate.set("price",80000);
			//param1=builder.parameter(String.class);
			//predicate=builder.equal(root.get("company"), param1);  //parameters are not working here
			predicate=builder.equal(root.get("company"), "lml");
			ctUpdate.where(predicate);
			query=ses.createQuery(ctUpdate);
			//query.setParameter(param1,"lml");
			tx=ses.beginTransaction();
			count=query.executeUpdate();
			flag=true;*/

	        builder=ses.getCriteriaBuilder();
	        ctDelete=builder.createCriteriaDelete(Vehicle.class);
	        root=ctDelete.from(Vehicle.class);
	        
	        //param2=builder.parameter(Integer.class);
	        //predicate=builder.equal(root.get("vid"),param2);
	        predicate=builder.equal(root.get("vid"),2001);
	        ctDelete.where(predicate);
	        
	        query=ses.createQuery(ctDelete);
	        //query.setParameter(param2,2001);
	        
	        tx=ses.beginTransaction();
	        count=query.executeUpdate();
	        flag=true;
	  
	  }
	  catch (HibernateException he) {
		he.printStackTrace();
		flag=false;
	  }
	  finally {
		if (flag) {
			tx.commit();
			System.out.println(count+" no of records are updated/deleted");
		}
		else {
			tx.rollback();
			System.out.println("no records found to update/delete");
		}
		
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	  }
   }
}
