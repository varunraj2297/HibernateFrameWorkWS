package com.nt.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class ReportDAOImpl implements ReportDAO {

	public List<Employee> getReportData(int startPos, int pageSize) {
		Session ses = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<Employee> ctQuery = null;
		Root<Employee> root = null;
		Transaction tx = null;
		Query query = null;
		List<Employee> list = null;

		try {
			ses = HibernateUtil.getSession();
			tx = ses.beginTransaction();

			builder = ses.getCriteriaBuilder();
			ctQuery = builder.createQuery(Employee.class);
			root = ctQuery.from(Employee.class);
			ctQuery.select(root);

			query = ses.createQuery(ctQuery);
			query.setFirstResult(startPos);
			query.setMaxResults(pageSize);
			list = query.getResultList();
			list.forEach(e -> {
				System.out.println(e);
			});
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			tx.commit();
		}
		return list;
	}

	public long getRecordsCount() {
		Session ses = null;
		Transaction tx = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<Object> ctQuery = null;
		Root<Employee> root = null;
		Query query = null;
		long count = 0;
		try {
			ses = HibernateUtil.getSession();
			tx = ses.beginTransaction();
			builder = ses.getCriteriaBuilder();
			ctQuery = builder.createQuery(Object.class);
			root = ctQuery.from(Employee.class);

			ctQuery.multiselect(builder.count(root.get("eno")));
			query = ses.createQuery(ctQuery);
			count = (long) query.getSingleResult();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			tx.commit();
		}
		return count;
	}

}
