package com.nt.dao;

public interface BankAccountDAO {
	   public int withdraw(int accno,double amount) throws Exception;
	      public int deposite(int accno,double amount) throws Exception;
	      public boolean transferMoney(int srcNo,int destNo,double amount) throws Exception;
}