package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.StudentCoursesInfo;
import com.nt.entity.StudentId;
import com.nt.util.HibernateUtil;

public class StudentCoursesInfoDAOImpl implements StudentCoursesInfoDAO {

	@Override
	public void saveData() {
		Session ses=null;
		StudentId id=null,idVal=null;
		StudentCoursesInfo info=null;
		Transaction tx=null;
		boolean flag=false;
		
		ses=HibernateUtil.getSession();
		id=new StudentId();
		id.setSid(101);		id.setCourse("Adv.Java");

		info=new StudentCoursesInfo();
		info.setId(id);               info.setSname("srinu");   
		info.setDuration(6);    info.setFee(1000.0f);
		
		try {
			tx=ses.beginTransaction();
			idVal=(StudentId) ses.save(info);
			flag=true;
			System.out.println("StudentId::"+idVal);
		}catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if (flag) {
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
		StudentId id=null;
		StudentCoursesInfo info=null;
		
		ses=HibernateUtil.getSession();
		
		id=new StudentId();
		id.setSid(103); id.setCourse("CoreJava");
		info=ses.get(StudentCoursesInfo.class,id);
		if(info==null) {
			System.out.println("record not found");
			return;
		}
		else 
			System.out.println(info);
		
		HibernateUtil.closeSession(ses);
	}

}
