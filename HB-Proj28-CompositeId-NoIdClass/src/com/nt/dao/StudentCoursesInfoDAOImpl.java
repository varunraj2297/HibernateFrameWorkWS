package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.StudentCoursesInfo;
//import com.nt.entity.StudentId;
import com.nt.util.HibernateUtil;

public class StudentCoursesInfoDAOImpl implements StudentCoursesInfoDAO {

	@Override
	public void saveData() {
		Session ses=null;
		//StudentId id=null,idVal=null;
		StudentCoursesInfo info=null,idVal=null;
		Transaction tx=null;
		boolean flag=false;
		
		ses=HibernateUtil.getSession();
		//id=new StudentId();
       // id.setSid(101);		id.setCourse("Adv.Java");

		info=new StudentCoursesInfo();
		info.setSid(102);          info.setSname("varun");   info.setCourse("DP");   
		info.setDuration(6);    info.setFee(1500.0f);
		
		try {
			tx=ses.beginTransaction();
			idVal=(StudentCoursesInfo) ses.save(info);
			flag=true;
			System.out.println("StudentCoursesInfo::"+idVal);
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
	//	StudentId id=null;
		StudentCoursesInfo info=null,info1=null;
		
		ses=HibernateUtil.getSession();
		
		//id=new StudentId();
		//id.setSid(103); id.setCourse("CoreJava");
		info=new StudentCoursesInfo();
		info.setSid(103);   info.setCourse("Spring");
		info1=ses.get(StudentCoursesInfo.class,info);
		if(info1==null) {
			System.out.println("record not found");
			return;
		}
		else 
			System.out.println(info1);
		
		HibernateUtil.closeSession(ses);
	}

}
