package com.techelevator.dao.jdbc;

import com.techelevator.dao.CampgroundDAO;
import com.techelevator.model.Campground;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JDBCCampgroundDAO implements CampgroundDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCCampgroundDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Campground> getCampgroundsByParkId(int parkId) {
    	List<Campground> campgrounds = new ArrayList<Campground>();
        String getCampgroundSql = "SELECT c.campground_id\r\n" + 
					        		"    , c.park_id\r\n" + 
					        		"    , c.name\r\n" + 
					        		"    , c.open_from_mm\r\n" + 
					        		"    , c.open_to_mm\r\n" + 
					        		"    , c.daily_fee\r\n" + 
					        		"FROM park AS p\r\n" + 
					        		"INNER JOIN campground AS c\r\n" + 
					        		"    ON p.park_id = c.park_id\r\n" + 
					        		"WHERE p.park_id = ?;";
        
        SqlRowSet campgroundRows = jdbcTemplate.queryForRowSet(getCampgroundSql, parkId);
        
        while (campgroundRows.next()) {
        	Campground campground = mapRowToCampground(campgroundRows);
        	campgrounds.add(campground);
        }
        
        return campgrounds;
        
    }

    private Campground mapRowToCampground(SqlRowSet results) {
        Campground camp = new Campground();
        camp.setCampgroundId(results.getInt("campground_id"));
        camp.setParkId(results.getInt("park_id"));
        camp.setName(results.getString("name"));
        camp.setOpenFromMonth(results.getInt("open_from_mm"));
        camp.setOpenToMonth(results.getInt("open_to_mm"));
        camp.setDailyFee(results.getDouble("daily_fee"));
        return camp;
    }
}
