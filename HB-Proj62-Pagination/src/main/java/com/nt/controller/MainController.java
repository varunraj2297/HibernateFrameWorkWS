package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dto.EmployeeDTO;
import com.nt.service.ReportService;
import com.nt.service.ReportServiceImpl;

@WebServlet("/controller")
public class MainController extends HttpServlet {
	
	private ReportService service;
	int pageSize=0;
	
	@Override
	public void init() throws ServletException {
		service=new ReportServiceImpl();
	}


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String pageNo=null;
		int pgNo=0;
		long pageCount=0;
		List<EmployeeDTO> pageData=null;
		HttpSession ses=null;
		RequestDispatcher rd=null;
		
		
		pageNo=req.getParameter("pageNo");
		if(pageNo==null) {
			pageSize=Integer.parseInt(req.getParameter("pageSize"));
			pgNo=1;
		}
		else {
			pgNo=Integer.parseInt(pageNo);
		}
		
		pageData=service.fetchReportData(pgNo, pageSize);
		pageCount=service.fetchCount(pageSize);
	    
		ses=req.getSession();
		ses.setAttribute("pageData", pageData);
		ses.setAttribute("pageCount",pageCount);
		
		rd=req.getRequestDispatcher("/report.jsp");
		rd.forward(req, res);
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
