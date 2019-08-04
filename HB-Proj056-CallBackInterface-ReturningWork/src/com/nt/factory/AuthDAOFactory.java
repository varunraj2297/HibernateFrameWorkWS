package com.nt.factory;

import com.nt.dao.AuthDAO;
import com.nt.dao.AuthDAOImpl2;

public class AuthDAOFactory {
	public static AuthDAO getInstance() {
		//return new AuthDAOImpl();
		//return new AuthDAOImpl1();
		return new AuthDAOImpl2();
	}
}
