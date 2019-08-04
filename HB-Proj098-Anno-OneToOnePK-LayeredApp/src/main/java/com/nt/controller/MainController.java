package com.nt.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.LibraryMembershipDTO;
import com.nt.dto.StudentDTO;
import com.nt.service.OneToOnePKService;
import com.nt.service.OneToOnePKServiceImpl;

@WebServlet("/controller")
public class MainController extends HttpServlet {
	
	private OneToOnePKService service;
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.nt.utility.HibernateUtil");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		service=new OneToOnePKServiceImpl();
		 
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       System.out.println("MainController.doGet()");
	        String sname=null;
	        float coursefee=0.0f;
	        Date joinDate=null;
	        float libfee=0.0f;
	        StudentDTO studentDTO=null;
	        LibraryMembershipDTO libraryDTO=null;
	        String resultMsg=null;
	        RequestDispatcher rd=null;
	        String path=null;
	        String option=null;
	        List<StudentDTO> listStudentDTO=null;
	        int id=0;
	        
	        try {
		        option=request.getParameter("option");
	        	if(option.equalsIgnoreCase("add")) {
	              sname=request.getParameter("sname");
	              coursefee=Float.parseFloat(request.getParameter("coursefee"));
	              joinDate=convertToDate(request.getParameter("joinDate"));
	              libfee=Float.parseFloat(request.getParameter("libfee"));
	              
	              studentDTO=new StudentDTO();
	              studentDTO.setSname(sname);
	              studentDTO.setCoursefee(coursefee);
	             
	              libraryDTO=new LibraryMembershipDTO();
	              libraryDTO.setJoinDate(joinDate);
	              libraryDTO.setLibfee(libfee);
	              
	              studentDTO.setLibrary(libraryDTO);
	              libraryDTO.setStudent(studentDTO);
	              
	              resultMsg=service.registerStudentAlongWithLibraryDetails(studentDTO);
	              request.setAttribute("resultMsg",resultMsg);
	              
	      
			  	}else if(option.equalsIgnoreCase("display")) {
				      listStudentDTO=service.fetchAllStudentDetails();
				      request.setAttribute("listStudentDTO", listStudentDTO);
				}else if(option.equalsIgnoreCase("deleteParent")) {
				
					  id=Integer.parseInt(request.getParameter("id"));
				      service.RemoveRecordUsingParent(id);
				      resultMsg="Student Object of id "+id+" is Deleted";
				      request.setAttribute("resultMsg", resultMsg);
				      
					  listStudentDTO=service.fetchAllStudentDetails();
				      request.setAttribute("listStudentDTO", listStudentDTO);
					
				}else if(option.equalsIgnoreCase("deleteChild")) {
					
					  id=Integer.parseInt(request.getParameter("id"));
				      resultMsg=service.RemoveLibraryDetailsUsingChild(id);
				      request.setAttribute("resultMsg", resultMsg);
				      
				      listStudentDTO=service.fetchAllStudentDetails();
				      request.setAttribute("listStudentDTO", listStudentDTO);
					
				}
	        	path="/report.jsp";
	        }
	        catch (Exception e) {
	        	if(option.equals("deleteParent")) {
	        	          resultMsg="Student Object of id "+id+" is Deleted";
	        	          request.setAttribute("resultMsg", resultMsg);
	        	}
	        	e.printStackTrace();
	        	path="/error.jsp";
			}
	        
	        rd=request.getRequestDispatcher(path);
	        rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public Date convertToDate(String date) throws Exception{
		SimpleDateFormat format=null;
		format=new SimpleDateFormat("dd/MM/yyyy");
		return format.parse(date);
	}

}
