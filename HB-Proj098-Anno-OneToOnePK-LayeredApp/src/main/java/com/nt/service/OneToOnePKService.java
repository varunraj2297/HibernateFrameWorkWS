package com.nt.service;

import java.util.List;

import com.nt.dto.StudentDTO;

public interface OneToOnePKService {
       public String registerStudentAlongWithLibraryDetails(StudentDTO dto) throws Exception;
       public List<StudentDTO> fetchAllStudentDetails() throws Exception;
       public void RemoveRecordUsingParent(int  id) throws Exception;
       public String RemoveLibraryDetailsUsingChild(int id)throws Exception;
}
