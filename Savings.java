package com.montran.pojo;

public class Savings extends Account {

	private boolean isSalary;
	
	public Savings() {
		System.out.println("Default Constructor of savings !!");
		
	}
	
	public Savings(int accountNumber,String name,double balance,boolean isSalary)
	{
		super(accountNumber,name,balance);
		this.isSalary=isSalary;
		
	}
	public boolean isSalary() {
		return isSalary;
	}
	public void setSalary(boolean isSalary) {
		this.isSalary = isSalary;
	}
	
	@Override
	public boolean withdraw(int amount) {
		if(amount > 0)
		{
		 if(isSalary && amount <= getBalance())
		 {
			setBalance(getBalance()- amount);
			return true;
		 }
		 if(isSalary== false && getBalance() - amount>=500)
		 {
			 setBalance(getBalance()- amount);
			return true; 
		 }
		}
		return false;
		
	}
	
	@Override
	public boolean deposit(int amount) {
		if(amount > 0)
		{
			setBalance(getBalance() + amount);
			return true;
		}
		
		return false;
	}
	@Override
	public String toString() {
		return "Savings [isSalary=" + isSalary + ", getAccountNumber()=" + getAccountNumber() + ", getName()="
				+ getName() + ", getBalance()=" + getBalance() + "]";
	}
		
}
