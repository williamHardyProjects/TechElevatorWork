package com.techelevator.tenmo.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class TransferTypeSqlDAO implements TransferTypeDAO {
	private JdbcTemplate jdbcTemplate;
	
	public TransferTypeSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Map<Integer, String> getTypeMap() {
		Map<Integer, String> typeMap = new HashMap<Integer, String>();
		String sql = "SELECT transfer_type_id\r\n" + 
					"    , transfer_type_desc\r\n" + 
					"FROM transfer_types;";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		
		while(rows.next()) {
			typeMap.put(rows.getInt("transfer_type_id"), rows.getString("transfer_type_desc"));
		}
		
		return typeMap;
	}
}
