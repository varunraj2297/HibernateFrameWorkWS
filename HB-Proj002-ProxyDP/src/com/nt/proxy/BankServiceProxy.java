package com.nt.proxy;

import com.nt.command.BankService;
import com.nt.command.BankServiceImpl;

public class BankServiceProxy implements BankService {

	@Override
	public String withdraw(int acno, int amt) {
		String result;
		BankService service=new BankServiceImpl();
		if(amt<=200000)
			result=service.withdraw(acno, amt);
		else
			throw new IllegalArgumentException("Amount is greater than 200000 ,get approval from RBI");
		return result;
	}

}
