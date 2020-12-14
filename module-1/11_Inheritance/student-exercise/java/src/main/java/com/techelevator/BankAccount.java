package com.techelevator;

import java.math.BigDecimal;

public class BankAccount {
	private String accountHolderName;
	private String accountNumber;
	private int balance;
	
	public BankAccount(String accountHolderName, String accountNumber) {
		this(accountHolderName, accountNumber, 0);
	}

	public BankAccount(String accountHolderName, String accountNumber, int balance) {
		super();
		this.balance = balance;
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public int getBalance() {
		return balance;
	}
	
	public int deposit(int amountToDeposit) {
		balance = new BigDecimal(balance).add(new BigDecimal(amountToDeposit)).intValue();
		return balance;
	}
	
	public int withdraw(int amountToWithdraw) {
		balance = new BigDecimal(balance).subtract(new BigDecimal(amountToWithdraw)).intValue();
		return balance;
	}
}
