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
		Session ses=null;
		Project proj=null;
		
		ses=HibernateUtil.getSession();
	
		try{
			proj=ses.get(Project.class,pid);
			//System.out.println(proj);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return proj;
	}
}
