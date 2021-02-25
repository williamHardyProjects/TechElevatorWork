package com.techelevator.tenmo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.model.Account;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "/users")
public class AccountController {
	private AccountDAO dao;
	
	public AccountController(AccountDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(path = "{id}/accounts", method = RequestMethod.GET)
	public Account getAccount(@PathVariable Long id) {
		return dao.getAccount(id);
	}
}
