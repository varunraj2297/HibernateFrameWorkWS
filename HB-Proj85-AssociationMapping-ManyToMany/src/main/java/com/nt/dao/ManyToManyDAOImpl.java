package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Faculty;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class ManyToManyDAOImpl implements ManyToManyDAO{

	public void saveData() {
		Session ses=null;
		Faculty faculty1=null,faculty2=null,faculty3=null;
		Student student1=null,student2=null,student3=null;
        Transaction tx=null;
        boolean flag=false;
		
		faculty1=new Faculty();
		faculty1.setFname("Hari Krishna");
		faculty1.setSubject("Core Java");
		
		faculty2=new Faculty();
		faculty2.setFname("Nataraz");
		faculty2.setSubject("Spring");
		
		faculty3=new Faculty();
		faculty3.setFname("Ashok");
		faculty3.setSubject("Web Services");
		
		
		student1=new Student();
		student1.setSname("varun");
		student1.setSqualification("B.Tech");
		
		student2=new Student();
		student2.setSname("suresh");
		student2.setSqualification("B.Tech");
		
		student3=new Student();
		student3.setSname("abhi");
		student3.setSqualification("MCA");
		
		
		faculty1.getStudents().add(student1);
		faculty1.getStudents().add(student2);
		faculty2.getStudents().add(student2);
		faculty3.getStudents().add(student1);
		faculty3.getStudents().add(student2);
		faculty3.getStudents().add(student3);
		
		student1.getFaculties().add(faculty1);
		student1.getFaculties().add(faculty3);
		student2.getFaculties().add(faculty1);
		student2.getFaculties().add(faculty2);
		student2.getFaculties().add(faculty3);
		student3.getFaculties().add(faculty3);
		
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			ses.save(faculty1);
			ses.save(faculty2);
			ses.save(faculty3);
			flag=true;
		}
		catch (HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
				
			HibernateUtil.closeSession(ses);
		}
		
	}

}
