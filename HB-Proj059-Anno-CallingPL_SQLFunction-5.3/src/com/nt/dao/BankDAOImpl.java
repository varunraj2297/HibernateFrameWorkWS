package com.nt.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.utility.HibernateUtil;

import oracle.jdbc.internal.OracleTypes;





public class BankDAOImpl implements BankDAO {

	@Override
	public List<Object[]> getCustomerDetailsByAdd(String addrs) {
	    Session ses=null;
	    List<Object[]> list1=null;
	    
	    
	    ses=HibernateUtil.getSession();
	    try {
	    list1=ses.doReturningWork(con->{
	    	CallableStatement cs=null;
	    	ResultSet rs=null;
	    	List<Object[]> list=new ArrayList();
	    	cs=con.prepareCall("{?=call fx_get_bankacc_info_byaddrs(?)}");
	    	cs.registerOutParameter(1,OracleTypes.CURSOR);
	    	cs.setString(2,addrs);
	    	//rs=cs.executeQuery();
	    	cs.execute();
	    	
	    	rs=(ResultSet) cs.getObject(1);
	    	while(rs.next()) {
	    		Object row[]=new Object[2];
	    		row[0]=rs.getInt(1);
	    		row[1]=rs.getString(2);
	    		list.add(row);
	    	}
	    	return list;
	    });
	    
	    }
	    catch (HibernateException e) {
			e.printStackTrace();
		}
	    finally {
	    	HibernateUtil.closeSession(ses);
		}
	    return list1;
		/* ProcedureCall call=null;
		Output output=null;
		List<Object[]> list=null;
		
		ses=HibernateUtil.getSession();
		
		call=ses.createStoredProcedureCall("fx_get_bankacc_info_byaddrs");
		
		//call.registerStoredProcedureParameter(1,Class.class,ParameterMode.REF_CURSOR);
		call.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		call.setParameter(1, addrs);
		
		output=call.getOutputs().getCurrent();
		list=((ResultSetOutput) output).getResultList();
		return list;*/
		
		
	}

}
