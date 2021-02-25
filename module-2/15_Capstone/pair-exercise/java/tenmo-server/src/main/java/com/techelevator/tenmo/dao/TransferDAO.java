package com.techelevator.tenmo.dao;

import java.util.List;

import com.techelevator.tenmo.model.Transfer;

public interface TransferDAO {
	List<Transfer> getTransfers(Long userId);
	
	Transfer getTransfer(Long userId, Long transferId);
	
	void insertTransfer(Transfer transfer);
	
	List<Transfer> getPendingTransfers(Long userId);
}
