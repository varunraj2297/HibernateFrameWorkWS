package com.nt.test;

import com.nt.dao.BankAccountDAO;
import com.nt.dao.BankAccountDAOFactory;
import com.nt.utility.HibernateUtil;

public class LocalTxMgmtTest {

	public static void main(String[] args) {
		BankAccountDAO dao=null;
		boolean isModified=false;
		try {
		       dao=BankAccountDAOFactory.getInstance();
		       isModified=dao.transferMoney(121, 101, 5000);
		       System.out.println("Money is transfered? "+isModified);
		}
		catch (Exception e) {
              e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
