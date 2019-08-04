package com.nt.dao;



import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
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
			person.setName("srinivas");
			person.setAddrs("hyd");
			
			employee=new Employee();
			employee.setName("varun");
			employee.setAddrs("hyd");
			employee.setDesg("CEO");
			employee.setSalary(9999999999.0f);
			
			student=new Student();
			student.setName("vineeth");
			student.setAddrs("hyd");
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

	public void loadData() {
		Session ses=null;
		Query query=null;
		List<Person> listPersons=null;
		List<Employee> listEmployees=null;
		List<Student> listStudents=null;

		try {
			ses=HibernateUtil.getSession();
			
			query=ses.createQuery("from Person");
			listPersons=query.getResultList();
			listPersons.forEach(per->{
				System.out.println(per);
			});
			
			query=ses.createQuery("from Employee");
			listEmployees=query.getResultList();
			listEmployees.forEach(emp->{
				System.out.println(emp);
			});
			
			query=ses.createQuery("from Student");
			listStudents=query.getResultList();
			listStudents.forEach(stud->{
				System.out.println(stud);
			});
			
		}
		catch (HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
		
	}
}
