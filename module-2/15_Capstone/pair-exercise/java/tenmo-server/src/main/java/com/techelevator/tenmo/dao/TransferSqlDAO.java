package com.techelevator.tenmo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferStatus;
import com.techelevator.tenmo.model.TransferType;
import com.techelevator.tenmo.model.User;

@Component
public class TransferSqlDAO implements TransferDAO {
	private JdbcTemplate jdbcTemplate;
	private Map<Integer, String> typeMap;
	private Map<Integer, String> statusMap;
	
			
	
	public TransferSqlDAO(JdbcTemplate jdbcTemplate, TransferStatusDAO statusDAO, TransferTypeDAO typeDAO) {
		this.jdbcTemplate = jdbcTemplate;
		this.typeMap = typeDAO.getTypeMap();
		this.statusMap = statusDAO.getStatusMap();
	}
	@Override
	public List<Transfer> getTransfers(Long userId) {
		List<Transfer> transfers = new ArrayList<Transfer>();
		String sqlFrom = "SELECT u.user_id\r\n" + 
						"    , u.username\r\n" + 
						"    , t.transfer_id\r\n" + 
						"    , t.amount\r\n" + 
						"    , t.account_from\r\n" + 
						"    , t.account_to\r\n" + 
						"FROM transfers AS t\r\n" + 
						"INNER JOIN users AS u\r\n" + 
						"    ON t.account_to = u.user_id\r\n" + 
						"WHERE t.account_from = ?;";
		
		String sqlTo = "SELECT u.user_id\r\n" + 
						"    , u.username\r\n" + 
						"    , t.transfer_id\r\n" + 
						"    , t.amount\r\n" + 
						"    , t.account_from\r\n" + 
						"    , t.account_to\r\n" + 
						"FROM transfers AS t\r\n" + 
						"INNER JOIN users AS u\r\n" + 
						"    ON t.account_from = u.user_id\r\n" + 
						"WHERE t.account_to = ?;";
		
		SqlRowSet rowsFrom = jdbcTemplate.queryForRowSet(sqlFrom, userId);
		
		while (rowsFrom.next()) {
			Transfer transfer = mapRowToTransfer(rowsFrom, userId);
			transfers.add(transfer);
		}
		
		SqlRowSet rowsTo = jdbcTemplate.queryForRowSet(sqlTo, userId);
		
		while (rowsTo.next()) {
			Transfer transfer = mapRowToTransfer(rowsTo, userId);
			transfers.add(transfer);
		}
		return transfers;
	}
	
	@Override
	public Transfer getTransfer(Long userId, Long transferId) {
		Transfer transfer = null;
		String sql = "SELECT t.transfer_id\r\n" + 
						"    , u.username\r\n" + 
						"    , t.transfer_type_id\r\n" + 
						"    , t.transfer_status_id\r\n" + 
						"    , t.amount\r\n" +
						"    , t.account_from\r\n" + 
						"    , t.account_to\r\n" +
						"    , u.user_id\r\n" +
						"FROM transfers AS t\r\n" + 
						"INNER JOIN users u\r\n" + 
						"    ON t.account_from = u.user_id\r\n" + 
						"    OR t.account_to = u.user_id\r\n" + 
						"WHERE t.transfer_id = ?\r\n" + 
						"    AND u.user_id != ?;";
		
		
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, transferId, userId);
		if (row.next()) {
			transfer = mapRowToTransfer(row, userId);
			transfer = mapTypeStatus(row, transfer);
		}
		return transfer;
	}
	
	public void insertTransfer(Transfer transfer) {
		String sql = "INSERT INTO transfers\r\n" + 
					"(\r\n" + 
					"    transfer_type_id\r\n" + 
					"    , transfer_status_id\r\n" + 
					"    , account_from\r\n" + 
					"    , account_to\r\n" + 
					"    , amount\r\n" + 
					")\r\n" + 
					"VALUES\r\n" + 
					"(\r\n" + 
					"    ?\r\n" + 
					"    , ?\r\n" + 
					"    , ?\r\n" + 
					"    , ?\r\n" + 
					"    , ?\r\n" + 
					");";
		
		jdbcTemplate.update(sql, transfer.getType().getTypeId()
								, transfer.getStatus().getStatusId()
								, transfer.getFrom().getId()
								, transfer.getTo().getId()
								, transfer.getAmount());
				
	}
	

	
	private Transfer mapRowToTransfer(SqlRowSet rs, Long userId) {
        User userFrom = new User();
        User userTo = new User();
        Account accountFrom = new Account();
        Account accountTo = new Account();
        Transfer transfer = new Transfer();
        
        transfer.setId(rs.getLong("transfer_id"));
        
        Long fromId = rs.getLong("account_from");
 
        if (fromId == userId) {
        	accountFrom.setId(userId);
        	
        	Long idTo = rs.getLong("user_id");
        	userTo.setId(idTo);
        	userTo.setUsername(rs.getString("username"));
        	
        	accountTo.setId(idTo);
        	accountTo.setUser(userTo);
        	
        	transfer.setTo(accountTo);
        	transfer.setFrom(accountFrom);
        	transfer.setAmount(rs.getBigDecimal("amount"));
        }else {
        	accountTo.setId(userId);
        	
        	Long idFrom = rs.getLong("user_id");
        	userFrom.setId(idFrom);
        	userFrom.setUsername(rs.getString("username"));
        	
        	accountFrom.setId(idFrom);
        	accountFrom.setUser(userFrom);
       
        	        	
        	transfer.setFrom(accountFrom);
        	transfer.setTo(accountTo);
        	transfer.setAmount(rs.getBigDecimal("amount"));
        }
        return transfer;
    }
	
	private Transfer mapTypeStatus(SqlRowSet rs, Transfer transfer) {
		TransferType type = new TransferType();
    	TransferStatus status = new TransferStatus();
    	type.setTypeId(rs.getInt("transfer_type_id"));
    	type.setType(typeMap.get(type.getTypeId()));
    	transfer.setType(type);
    	status.setStatusId(rs.getInt("transfer_status_id"));
    	status.setStatus(statusMap.get(status.getStatusId()));
    	transfer.setStatus(status);
    	return transfer;
	}
	@Override
	public List<Transfer> getPendingTransfers(Long userId) {
		List<Transfer> transfers = new ArrayList<Transfer>();
		Transfer transfer = null;
		String sql = "SELECT u.user_id \r\n" + 
					"    , u.username \r\n" + 
					"    , t.transfer_id\r\n" + 
					"    , t.amount\r\n" + 
					"    , t.account_from\r\n" + 
					"    , t.account_to\r\n" + 
					"FROM transfers AS t\r\n" + 
					"INNER JOIN users AS u\r\n" + 
					"    ON t.account_to = u.user_id\r\n" + 
					"    OR t.account_from = u.user_id\r\n" + 
					"INNER JOIN transfer_statuses AS ts\r\n" + 
					"    ON t.transfer_status_id = ts.transfer_status_id\r\n" + 
					"WHERE u.user_id = ?\r\n" + 
					"    AND ts.transfer_status_desc = 'Pending';";
		
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userId);
		while (row.next()) {
			transfer = mapRowToTransfer(row, userId);
			transfers.add(transfer);
		}
		
		return transfers;
	}

}
