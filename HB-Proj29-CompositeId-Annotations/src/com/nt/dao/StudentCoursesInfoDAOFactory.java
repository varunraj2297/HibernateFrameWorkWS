package com.nt.dao;

public class StudentCoursesInfoDAOFactory {
	public static StudentCoursesInfoDAO getInstance() {
		return new StudentCoursesInfoDAOImpl();
	}

}
