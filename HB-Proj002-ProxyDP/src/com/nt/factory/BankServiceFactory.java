package com.nt.factory;

import com.nt.command.BankService;
import com.nt.command.BankServiceImpl;
import com.nt.proxy.BankServiceProxy;

public class BankServiceFactory {
	public BankService getInstance(boolean RBIMonitering) {
		BankService service=null;
		if(RBIMonitering) 
			service=new BankServiceProxy();
		else
			service=new BankServiceImpl();
		return service;
	}
}
