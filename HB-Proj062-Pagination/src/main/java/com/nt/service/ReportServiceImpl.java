package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.dao.ReportDAO;
import com.nt.dao.ReportDAOImpl;
import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;

public class ReportServiceImpl implements ReportService {

	private ReportDAO dao;
	
	public ReportServiceImpl() {
		dao=new ReportDAOImpl();
	}

	public List<EmployeeDTO> fetchReportData(int pageNo, int pageSize) {
		int startPos=0;
		List<Employee> listEntites=null;
		List<EmployeeDTO> listDtos=new ArrayList<EmployeeDTO>();
		
		startPos=(pageNo*pageSize)-pageSize;
		listEntites=dao.getReportData(startPos, pageSize);
		listEntites.forEach(emp->{
			EmployeeDTO dto=new EmployeeDTO();
			dto.setEno(emp.getEno());
			dto.setEname(emp.getEname());
			dto.setJob(emp.getJob());
			dto.setSal(emp.getSal());
			listDtos.add(dto);
		});
		return listDtos;
	}

	public long fetchCount(int pageSize) {
		long rowCount=0,pageCount=0;
		rowCount=dao.getRecordsCount();
		pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0) {
			pageCount++;
		}
		return pageCount;
	}
}
