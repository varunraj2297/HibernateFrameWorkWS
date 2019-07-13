package com.nt.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Passport;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {

	@Override
	public void saveDataUsingChild() {
		Person per1 = null, per2 = null;
		Passport pspt1 = null;
		Session ses = null;
		Transaction tx = null;
		boolean flag = false;

		per1 = new Person();
		per1.setPname("varun");
		per1.setAge((byte) 23);

		per2 = new Person();
		per2.setPname("sainath");
		per2.setAge((byte) 24);

		pspt1 = new Passport();
		pspt1.setNationality("Indian");
		pspt1.setValidFrom(new Date(119, 6, 13));
		pspt1.setValidTo(new Date(129, 6, 13));
		pspt1.setPerson(per1);

		ses = HibernateUtil.getSession();
		try {
			tx = ses.beginTransaction();
			ses.save(pspt1);
			ses.save(per2);
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
			HibernateUtil.closeSessionFactory();
		}
	}

	@Override
	public void loadData() {
		Session ses = null;
		Query query = null;
		List<Passport> listPassports = null;

		ses = HibernateUtil.getSession();
		try {
			query = ses.createQuery("from Passport");
			listPassports = query.getResultList();
			listPassports.forEach(pspt->{
				System.out.println("child::"+pspt);
				//Person per=pspt.getPerson();
				//System.out.println("parent::"+per);
			});
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}

	}

}
