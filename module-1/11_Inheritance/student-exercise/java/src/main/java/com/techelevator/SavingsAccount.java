package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {

	public SavingsAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);
	}
	
	public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);
	}

	@Override
	public int withdraw(int amountToWithdraw) {
		BigDecimal balanceAfterWithdrawal = new BigDecimal(getBalance()).subtract(new BigDecimal(amountToWithdraw));
		BigDecimal serviceFee = new BigDecimal("2");
		if (balanceAfterWithdrawal.doubleValue() >= 150) {
			super.withdraw(amountToWithdraw);
		}
		if (0 <= balanceAfterWithdrawal.doubleValue() && balanceAfterWithdrawal.doubleValue() < 150) {
			super.withdraw(new BigDecimal(amountToWithdraw).add(serviceFee).intValue());
		}
		return getBalance();
	}
}
