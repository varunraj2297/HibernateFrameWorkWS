package com.nt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Department;
import com.nt.entity.EmpDetails;
import com.nt.utility.HibernateUtil;

public class ManyToOneDAOImpl implements ManyToOneDAO{

	@Override
	public void saveData() {
		Session ses=null;
		EmpDetails ed1=null,ed2=null;
		Department dept=null;
		Transaction tx=null;
		boolean flag=false;
		
		
		dept=new Department();
		
		dept.setDname("IT");
		dept.setDloc("hyd");
		
		ed1=new EmpDetails();
		
		ed1.setEname("varun");
		ed1.setJob("manager");
		ed1.setSal(90000);
		ed1.setDept(dept);

		ed2=new EmpDetails();
		
		ed2.setEname("karan");
		ed2.setJob("developer");
		ed2.setSal(19000);
		ed2.setDept(dept);
		
		ses=HibernateUtil.getSession();
		try {
		   tx=ses.beginTransaction();
		   ses.save(ed1);
		   ses.save(ed2);
		   flag=true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is saved");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			
			HibernateUtil.closeSession(ses);
		}
	}

	/*@Override
	public void loadData() {
		Session ses=null;
		Query query=null;
		List<User> list=null;
		
		
		ses=HibernateUtil.getSession();
		query=ses.createQuery("from User");
		list=query.getResultList();
		list.forEach(user->{
			System.out.println("parent::"+user);
			Set<Phones> phonesSet=user.getPhones();
			phonesSet.forEach(phone->{
				System.out.println("child::"+phone);
			});
		});
		
		HibernateUtil.closeSession(ses);
		
	     		
	}
	
	@Override
	public void loadDataUsingStreamAPI() {
		Session ses=null;
		Query query=null;
		Stream<User> stream=null;
		
		
		ses=HibernateUtil.getSession();
		query=ses.createQuery("from User");
		stream=query.getResultStream().filter(user->((User)user).getUserid()==1);
		stream.forEach(user->{
			System.out.println("parent::"+user);
			Set<Phones> phonesSet=user.getPhones();
			Stream<Phones> childs=phonesSet.stream();
			childs.forEach(phone->{
				System.out.println("child::"+phone);
			});
		});
		
		HibernateUtil.closeSession(ses);
		
	}
	
	@Override
	public void loadDataUsingParentByUserId(int userId) {
		Session ses=null;
		Query query=null;
		List<User> list=null;
		
		
		ses=HibernateUtil.getSession();
		query=ses.createQuery("from User where userId=:id");
		query.setParameter("id", userId);
		list=query.getResultList();
		list.forEach(user->{
			System.out.println("parent::"+user);
			
			Set<Phones> phonesSet=user.getPhones();
			System.out.println(phonesSet.size());
			phonesSet.forEach(phone->{
				System.out.println("child::"+phone);
			});
		});
		
		HibernateUtil.closeSession(ses);
		
		
	}
	
	@Override
	public void deleteDataUsingParentByUserId(int userId) {
		
		Query query=null;
		Transaction tx=null;
		List<User> list=null;
		boolean flag=false;
		
		
		Session ses=HibernateUtil.getSession();
		query=ses.createQuery("from User where userId=:id");
		query.setParameter("id", userId);
		list=query.getResultList();
		try {
			tx=ses.beginTransaction();
		    list.forEach(user->{
			    System.out.println("parent::"+user);
			    ses.delete(user);
		    });
		    flag=true;
		}
		catch (HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("objects are deleted");
			}
			else {
				tx.rollback();
				System.out.println("objects are not deleted");	
			}
			HibernateUtil.closeSession(ses);
		}
		
	}
	
	@Override
	public void deleteAllChildsOfAParentByUserId(int userId) {
		Query query=null;
		Transaction tx=null;
		List<User> list=null;
		boolean flag=false;
		
		
		Session ses=HibernateUtil.getSession();
		query=ses.createQuery("from User where userId=:id");
		query.setParameter("id", userId);
		list=query.getResultList();
		try {
			tx=ses.beginTransaction();
		    list.forEach(user->{
			    System.out.println("parent::"+user);
			    Set<Phones> phones=user.getPhones();
			    phones.clear();
		    });
		    flag=true;
		}
		catch (HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("objects are deleted");
			}
			else {
				tx.rollback();
				System.out.println("objects are not deleted");	
			}
			HibernateUtil.closeSession(ses);
		}
		
		
	}*/

