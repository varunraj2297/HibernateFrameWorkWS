package com.nt.dao;

public class NGOMembersDAOFactory {
        public static NGOMembersDAO getInstance() {
        	return new NGOMembersDAOImpl();
        }
	  
}
