package com.nt.test;

import com.nt.dao.TransferDAO;
import com.nt.dao.TransferDAOFactory;

public class TransferObjectTest {
		public static void main(String[] args) {
			TransferDAO dao=TransferDAOFactory.getInstance();
			boolean flag=false;
			flag=dao.transferObject(9041);
			System.out.println(flag?"record transfered":"record not transfered");
		}
}
