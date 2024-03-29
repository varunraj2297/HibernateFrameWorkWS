package com.nt.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import com.nt.utility.HibernateUtil;

public class AuthDAOImpl implements AuthDAO {

	private static final String AUTH="CALL P_AUTH(?,?,?)";
	@Override
	public String authenticate(String user, String pass) {
		Session ses=null;
		String result=null;
		
		try{
			ses=HibernateUtil.getSession();
		    result=ses.doReturningWork(new Authencation(user, pass));
		}
		catch (HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
		return result;
	}
	
	public static class Authencation implements ReturningWork<String>{
        String user,pass;
		
		public Authencation(String user, String pass) {
			this.user = user;
			this.pass = pass;
		}

		@Override
		public String execute(Connection con) throws SQLException {
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
	}
}
