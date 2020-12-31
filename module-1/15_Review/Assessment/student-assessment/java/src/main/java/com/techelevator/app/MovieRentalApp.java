package com.techelevator.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.techelevator.io.MovieRentalInput;
import com.techelevator.io.MovieRentalOutput;
import com.techelevator.model.MovieRental;

public class MovieRentalApp {
	public static void run() {
		List<MovieRental> movieRentalList = MovieRentalInput.readCSVToList("data-files/MovieInput.csv");
		MovieRentalOutput.displayMovieRentalList(movieRentalList);
		
		System.out.println("---------------------------------------------");
		/*List<MovieRental> list = MovieRentalInput.makeMovieRentalList();
		
		for (MovieRental movieRental: list) {
			System.out.println(movieRental);
		}*/
		
		BigDecimal sumAllMovieRentals = new BigDecimal(0);
		
		for (MovieRental movieRental: movieRentalList) {
			sumAllMovieRentals = sumAllMovieRentals.add(new BigDecimal(movieRental.getRentalPrice()));
		}
		
		String message = "The sum of all movie rentals is: " + sumAllMovieRentals.setScale(2, RoundingMode.HALF_UP);
		MovieRentalOutput.displayCustomMessage(message);		
	}
}
