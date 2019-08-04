package com.nt.dao;

import java.util.List;

import com.nt.entity.Employee;

public interface ReportDAO {
   public List<Employee> getReportData(int startPos,int pageSize);
   public long getRecordsCount();
}
