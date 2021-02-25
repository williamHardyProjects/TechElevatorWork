package com.techelevator.tenmo.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.UserDAO;
import com.techelevator.tenmo.model.User;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "/users")
public class UserController {
	private UserDAO dao;
	
	public UserController(UserDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<User> getUsers() {
		return dao.findAll();
	}
}
