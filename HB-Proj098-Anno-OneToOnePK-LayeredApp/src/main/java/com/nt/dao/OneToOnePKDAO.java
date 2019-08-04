package com.nt.dao;

import java.util.List;

import com.nt.entity.Student;

public interface OneToOnePKDAO {
     public int saveDataUsingParent(Student student) throws Exception;
     public List<Student> getStudentDetailsUsingParent() throws Exception;
     public void deleteStudentUsingParent(int id)throws Exception;
     public int deleteLibraryDetailsUsingChild(int id)throws Exception;
}
