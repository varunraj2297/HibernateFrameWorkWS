package com.nt.dao;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Programmer;
import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class ManyToManyDAOImpl implements ManyToManyDAO {

	public void saveDataUsingParents() {
		Programmer p1=null,p2=null,p3=null;
		Project proj1=null,proj2=null;
		Transaction tx=null;
		boolean flag=false;
		
		//prepare objs
		p1=new Programmer();
		p1.setPname("raja");
		p1.setSalary(9000);
		
		p2=new Programmer();
		p2.setPname("rani");
		p2.setSalary(8000);
		
		p3=new Programmer();
		p3.setPname("suresh");
		p3.setSalary(10000);
		
		proj1=new Project();
		proj1.setProjName("OpenFx");
		proj1.setDomain("FS");
		
		proj2=new Project();
		proj2.setProjName("UHG");
		proj2.setDomain("HC");
		
		//assign  childs to parents
		p1.getProjects().add(proj1);
		p1.getProjects().add(proj2);
		
		p2.getProjects().add(proj1);
		
		p3.getProjects().add(proj1);
		p3.getProjects().add(proj2);
		
	   //assign  Parents to Childs
		proj1.getProgramemrs().add(p1);
		proj1.getProgramemrs().add(p2);
		proj1.getProgramemrs().add(p3);
		
		proj2.getProgramemrs().add(p1);
		proj2.getProgramemrs().add(p3); 
		
		try(Session ses=HibernateUtil.getSession()){
			//begin Transaction
			tx=ses.beginTransaction();
			   //save objs parent  to childs
			   ses.save(p1); ses.save(p2);
			   ses.save(p3);
			
			   flag=true;
			   
			   if(flag) {
				   tx.commit();
				   System.out.println("Objects are saved");
			   }
			   else {
				   tx.rollback();
				   System.out.println("objects are not saved");
			   }
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}//method

	@Override
	public void saveDataUsingChilds() {
		Programmer p1=null,p2=null,p3=null;
		Project proj1=null,proj2=null;
		Transaction tx=null;
		boolean flag=false;
		
		//prepare objs
		p1=new Programmer();
		p1.setPname("sunil");
		p1.setSalary(9000);
		
		p2=new Programmer();
		p2.setPname("anitha");
		p2.setSalary(8000);
		
		p3=new Programmer();
		p3.setPname("karan");
		p3.setSalary(10000);
		
		proj1=new Project();
		proj1.setProjName("BA");
		proj1.setDomain("Travel");
		
		proj2=new Project();
		proj2.setProjName("AB");
		proj2.setDomain("Travel");
		
		//assign  childs to parents
		p1.getProjects().add(proj1);
		p1.getProjects().add(proj2);
		
		p2.getProjects().add(proj1);
		
		p3.getProjects().add(proj1);
		p3.getProjects().add(proj2);
		
	   //assign  Parents to Childs
		proj1.getProgramemrs().add(p1);
		proj1.getProgramemrs().add(p2);
		proj1.getProgramemrs().add(p3);
		
		proj2.getProgramemrs().add(p1);
		proj2.getProgramemrs().add(p3); 
		
		try(Session ses=HibernateUtil.getSession()){
			//begin Transaction
			tx=ses.beginTransaction();
			   //save objs parent  to childs
			  ses.save(proj1);
			  ses.save(proj2);
			  
			   flag=true;
			   
			   if(flag) {
				   tx.commit();
				   System.out.println("Objects are saved");
			   }
			   else {
				   tx.rollback();
				   System.out.println("objects are not saved");
			   }
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}

		
	}
}//class
