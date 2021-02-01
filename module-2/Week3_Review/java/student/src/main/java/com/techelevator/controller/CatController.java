package com.techelevator.controller;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardDAO;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "/api/cards")
public class CatController {

    private CatCardDAO catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDAO catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }
    
    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public CatCard getRandomCatCard() {
    	CatFact catFact = catFactService.getFact();
    	CatPic catPic = catPicService.getPic();
    	CatCard randomCard = new CatCard();
    	
    	if (catFact == null || catPic == null) {
    		return randomCard;
    	}
    	randomCard.setCatFact(catFact.getText());
    	randomCard.setImgUrl(catPic.getFile());
    	    	
    	return randomCard;
    	
    }
    
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CatCard> getCatCards() {
    	List<CatCard> catCards = null;
    	
    	catCards = catCardDao.list();
    	return catCards;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public CatCard saveCatCard(@Valid @RequestBody CatCard catCardToAdd) {
    	boolean success = false;
    	CatCard emptyCatCard = new CatCard();
    	
    	success = catCardDao.save(catCardToAdd);
    	if (success) {
    		return catCardToAdd;
    	}
    	return emptyCatCard;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CatCard getCatCard(@PathVariable long id) throws CatCardNotFoundException {
    	CatCard catCard = null;
    	catCard = catCardDao.get(id);
    	return catCard;
    }
    
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void changeCatCard(@Valid @RequestBody CatCard catCardToChange, @PathVariable int id) throws CatCardNotFoundException {
    	boolean success = catCardDao.update(id, catCardToChange);
    	if (!success) {
    		throw new CatCardNotFoundException();
    	}
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void removeCatCard(@PathVariable long id) throws CatCardNotFoundException {
    	boolean success = catCardDao.delete(id);
    	if (!success) {
    		throw new CatCardNotFoundException();
    	}
    }
}
