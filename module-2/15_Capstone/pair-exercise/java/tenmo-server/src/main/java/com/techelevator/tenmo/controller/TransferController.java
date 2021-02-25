package com.techelevator.tenmo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.TransferDAO;
import com.techelevator.tenmo.model.Transaction;
import com.techelevator.tenmo.model.Transfer;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "/users")
public class TransferController {
	private TransferDAO dao;
	private Transaction transaction;
	
	public TransferController(TransferDAO dao, Transaction transaction) {
		this.dao = dao;
		this.transaction = transaction;
	}
	
	@RequestMapping(path = "/{id}/transfers", method = RequestMethod.GET)
	public List<Transfer> getTransfers(@PathVariable Long id) {
		return dao.getTransfers(id);
	}
	
	/*@RequestMapping(path = "/{id}/transfers", method = RequestMethod.GET)
	public List<Transfer> getPendingTransfers(@RequestParam String status, @PathVariable Long id) {
		List<Transfer> pendingTransfers = new ArrayList<Transfer>();
		if (status.equals("pending")) {
			pendingTransfers = dao.getPendingTransfers(id);
		}
		return pendingTransfers;
	}*/
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/{id}/transfers", method = RequestMethod.POST)
	public Transfer getTransfers(@RequestBody Transfer transfer, @PathVariable Long id) {
		transaction.setTransfer(transfer);
		return transaction.handleTransaction();
	}
	
	@RequestMapping(path = "/{id}/transfers/{transferId}", method = RequestMethod.GET)
	public Transfer getTransfer(@PathVariable Long id, @PathVariable Long transferId) {
		return dao.getTransfer(id, transferId);
	}

}
