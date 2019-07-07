package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
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
		Set<Phones> phonesSet=null;
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

		phonesSet=new HashSet<Phones>();
		phonesSet.add(phone1);
		phonesSet.add(phone2);
		
		user=new User();
		user.setPhones(phonesSet);
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

	@Override
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
	
	//supports both xml configured fetch ,java code fetch for HQL
	@Override
	public void loadDataNplus1SelectSolutionUsingHQL() {  
		Session ses=null;
		Query query=null;
		List<User> list=null;
		
		
		ses=HibernateUtil.getSession();
//		query=ses.createQuery("select u from User u inner join u.phones ph");
		query=ses.createQuery("select u from User u inner fetch join u.phones ph");
		
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
	
	
	//xml fetch="join" doesn't work for JPA Criteria supports only Java configured fetch 
	@Override
	public void loadDataNplus1SelectSolutionUsingJPACriteria() {
		Session ses=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<User> ctQuery=null;
		Root<User> root=null;
		Query query=null;
		List<User> list=null;
		
		ses=HibernateUtil.getSession();
		builder=ses.getCriteriaBuilder();
		ctQuery=builder.createQuery(User.class);
		root=ctQuery.from(User.class);
		root.fetch("phones",JoinType.INNER);
		ctQuery.select(root);
		
		query=ses.createQuery(ctQuery);
		list=query.getResultList();
		list.forEach(user->{
			System.out.println("parent::"+user);
			Set<Phones> phones=user.getPhones();
			phones.forEach(phone->{
				System.out.print(phone+"  ");
			});
			System.out.println();
		});
	}
	
	//supports both xml , java based fetch configuration java code fetch dominates xml fetch
	@Override
	public void loadDataNplus1SelectSolutionUsingQBC() {
	  Session ses=null;
	  Criteria criteria=null;
	  List<User> list=null;
	  
	  ses=HibernateUtil.getSession();
	  criteria=ses.createCriteria(User.class);
	  criteria.setFetchMode("phones",FetchMode.JOIN);
	  list=criteria.list();
	  list.forEach(user->{
		  System.out.println("parent::"+user);
		  Set<Phones> phones=user.getPhones();
		  phones.forEach(phone->{
			  System.out.print(phone+"  ");
		  });
		  System.out.println();
	  });
	}
	 
	
	@Override
	public void loadDataNplus1SelectSolutionUsingProperties() {  
		Session ses=null;
		Query query=null;
		List<User> list=null;
		
		
		ses=HibernateUtil.getSession();
		query=ses.createQuery("select u.userid,u.uname,u.address,ph.phoneno,ph.provider,ph.numberType from User u inner join u.phones ph");
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
		
		
	}

	@Override
	public void deleteOneChildfromCollectionOfChildsOfAParentByUserId(int userId) {
		Session ses=null;
		//Query query=null;
		User user=null;
		Transaction tx=null;
		//List<User> list=null;
		Set<Phones> childs=null;
		Phones phone=null;
		boolean flag=false;
		
		
		ses=HibernateUtil.getSession();
		//query=ses.createQuery("from User where userId=:id");
		//query.setParameter("id", userId);
		//list=query.getResultList();
		try {
			user=ses.get(User.class, userId);
			childs=user.getPhones();
			phone=ses.get(Phones.class,7032377196L);
			tx=ses.beginTransaction();
			/* list.forEach(user->{
			    System.out.println("parent::"+user);
			    Set<Phones> phones=user.getPhones();
			    phones.clear();
			});*/
			childs.remove(phone);
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
