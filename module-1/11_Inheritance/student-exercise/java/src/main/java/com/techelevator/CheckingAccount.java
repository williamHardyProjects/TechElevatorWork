package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {

	public CheckingAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);

	}

	public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);

	}

	@Override
	public int withdraw(int amountToWithdraw) {
		BigDecimal balanceAfterWithdrawal = new BigDecimal(getBalance()).subtract(new BigDecimal(amountToWithdraw));
		BigDecimal overdraftFee = new BigDecimal("10");
		if (balanceAfterWithdrawal.doubleValue() >= 0) {
			super.withdraw(amountToWithdraw);
		}
		if (-100 < balanceAfterWithdrawal.doubleValue() && balanceAfterWithdrawal.doubleValue() < 0) {
			super.withdraw(new BigDecimal(amountToWithdraw).add(overdraftFee).intValue());
		}
		return getBalance();
	}
}