	/*@Override
	public void deleteOneChildfromCollectionOfChildsOfAParentByUserId() {
		Session ses=null;
		Query query=null;
		Department dept=null;
		EmpDetails ed=null;
		Transaction tx=null;
		List<EmpDetails> list=null;
		boolean flag=false;
		
		
		ses=HibernateUtil.getSession();
		query=ses.createQuery("from EmpDetails");
		list=query.getResultList();
		System.out.println(list);
	
		try {
			//user=ses.get(User.class, userId);
			//childs=user.getPhones();
			//phone=ses.get(Phones.class,7032377196L);
			tx=ses.beginTransaction();
			 list.remove(0);
			flag=true;
		}
		catch (HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("object is deleted");
			}
			else {
				tx.rollback();
				System.out.println("object is not deleted");	
			}
			HibernateUtil.closeSession(ses);
		}
		
	}*/
	
	
	/*@Override
	public void deleteOneChildfromCollectionOfChildsOfAParentByUserId() {
		Session ses=null;
		//Query query=null;
		Department dept=null;
		EmpDetails ed=null;
		Transaction tx=null;
		//List<EmpDetails> list=null;
		boolean flag=false;
		
		
		ses=HibernateUtil.getSession();
		//query=ses.createQuery("from EmpDetails");
		//list=query.getResultList();
		//System.out.println(list);
		ed=ses.get(EmpDetails.class,2);
		ed.setDept(null);
		try {
			//user=ses.get(User.class, userId);
			//childs=user.getPhones();
			//phone=ses.get(Phones.class,7032377196L);
			tx=ses.beginTransaction();
			// list.remove(0);
			ses.delete(ed);
			flag=true;
		}
		catch (HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("object is deleted");
			}
			else {
				tx.rollback();
				System.out.println("object is not deleted");	
			}
			HibernateUtil.closeSession(ses);
		}
		
	}*/
	
	
	
	/*@Override
	public void deleteOneChildfromCollectionOfChildsOfAParentByUserId() {
		Session ses=null;
		Query query=null;
		Department dept=null;
		EmpDetails ed=null;
		Transaction tx=null;
		//boolean flag=false;
		
		
		ses=HibernateUtil.getSession();
		query=ses.createQuery("delete from EmpDetails where empno=:id");
		query.setParameter("id",3);
		
		try {
			//user=ses.get(User.class, userId);
			//childs=user.getPhones();
			//phone=ses.get(Phones.class,7032377196L);
			tx=ses.beginTransaction();
			query.executeUpdate();
			tx.commit();
			// list.remove(0);
			//ses.delete(ed);
			//flag=true;
		}
		catch (HibernateException he) {
			tx.rollback();
			he.printStackTrace();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
		
	}
	*/
	
	@Override
	public void deleteAllChildsWithParent() {
		Session ses=null;
		Query query=null;
		Department dept=null;
		EmpDetails ed=null;
		Transaction tx=null;
		List<EmpDetails> list=null;
		boolean flag=false;
		
		
		ses=HibernateUtil.getSession();
		query=ses.createQuery("from EmpDetails");
		list=query.getResultList();
		System.out.println(list);
	
		try {
			//user=ses.get(User.class, userId);
			//childs=user.getPhones();
			//phone=ses.get(Phones.class,7032377196L);
			tx=ses.beginTransaction();
			 list.clear();
			flag=true;
		}
		catch (HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("object is deleted");
			}
			else {
				tx.rollback();
				System.out.println("object is not deleted");	
			}
			HibernateUtil.closeSession(ses);
		}
		
	}
}
