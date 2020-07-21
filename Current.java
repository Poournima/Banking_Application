package com.montran.pojo;

public class Current extends Account {
	private int overdraftBalance;
	int overdraft = 50000;

	public Current() {
	}

	public Current(int accountNumber, String name, double balance, int overdraftBalance) {
		super(accountNumber, name, balance);
		this.overdraftBalance = overdraftBalance;
	}

	public int getOverdraftBalance() {
		return overdraftBalance;
	}

	public void setOverdraftBalance(int overdraftBalance) {
		this.overdraftBalance = overdraftBalance;
	}

	@Override
	public boolean withdraw(int amount) {
		if (amount > 0) {
			if (amount <= getBalance()) {
				setBalance(getBalance() - amount);
				return true;
			}
			if (amount > getBalance()) {
				amount = (int) (amount - getBalance());
				setBalance(getBalance() - getBalance());
				overdraftBalance = overdraftBalance - amount;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deposit(int amount) {
		if (amount > 0 && getBalance() >= 0) {
			if (overdraftBalance != overdraft) {
				int overdraftbal = overdraft - overdraftBalance;

				if (overdraftbal > amount) {
					overdraftBalance = overdraftBalance + amount;
				} else {
					overdraftBalance = overdraftBalance + overdraftbal;
					amount = amount - overdraftbal;
					setBalance(getBalance() + amount);
				}
				return true;
			} else {
				setBalance(amount);
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Current [overdraftBalance=" + overdraftBalance + ", getAccountNumber()=" + getAccountNumber()
				+ ", getName()=" + getName() + ", getBalance()=" + getBalance() + "]";
	}

}