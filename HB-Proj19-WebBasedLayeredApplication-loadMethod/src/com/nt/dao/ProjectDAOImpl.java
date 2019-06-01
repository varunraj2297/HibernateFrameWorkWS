package com.nt.dao;

import javax.sql.DataSource;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.nt.HibernateUtil.HibernateUtil;
import com.nt.entity.Project;

public class ProjectDAOImpl implements ProjectDAO{
	
	

	public ProjectDAOImpl() {
		System.out.println("ProjectDAOImpl-0-param com");
	}

	@Override
	public Project findProject(int pid) {
		Session ses1=null,ses2=null;
		Project proj1=null;
		
		ses1=HibernateUtil.getSession();
        ses2=HibernateUtil.getSession();	
        
    	
		System.out.println(ses1.hashCode()+"   "+ses2.hashCode());
		try{
		    //	proj1=ses1.get(Project.class,pid);
			    proj1=ses1.load(Project.class,pid);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return proj1;
	}
}
