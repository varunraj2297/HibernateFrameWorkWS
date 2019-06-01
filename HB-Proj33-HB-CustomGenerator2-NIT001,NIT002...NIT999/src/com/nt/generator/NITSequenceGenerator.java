package com.nt.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.nt.util.HibernateUtil;

public class NITSequenceGenerator implements IdentifierGenerator {
	private static final String NIT_SEQ="SELECT NIT_SEQ.NEXTVAL FROM DUAL";

	@Override
	public Serializable generate(SharedSessionContractImplementor ses, Object arg1) throws HibernateException {
	       Connection con=null;
	       PreparedStatement ps=null;
	       ResultSet rs=null;
	       int val=0;
	       String result=null;
	       
	       con=ses.connection();
	       try {
		         ps=con.prepareStatement(NIT_SEQ);
		         rs=ps.executeQuery();
		         
		         if(rs.next()) {
		        	 val=rs.getInt(1);
		              result=((val<9)?"NIT00"+val:(val<99)?"NIT0"+val:"NIT"+val);
		         }
	       }
	       catch (Exception e) {
			   e.printStackTrace();
			   return "-1";
		   }
	       finally {
	    	   if(rs!=null) {
	    		  try {
	    		   rs.close();
	    		  }
	    		  catch (Exception e) {
					e.printStackTrace();
				  }
	    	   }
	    		if(ps!=null) {
	    			try {
	    				ps.close();
	    			}
	    			catch (Exception e) {
						e.printStackTrace();
					}
	    		}	  
	  }//finally
	   return result;     
  }//method
}//class

