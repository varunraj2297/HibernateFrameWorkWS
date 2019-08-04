package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurancePolicy;

public class GetMethodTest {
	
	
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses1=null,ses2=null;
		InsurancePolicy policy=null;
		
		try {
		cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		
		ses1=factory.openSession();
		ses2=factory.openSession();
		//Gets object from DB s/w puts L2,L1 Caches
				policy=ses1.get(InsurancePolicy.class,1001);
				System.out.println(policy);
				System.out.println("...............1....................");
				//Gets from  L1 Cache
				policy=ses1.get(InsurancePolicy.class,1001);
				System.out.println(policy);
				System.out.println(".................2..................");
					ses1.clear();
				//Gets from  L2 Cache and puts L1 cache of ses1
				policy=ses1.get(InsurancePolicy.class,1001);
				System.out.println(policy);
				ses1.evict(policy); //removes from L1 cache of ses1
				System.out.println("................3........................");
				//Gets from  L2 Cache and puts L1 cache of ses2
						policy=ses2.get(InsurancePolicy.class,1001);
						System.out.println(policy);
						ses2.clear();
						System.out.println("................4.......................");
						try {
							Thread.sleep(12000);
						}
						catch(InterruptedException iae) {
							iae.printStackTrace();
						}
			
						//Gets from  DB s/w puts in L2 cache and also in L1 cache of ses2
						policy=ses2.get(InsurancePolicy.class,1001);
						System.out.println(policy);
				

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ses1.close();
			ses2.close();
			factory.close();
		}	
	}
}
