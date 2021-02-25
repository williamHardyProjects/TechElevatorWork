package com.techelevator.tenmo.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.TransferDAO;

@Component
public class Transaction {
	private Account fromAccount;
	private Account toAccount;
	private AccountDAO accountDAO;
	private TransferDAO transferDAO;
	private Transfer transfer;
	
	public Transaction(AccountDAO accountDAO, TransferDAO transferDAO) {
		this.accountDAO = accountDAO;
		this.transferDAO = transferDAO;
	}
	
	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}
	
	public Transfer handleTransaction() {
		Transfer completedTransfer = null;
		if (transfer.getType().getType().equals("Send")) {
			transfer.getType().setTypeId(2);
			completedTransfer = sendMoney();
		}
		return completedTransfer;
	}
	
	public Transfer sendMoney() {
		BigDecimal amount = transfer.getAmount();
		Long fromUserId = transfer.getFrom().getUser().getId();
		Long toUserId = transfer.getTo().getUser().getId();
		fromAccount = accountDAO.getAccount(fromUserId);
		toAccount = accountDAO.getAccount((toUserId));
		BigDecimal fromBalance = fromAccount.getBalance().subtract(amount);
		BigDecimal toBalance = toAccount.getBalance().add(amount);
		transfer.getFrom().setId(fromUserId);
		transfer.getTo().setId(toUserId);
		if (fromBalance.compareTo(BigDecimal.ZERO) > 0) {
			accountDAO.updateBalance(fromBalance, fromUserId);
			accountDAO.updateBalance(toBalance, toUserId);
			TransferStatus status = new TransferStatus();
			status.setStatus("Approved");
			status.setStatusId(2);
			transfer.setStatus(status);
			
			transferDAO.insertTransfer(transfer);
			
			fromAccount.setBalance(fromBalance);
			transfer.setFrom(fromAccount);
			return transfer;
		}
				return new Transfer();
	}
}
