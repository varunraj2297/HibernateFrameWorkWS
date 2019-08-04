package com.nt.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.LibraryMembership;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {

	@Override
	public void saveDataUsingParent() {
		Session ses = null;
		Student s1 = null, s2 = null, s3 = null;
		LibraryMembership lm1 = null, lm2 = null, lm3 = null;
		Transaction tx = null;
		boolean flag = false;

		ses = HibernateUtil.getSession();
		s1 = new Student();

		s1.setSname("varun");
		s1.setCoursefee(2000);

		s2 = new Student();
		s2.setSname("suresh");
		s2.setCoursefee(2000);

		s3 = new Student();
		s3.setSname("srinivas");
		s3.setCoursefee(1000);

		lm1 = new LibraryMembership();
		lm1.setJoinDate(new Date());
		lm1.setLibfee(1500);

		lm2 = new LibraryMembership();
		lm2.setJoinDate(new Date());
		lm2.setLibfee(2500);

		lm3 = new LibraryMembership();
		lm3.setJoinDate(new Date());
		lm3.setLibfee(3500);

		s1.setLibrary(lm1);
		s2.setLibrary(lm2);
		s3.setLibrary(lm3);

		lm1.setStudent(s1);
		lm2.setStudent(s2);
		lm3.setStudent(s3);
		try {
			tx = ses.beginTransaction();
			ses.save(s1);
			ses.save(s2);
			ses.save(s3);
			flag = true;
		} catch (HibernateException he) {
			flag = false;
			he.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Objects are saved");
			} else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			HibernateUtil.closeSession(ses);
		}

	}

	@Override
	public void saveDataUsingChild() {
		Session ses = null;
		Student s1 = null, s2 = null, s3 = null;
		LibraryMembership lm1 = null, lm2 = null, lm3 = null;
		Transaction tx = null;
		boolean flag = false;

		ses = HibernateUtil.getSession();
		s1 = new Student();
		s1.setSname("varun");
		s1.setCoursefee(2000);

		s2 = new Student();
		s2.setSname("suresh");
		s2.setCoursefee(2000);

		s3 = new Student();
		s3.setSname("srinivas");
		s3.setCoursefee(1000);

		lm1 = new LibraryMembership();
		lm1.setJoinDate(new Date(118, 5, 6));
		lm1.setLibfee(1500);

		lm2 = new LibraryMembership();
		lm2.setJoinDate(new Date(118, 6, 8));
		lm2.setLibfee(2500);

		lm3 = new LibraryMembership();
		lm3.setJoinDate(new Date(118, 8, 24));
		lm3.setLibfee(3500);

		s1.setLibrary(lm1);
		s2.setLibrary(lm2);
		s3.setLibrary(lm3);

		lm1.setStudent(s1);
		lm2.setStudent(s2);
		lm3.setStudent(s3);
		try {
			tx = ses.beginTransaction();
			ses.save(lm1);
			ses.save(lm2);
			ses.save(lm3);
			flag = true;
		} catch (HibernateException he) {
			flag = false;
			he.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Objects are saved");
			} else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			HibernateUtil.closeSession(ses);
		}

	}

	@Override
	public void loadData() {
		Session ses = null;
		Query query = null;
		List<Student> list = null;

		ses = HibernateUtil.getSession();
		try {
			query = ses.createQuery("from Student");
			list = query.getResultList();

			list.forEach(st -> {
				System.out.println("parent::" + st);
				System.out.println("child::" + st.getLibrary());
			});
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(ses);
		}
	}

	@Override
	public void deleteFromParentToChild() {
		Session ses=null;
		Student st=null;
		Transaction tx=null;
		boolean flag=false;
		
		ses=HibernateUtil.getSession();
		try {
		        st=ses.get(Student.class, 105);
		        tx=ses.beginTransaction();
		        ses.delete(st);
		        flag=true; 
    	}
		catch (HibernateException he) {
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Parent to child objects are deleted");
			}
			else {
				tx.rollback();
				System.out.println("Parent to child objects are not deleted");
			}
			HibernateUtil.closeSession(ses);
		}
	}

}
