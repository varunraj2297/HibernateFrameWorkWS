package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.utility.HibernateUtil;

public class ManyToManyDAOImpl implements ManyToManyDAO{

	public void saveDataUsingParent() {
		Session ses=null;
		Doctor doc1=null,doc2=null;
		Patient pat1=null,pat2=null,pat3=null;
        Transaction tx=null;
        boolean flag=false;
		
		doc1=new Doctor();
		doc1.setDocName("jon");
		doc1.setSpecialization("ortho");
		
		doc2=new Doctor();
		doc2.setDocName("hon");
		doc2.setSpecialization("cardio");
		
		
		pat1=new Patient();
		pat1.setPatName("rohit");
		pat1.setDisease("fever");
		
		pat2=new Patient();
		pat2.setPatName("honey");
		pat2.setDisease("headache");
		
		pat3=new Patient();
		pat3.setPatName("jonny");
		pat3.setDisease("toothpain");
		
		
		doc1.getPatients().add(pat1);
		doc1.getPatients().add(pat2);
		doc1.getPatients().add(pat3);
		doc2.getPatients().add(pat2);
	
		
		pat1.getDoctors().add(doc1);
		pat2.getDoctors().add(doc1);
		pat3.getDoctors().add(doc1);
		pat2.getDoctors().add(doc2);

		
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			ses.save(doc1);
			ses.save(doc2);
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
	
	/*	public void saveDataUsingChilds() {
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
			ses.save(student1);
			ses.save(student2);
			ses.save(student3);
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
		
	}*/

}
