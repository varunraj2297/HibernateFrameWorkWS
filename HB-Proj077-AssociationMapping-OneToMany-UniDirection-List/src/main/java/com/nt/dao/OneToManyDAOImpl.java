package com.nt.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Phones;
import com.nt.entity.User;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO{

	@Override
	public void saveData() {
		Session ses=null;
		Phones phone1=null,phone2=null;
		List<Phones> phonesList=null;
		Transaction tx=null;
		boolean flag=false;
		
		User user=null;
		
		phone1=new Phones();
		phone1.setPhoneno(7032377196L);
		phone1.setProvider("airtel");
		phone1.setNumberType("Personal");
		
		phone2=new Phones();
		phone2.setPhoneno(7989454929L);
		phone2.setProvider("jio");
		phone2.setNumberType("Office");

		phonesList=new ArrayList<Phones>();
		phonesList.add(phone1);
		phonesList.add(phone2);
		
		user=new User();
		user.setPhones(phonesList);
		user.setAddress("hyd");
		user.setUname("varun");
		
		ses=HibernateUtil.getSession();
		try {
		   tx=ses.beginTransaction();
		   ses.save(user);
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

	@Override
	public void deleteOneChildfromCollectionOfChildsOfAParentByUserId(int userId) {
		Session ses=null;
		//Query query=null;
		User user=null;
		Transaction tx=null;
		//List<User> list=null;
		List<Phones> childs=null;
		//Phones phone=null;
		boolean flag=false;
		
		
		ses=HibernateUtil.getSession();
		//query=ses.createQuery("from User where userId=:id");
		//query.setParameter("id", userId);
		//list=query.getResultList();
		try {
			user=ses.get(User.class, userId);
			childs=user.getPhones();
			//phone=ses.get(Phones.class,7032377196L);
			tx=ses.beginTransaction();
			/* list.forEach(user->{
			    System.out.println("parent::"+user);
			    Set<Phones> phones=user.getPhones();
			    phones.clear();
			});*/
			//childs.remove(phone);
		    childs.remove(0);
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
