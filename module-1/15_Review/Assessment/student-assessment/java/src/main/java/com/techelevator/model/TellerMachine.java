package com.techelevator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TellerMachine {
	private String manufacturer;
	private double deposits;
	private double withdrawals;
	public TellerMachine(String manufacturer, double deposits, double withdrawals) {
		super();
		this.manufacturer = manufacturer;
		this.deposits = deposits;
		this.withdrawals = withdrawals;
	}
	
	public double getBalance() {
		BigDecimal depositDec = new BigDecimal(deposits),
				withdrawalDec = new BigDecimal(withdrawals);
		BigDecimal balance = depositDec.subtract(withdrawalDec).setScale(2, RoundingMode.HALF_UP);
		return balance.doubleValue();
	}
	
	public boolean isValidCard(String cardNumber) {
		
		Pattern cardType1 = Pattern.compile("^5\\p{Digit}{15}$");
		Pattern cardType2 = Pattern.compile("^4(\\p{Digit}{12}|\\p{Digit}{15})$");
		Pattern cardType3 = Pattern.compile("^3(4|7).*");
		
		Matcher card1Match = cardType1.matcher(cardNumber);
		Matcher card2Match = cardType2.matcher(cardNumber);
		Matcher card3Match = cardType3.matcher(cardNumber);
		
		return card1Match.matches() || card2Match.matches() || card3Match.matches();
	}

	@Override
	public String toString() {
		return "ATM - " + manufacturer + " - " + getBalance();
	}	
}
