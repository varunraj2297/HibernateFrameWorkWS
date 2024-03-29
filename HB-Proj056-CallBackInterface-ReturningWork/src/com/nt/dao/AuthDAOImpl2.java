package com.nt.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import com.nt.utility.HibernateUtil;

public class AuthDAOImpl2 implements AuthDAO {

	private static final String AUTH="CALL P_AUTH(?,?,?)";
	@Override
	public String authenticate(String user, String pass) {
		Session ses=null;
		String result1=null;
		
		try{
			ses=HibernateUtil.getSession();
		    result1=ses.doReturningWork(con->{
					CallableStatement cs=null;
					String result=null;
					
					cs=con.prepareCall(AUTH);
				    
					cs.registerOutParameter(3,Types.VARCHAR);
					cs.setString(1,user);
					cs.setString(2,pass);
					
					cs.execute();
					
					result=cs.getString(3);
					return result;
				}
			);
		}
		catch (HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
		return result1;
	}
	
}
