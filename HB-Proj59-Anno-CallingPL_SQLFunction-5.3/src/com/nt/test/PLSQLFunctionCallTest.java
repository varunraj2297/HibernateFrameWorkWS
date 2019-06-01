package com.nt.test;

import java.util.List;

import com.nt.dao.BankDAO;
import com.nt.dao.BankDAOFactory;

public class PLSQLFunctionCallTest {
    public static void main(String[] args) {
		BankDAO dao=null;
		List<Object[]> list=null;
		
		dao=BankDAOFactory.getInstance();
		
		list=dao.getCustomerDetailsByAdd("hyd");
		
		list.forEach(row->{
			for(Object v:row) {
				System.out.print(v+"   ");
			}
			System.out.println();
		});
	}
}
