package com.nt.test;

import com.nt.command.BankService;
import com.nt.factory.BankServiceFactory;

public class ProxyDPTest {

	public static void main(String[] args) {
		BankServiceFactory factory=new BankServiceFactory();
		BankService service=null;
		try
		{
			service=factory.getInstance(true);
			System.out.println(service.withdraw(1001, 300000));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try
		{
			service=factory.getInstance(true);
			System.out.println(service.withdraw(1001, 100000));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try
		{
			service=factory.getInstance(false);
			System.out.println(service.withdraw(1001, 300000));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try
		{
			service=factory.getInstance(false);
			System.out.println(service.withdraw(1001, 100000));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
