package com.techelevator.dao.jdbc;

import com.techelevator.dao.SiteDAO;
import com.techelevator.model.Site;
import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCSiteDAO implements SiteDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCSiteDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public List<Site> getCurrentAvailableSites(int parkID) {
    	List<Site> sites = new ArrayList<Site>();
    	String availableSitesSql = "SELECT s.site_id\r\n" + 
					    			"    , s.campground_id\r\n" + 
					    			"    , s.site_number\r\n" + 
					    			"    , s.max_occupancy\r\n" + 
					    			"    , s.accessible\r\n" + 
					    			"    , s.max_rv_length\r\n" + 
					    			"    , s.utilities\r\n" + 
					    			"FROM site AS s\r\n" + 
					    			"LEFT JOIN reservation AS r\r\n" + 
					    			"    ON s.site_id = r.site_id\r\n" + 
					    			"LEFT JOIN campground AS c\r\n" + 
					    			"    ON s.campground_id = c.campground_id\r\n" + 
					    			"LEFT JOIN park AS p\r\n" + 
					    			"    ON c.park_id = p.park_id\r\n" + 
					    			"WHERE r.reservation_id IS NULL\r\n" + 
					    			"    AND p.park_id = 3;";
    	
    	SqlRowSet siteRows = jdbcTemplate.queryForRowSet(availableSitesSql, parkID);
    	
    	while(siteRows.next()) {
    		Site site = mapRowToSite(siteRows);
    		sites.add(site);
    	}
    	
    	return sites;
    }

    @Override
    public List<Site> getSitesThatAllowRVs(int parkId) {
    	List<Site> sites = new ArrayList<Site>();
    	String getSiteSql = "SELECT s.site_id\r\n" + 
			    			"    , s.campground_id\r\n" + 
			    			"    , s.site_number\r\n" + 
			    			"    , s.max_occupancy\r\n" + 
			    			"    , s.accessible\r\n" + 
			    			"    , s.max_rv_length\r\n" + 
			    			"    , s.utilities\r\n" + 
			    			"FROM site AS s\r\n" + 
			    			"INNER JOIN campground AS c\r\n" + 
			    			"    ON s.campground_id = c.campground_id\r\n" + 
			    			"INNER JOIN park AS p\r\n" + 
			    			"    ON c.park_id = p.park_id\r\n" + 
			    			"WHERE p.park_id = ?\r\n" + 
			    			"    AND s.max_rv_length > 0;\r\n" + 
			    			"";
    	
    	SqlRowSet siteRows = jdbcTemplate.queryForRowSet(getSiteSql, parkId);
    	
    	while (siteRows.next()) {
    		Site site = mapRowToSite(siteRows);
    		sites.add(site);
    	}
        return sites;
    }

    private Site mapRowToSite(SqlRowSet results) {
        Site site = new Site();
        site.setSiteId(results.getInt("site_id"));
        site.setCampgroundId(results.getInt("campground_id"));
        site.setSiteNumber(results.getInt("site_number"));
        site.setMaxOccupancy(results.getInt("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getInt("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        return site;
    }
}
