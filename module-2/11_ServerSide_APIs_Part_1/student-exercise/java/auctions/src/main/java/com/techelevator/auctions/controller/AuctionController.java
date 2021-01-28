package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
public class AuctionController {

    private AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }
    
    @RequestMapping(path = "/auctions", method = RequestMethod.GET )
    public List<Auction> list(@RequestParam(required = false) String title_like, @RequestParam(required = false) Double currentBid_lte) {
    	List<Auction> auctions = null;
    	try {
    		if (title_like == null && currentBid_lte == null) {
    			auctions = dao.list();
    		}else if (title_like != null && currentBid_lte == null){
    			auctions = dao.searchByTitle(title_like);
    		}else if (title_like == null && currentBid_lte != null) {
    			auctions = dao.searchByPrice(currentBid_lte);
    		}else if (title_like != null && currentBid_lte != null) {
    			auctions = dao.searchByTitleAndPrice(title_like, currentBid_lte);
    		}else {
    			throw new Exception("Query cannot be handled");
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return auctions;
    }
    @RequestMapping(path = "/auctions/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
    	Auction auction = null;
    	
    	try {
    		auction = dao.get(id);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return auction;
    }
    
    @RequestMapping(path = "/auctions", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auctionToAdd) {
    	Auction auction = null;
    	try {
    		auction = dao.create(auctionToAdd);
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	return auction;
    }

}
