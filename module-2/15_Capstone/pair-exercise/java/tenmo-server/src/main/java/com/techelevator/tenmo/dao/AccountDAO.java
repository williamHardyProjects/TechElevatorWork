package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

import com.techelevator.tenmo.model.Account;

public interface AccountDAO {
	Account getAccount(Long id);
	void updateBalance(BigDecimal balance, Long userId);
}
