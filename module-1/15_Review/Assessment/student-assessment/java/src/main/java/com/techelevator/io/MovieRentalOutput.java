package com.techelevator.io;

import java.util.List;

import com.techelevator.model.MovieRental;

public class MovieRentalOutput {
	public static void displayMovieRentalList(List<MovieRental> list) {
		for (MovieRental movieRental: list) {
			System.out.println(movieRental);
		}
	}
	
	public static void displayCustomMessage(String message) {
		System.out.println(message);
	}

}
