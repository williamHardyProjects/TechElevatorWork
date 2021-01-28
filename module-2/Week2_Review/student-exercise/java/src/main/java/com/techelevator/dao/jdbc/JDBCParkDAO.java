package com.techelevator.dao.jdbc;

import com.techelevator.dao.ParkDAO;
import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JDBCParkDAO implements ParkDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCParkDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Park> getAllParks() {
    	List<Park> parks = new ArrayList<Park>();
    	
    	String getParkSql = "SELECT park_id\r\n" + 
			    			"    , name\r\n" + 
			    			"    , location\r\n" + 
			    			"    , establish_date\r\n" + 
			    			"    , area\r\n" + 
			    			"    , visitors\r\n" + 
			    			"    , description\r\n" + 
			    			"FROM park;";
    	
    	SqlRowSet parkRows = jdbcTemplate.queryForRowSet(getParkSql);
    	
    	while(parkRows.next()) {
    		Park park = mapRowToPark(parkRows);
    		parks.add(park);
    	}
        return parks;
    }

    private Park mapRowToPark(SqlRowSet results) {
        Park park = new Park();
        park.setParkId(results.getInt("park_id"));
        park.setName(results.getString("name"));
        park.setLocation(results.getString("location"));
        park.setEstablishDate(results.getDate("establish_date").toLocalDate());
        park.setArea(results.getInt("area"));
        park.setVisitors(results.getInt("visitors"));
        park.setDescription(results.getString("description"));
        return park;
    }

}
