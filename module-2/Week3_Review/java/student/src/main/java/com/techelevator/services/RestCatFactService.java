package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatFact;

@Component
public class RestCatFactService implements CatFactService {
	public static final String catFactUrl = "https://cat-fact.herokuapp.com/facts/random";
	public RestTemplate fetch = new RestTemplate();
	

	@Override
	public CatFact getFact() {
		CatFact catFact = null;
		try {
			catFact = fetch.getForObject(catFactUrl, CatFact.class);
			return catFact;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return catFact;
	}

}
