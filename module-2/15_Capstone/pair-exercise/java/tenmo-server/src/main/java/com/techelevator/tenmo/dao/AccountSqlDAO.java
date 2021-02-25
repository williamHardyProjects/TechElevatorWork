package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;

@Component
public class AccountSqlDAO implements AccountDAO {
	private JdbcTemplate jdbcTemplate;

	public AccountSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public Account getAccount(Long id) {
		Account account = null;
		String sql = "SELECT u.user_id\r\n" + 
					"    , u.username\r\n" + 
					"    , a.account_id\r\n" + 
					"    , a.balance\r\n" + 
					"FROM users AS u\r\n" + 
					"INNER JOIN accounts AS a\r\n" + 
					"    ON u.user_id = a.user_id\r\n" + 
					"WHERE a.account_id = ?;";
		
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, id);
		if (row.next()) {
			account = mapRowToAccount(row); 
		}
		return account;
	}
	
	@Override
	public void updateBalance(BigDecimal balance, Long userId) {
		String sql = "UPDATE accounts\r\n" + 
				"SET balance = ?\r\n" + 
				"WHERE user_id = ?;";
		jdbcTemplate.update(sql, balance, userId);
	}
	
	private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account();
        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setUsername(rs.getString("username"));
        account.setId(rs.getLong("account_id"));
        account.setUser(user);
        account.setBalance(rs.getBigDecimal("balance"));
        
        return account;
    }

}
