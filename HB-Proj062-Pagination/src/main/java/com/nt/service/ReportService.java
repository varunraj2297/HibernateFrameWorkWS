package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface ReportService {
    public List<EmployeeDTO> fetchReportData(int pageNo,int pageSize);
    public long fetchCount(int pageSize);
}
