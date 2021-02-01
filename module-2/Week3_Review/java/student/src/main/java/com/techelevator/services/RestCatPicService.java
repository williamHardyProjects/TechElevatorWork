package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatPic;

@Component
public class RestCatPicService implements CatPicService {
		public static final String catPicUrl = "https://random-cat-image.herokuapp.com/";
		public RestTemplate fetch = new RestTemplate();
	@Override
	public CatPic getPic() {
		CatPic catPic = null;
		
		try {
			catPic = fetch.getForObject(catPicUrl, CatPic.class);
			return catPic;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return catPic;
	}
}	
