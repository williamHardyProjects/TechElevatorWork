package com.techelevator.tenmo.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class TransferStatusSqlDAO implements TransferStatusDAO {
	private JdbcTemplate jdbcTemplate;
	
	public TransferStatusSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public Map<Integer, String> getStatusMap() {
		Map<Integer, String> statusMap = new HashMap<Integer, String>();
		String sql = "SELECT transfer_status_id\r\n" + 
					"    , transfer_status_desc\r\n" + 
					"FROM transfer_statuses;";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		
		while (rows.next()) {
			statusMap.put(rows.getInt("transfer_status_id"), rows.getString("transfer_status_desc"));
		}
		
		return statusMap;
	}

}
