package com.nt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PersonProfile;
import com.nt.utility.HibernateUtil;

public class PersonDAOImpl implements PersonDAO {
	
	@Override
	public PersonProfile fetchEmpById(int no) {
		Session ses=null;
		PersonProfile profile=null;
		try{
			ses=HibernateUtil.getSession();
			profile=ses.get(PersonProfile.class,no);	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
		
		return profile;
	}

	@Override
	public int insertPerson(PersonProfile profile) {
		Session ses=null;
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			count=(int) ses.save(profile);
			flag=true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
			}
			else {
				tx.rollback();
			}
			HibernateUtil.closeSession(ses);
		}
		return count;
	}

	@Override
	public List<PersonProfile> getAllData() {
		Session ses=null;
		List<PersonProfile> list=null;
		Query query=null;
		
	    try {
	    	ses=HibernateUtil.getSession();
	    	query=ses.createQuery("from PersonProfile");
	    	list=query.getResultList();
	    }
	    catch (HibernateException he) {
			he.printStackTrace();
		}
	    finally {
			HibernateUtil.closeSession(ses);
		}
		
		return list;
	}

	@Override
	public List<PersonProfile> getDataByField(String street) {
		Session ses=null;
		List<PersonProfile> list=null;
		Query query=null;
		
	    try {
	    	ses=HibernateUtil.getSession();                    
	    	query=ses.createQuery("from PersonProfile where addrs.street=:galli");
	    	query.setParameter("galli", street);                 //or street
	    	list=query.getResultList();
	    }
	    catch (HibernateException he) {
			he.printStackTrace();
		}
	    finally {
			HibernateUtil.closeSession(ses);
		}
		
		return list;
	}
}
