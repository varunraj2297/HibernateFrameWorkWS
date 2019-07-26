package com.nt.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class OneToOnePKDAOImpl  implements OneToOnePKDAO{

	@Override
	public int saveDataUsingParent(Student student) throws Exception {
		Session ses=null;
		int idVal=0;
	    Transaction tx=null;
		boolean isSaved=false;
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			idVal=(int) ses.save("Student",student);
			isSaved=true;
		}	
		catch (HibernateException he) {
			isSaved=false;
			throw he;
		}
		catch (Exception e) {
			isSaved=false;
			throw e;
		}
		finally {
			if (isSaved) 
				tx.commit();
			else 
				tx.rollback();
		}
		return idVal;
	}

	@Override
	public List<Student> getStudentDetailsUsingParent() throws Exception {
		Session ses=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<Student> ctQuery=null;
		Root<Student> root=null;
		Query<Student> query=null;
		List<Student> listStudent=null;
		
		
		ses=HibernateUtil.getSession();
		
		ses.beginTransaction();
		
		builder=ses.getCriteriaBuilder();
		ctQuery=builder.createQuery(Student.class);
		root=ctQuery.from(Student.class);
		ctQuery.select(root);
		
		query=ses.createQuery(ctQuery);
		listStudent=query.getResultList();
		
		return listStudent;
	}

	@Override
	public void deleteStudentUsingParent(int id) throws Exception {
		Session ses=null;
		Transaction tx=null;
		Student student=null;
		boolean isDeleted=false;
		try {
		ses=HibernateUtil.getSession();
		tx=ses.beginTransaction();
		student=ses.get(Student.class, id);
		
		ses.delete("Student",student);
		isDeleted=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if(isDeleted) {
				tx.commit();
			}
			
		}
	}
}
