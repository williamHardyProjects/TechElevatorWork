package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Account {
	private long id;
	private User user;
	private BigDecimal balance;
	
	public Account() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
