package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.dao.OneToOnePKDAO;
import com.nt.dao.OneToOnePKDAOImpl;
import com.nt.dto.LibraryMembershipDTO;
import com.nt.dto.StudentDTO;
import com.nt.entity.LibraryMembership;
import com.nt.entity.Student;

public class OneToOnePKServiceImpl implements OneToOnePKService{

	private OneToOnePKDAO dao;
	
	public OneToOnePKServiceImpl() {
	    dao=new OneToOnePKDAOImpl();
	}

	@Override
	public String registerStudentAlongWithLibraryDetails(StudentDTO studentDTO) throws Exception {
           int idVal=0;
           Student student=null;
           LibraryMembershipDTO libraryDTO=null;
           LibraryMembership library=null;
           
           student=new Student();
        
           student.setSname(studentDTO.getSname());
           student.setCoursefee(studentDTO.getCoursefee());
           
           libraryDTO=studentDTO.getLibrary();
           
           library=new LibraryMembership();
           library.setJoinDate(libraryDTO.getJoinDate());
           library.setLibfee(libraryDTO.getLibfee());
           
           student.setLibrary(library);
           library.setStudent(student);
           
           idVal=dao.saveDataUsingParent(student);
           
           if(idVal==0)
        	   return "Object is not saved";
           else
        	   return "Object is saved with id::"+idVal;
	}

	@Override
	public List<StudentDTO> fetchAllStudentDetails() throws Exception {
		List<Student> listStudent=null;
		List<StudentDTO> listStudentDTO=new ArrayList<StudentDTO>();
		
		listStudent=dao.getStudentDetailsUsingParent();
		listStudent.forEach(student->{
			StudentDTO studentDTO=null;
			LibraryMembership library=null;
			LibraryMembershipDTO libraryDTO=null;
			
			studentDTO=new StudentDTO();
			studentDTO.setSrno(listStudentDTO.size()+1);
			studentDTO.setSid(student.getSid());
			studentDTO.setSname(student.getSname());
			studentDTO.setCoursefee(student.getCoursefee());
			
			library=student.getLibrary();
			libraryDTO=new LibraryMembershipDTO();
			if(library!=null) {
			libraryDTO.setLibid(library.getLibid());
			libraryDTO.setLibfee(library.getLibfee());
			libraryDTO.setJoinDate(library.getJoinDate());
			
			studentDTO.setLibrary(libraryDTO);
			libraryDTO.setStudent(studentDTO);
			}
			listStudentDTO.add(studentDTO);
		});
		
		return listStudentDTO;
	}

	@Override
	public void RemoveRecordUsingParent(int id) throws Exception {
		dao.deleteStudentUsingParent(id);	
	}

	@Override
	public String RemoveLibraryDetailsUsingChild(int id) throws Exception {
		int count=0;
		count=dao.deleteLibraryDetailsUsingChild(id);
		if(count==0)
			return "Library Details are not deleted for id::"+id;
		else
			return "Library Details are deleted for id::"+id;
	}
   
}
