package com.nt.test;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class PL_SQLProcedureCallTest {
	public static void main(String[] args) {
		Session ses = null;
		ProcedureCall call=null;
		Output output=null;
		//List<Object[]> list = null;
        List<Employee> list1=null;
		ses = HibernateUtil.getSession();
		
	    //call=ses.createStoredProcedureCall("p_get_emps_by_sal_range");
		call=ses.createStoredProcedureCall("p_get_emps_by_sal_range",Employee.class);
		
		call.registerParameter(1,Class.class,ParameterMode.REF_CURSOR);
	    call.registerParameter(2,Float.class,ParameterMode.IN).bindValue(4000f);
	    call.registerParameter(3,Float.class,ParameterMode.IN).bindValue(6000f);
	
	    output=call.getOutputs().getCurrent();
	    
	    /*list=((ResultSetOutput)output).getResultList();
	    list.forEach(row->{
	    	for(Object val:row) {
	    		System.out.print(val+"  ");
	    	}
	    	System.out.println();
	    });*/

	    list1=((ResultSetOutput)output).getResultList();
	    list1.forEach(e->{
	    	   System.out.println(e);
	    	}
	    );

	    HibernateUtil.closeSession(ses);
	    HibernateUtil.closeSessionFactory();
	}

}
