package com.techelevator.dao.jdbc;

import com.techelevator.dao.ReservationDAO;
import com.techelevator.model.Reservation;
import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCReservationDAO implements ReservationDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCReservationDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public List<Reservation> getUpcomingReservation(int parkID) {
    	List<Reservation> reservations = new ArrayList<Reservation>();
    	String upcomingReservationsSql = "SELECT r.reservation_id\r\n" + 
						    			"    , r.site_id\r\n" + 
						    			"    , r.name\r\n" + 
						    			"    , r.from_date\r\n" + 
						    			"    , r.to_date\r\n" + 
						    			"    , r.create_date\r\n" + 
						    			"FROM reservation AS r\r\n" + 
						    			"INNER JOIN site AS s\r\n" + 
						    			"    ON r.site_id = s.site_id\r\n" + 
						    			"INNER JOIN campground AS c\r\n" + 
						    			"    ON s.campground_id = c.campground_id\r\n" + 
						    			"INNER JOIN park AS p\r\n" + 
						    			"    ON c.park_id = p.park_id\r\n" + 
						    			"WHERE r.from_date BETWEEN current_date AND current_date + 30\r\n" + 
						    			"    AND p.park_id = ?;";
    	
    	SqlRowSet reservationRows = jdbcTemplate.queryForRowSet(upcomingReservationsSql, parkID);
    	
    	while(reservationRows.next()) {
    		Reservation reservation = mapRowToReservation(reservationRows);
    		reservations.add(reservation);
    	}
    	
    	return reservations;
    }

    @Override
    public int createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate) {
    	int id;
    	try {
    		id = getNextReservationId();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		e.printStackTrace();
    		return Integer.MIN_VALUE;
    	}
    	
        String makeReservationSql = "INSERT INTO reservation\r\n" + 
					        		"(\r\n" + 
					        		"    reservation_id\r\n" + 
					        		"    , site_id\r\n" + 
					        		"    , name\r\n" + 
					        		"    , from_date\r\n" + 
					        		"    , to_date\r\n" + 
					        		")\r\n" + 
					        		"VALUES\r\n" + 
					        		"(\r\n" + 
					        		"    ?\r\n" + 
					        		"    , ?\r\n" + 
					        		"    , ?\r\n" + 
					        		"    , ?\r\n" + 
					        		"    , ?\r\n" + 
					        		");";
        jdbcTemplate.update(makeReservationSql, id, siteId, name, fromDate.toString(), toDate.toString());
        
        return id;
    }

    private Reservation mapRowToReservation(SqlRowSet results) {
        Reservation r = new Reservation();
        r.setReservationId(results.getInt("reservation_id"));
        r.setSiteId(results.getInt("site_id"));
        r.setName(results.getString("name"));
        r.setFromDate(results.getDate("from_date").toLocalDate());
        r.setToDate(results.getDate("to_date").toLocalDate());
        r.setCreateDate(results.getDate("create_date").toLocalDate());
        return r;
    }
    
    private int getNextReservationId() throws Exception{
    	String getnextValSql = "SELECT nextval('reservation_reservation_id_seq');";
    	int nextVal;
    	SqlRowSet nextValRow = jdbcTemplate.queryForRowSet(getnextValSql);
    	
    	if (nextValRow.next()) {
    		nextVal = nextValRow.getInt(1);
    	}else {
    		throw new Exception("could not retrieve next reservation id");
    	}
    	
    	return nextVal;
    }
}
