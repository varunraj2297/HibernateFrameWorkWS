package com.nt.command;

public class BankServiceImpl implements BankService {

	@Override
	public String withdraw(int acno, int amt) {
		System.out.println("BankServiceImpl.withdraw()");
		return "withdrawing "+amt+" from account no "+acno;
	}

}
