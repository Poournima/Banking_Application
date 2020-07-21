package com.montran.pojo;

public class Account {
	private int accountNumber;
	private String name;
	private double balance;
	
	
	public Account() {
		System.out.println("Default constructor of Account");
	}
	public Account(int accountnumber,String name,double balance)
	{
		System.out.println("parametarized Constructor");
		this.accountNumber=accountnumber;
		this.name=name;
		this.balance=balance;
	}
	//ctrl+shift+s
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean deposit(int amount) 
	{
		if(amount > 0)
		{
			
			balance= balance + amount;
			return true;
		}
		return false;
		
	
	}
	
	public boolean withdraw(int amount) 
	{
		if (amount >0 && amount <= balance)
		{
			balance=balance-amount;
			return true;
		}
		return false;
		
	}
   //ToString method shortcut right click-->source-->generate toString

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}
	
}

