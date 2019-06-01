package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.HibernateUtil.HibernateUtil;
import com.nt.dto.ProjectDTO;
import com.nt.entity.Project;
import com.nt.service.ProjectService;
import com.nt.service.ProjectServiceImpl;


public class MainController extends HttpServlet {

	private ProjectService projService;
    
    public MainController() {
    	System.out.println("Main Controller");
    }
    
    

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}



	@Override
	public void init() throws ServletException {
		projService=new ProjectServiceImpl();
	}



	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//PrintWriter pw=null;
		//res.setContentType("text/html");
		ProjectDTO projdto=null;
		RequestDispatcher rd=null;
		//pw=res.getWriter();
		int pid=0;
		pid=Integer.parseInt(req.getParameter("projid"));
		if(projService!=null) {
		projdto=projService.searchProject(pid);
		}
		//pw.println("<h1>"+projdto.getProjid()+"  "+projdto.getProjname()+"  "+projdto.getDomain()+"    "+projdto.getTeamsize()+"    "+projdto.getProjstartdate()+"   "+projdto.getProjenddate()+"   </h1>");
		//pw.close();
		req.setAttribute("dto",projdto);
		rd=req.getRequestDispatcher("/results.jsp");
		rd.forward(req, res);
		
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
