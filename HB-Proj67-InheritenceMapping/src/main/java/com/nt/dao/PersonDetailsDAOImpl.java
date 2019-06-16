package com.nt.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class PersonDetailsDAOImpl implements PersonDetailsDAO{

	public void insertPersonDetails() {
		Session ses=null;
		Transaction tx=null;
		Person person=null;
		Employee employee=null;
		Student student=null;
		boolean flag=false;
		try {
			person=new Person();
			person.setName("varun");
			person.setAddrs("hyderabad");
			
			employee=new Employee();
			employee.setDesg("CEO");
			employee.setSalary(9999999999.0f);
			
			student=new Student();
			student.setResult("PASS");
			student.setAvg(100.0f);
			
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			ses.save(person);
			ses.save(employee);
			ses.save(student);
			flag=true;

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("objects are not saved");
			}
			HibernateUtil.closeSession(ses);
		}
	}
}
