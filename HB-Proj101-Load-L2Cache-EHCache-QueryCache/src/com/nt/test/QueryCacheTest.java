package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nt.entity.InsurancePolicy;

public class QueryCacheTest {

	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory factory = null;
		Session ses1 = null;
		Query query = null;
		List<InsurancePolicy> policyList = null;

		try {

			cfg = new Configuration();
			cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();

			ses1 = factory.openSession();

			// Gets object from DB s/w puts L2,L1 Caches
			query = ses1.createQuery("from InsurancePolicy");
			query.setCacheable(true);
			policyList = query.getResultList();
			policyList.forEach(ip -> {
				System.out.println(ip);
			});
			System.out.println("...............1....................");
			// Gets from L1 Cache

			policyList = query.getResultList();
			policyList.forEach(ip -> {
				System.out.println(ip);
			});
			System.out.println(".................2..................");
			ses1.clear();
			// Gets from L2 Cache and puts L1 cache of ses1
			policyList = query.getResultList();
			policyList.forEach(ip -> {
				System.out.println(ip);
			});
			// ses1.evict(policyList); // removes from L1 cache of ses1
			ses1. clear();  // removes from L1 cache of ses1
			System.out.println("................3........................");
		
			try {
				Thread.sleep(12000);
			} catch (InterruptedException iae) {
				iae.printStackTrace();
			}
			
			// Gets from DB s/w puts in L2 cache and also in L1 cache of ses2
			policyList = query.getResultList();
			policyList.forEach(ip -> {
				System.out.println(ip);
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ses1.close();
			factory.close();
		}
	}
}
