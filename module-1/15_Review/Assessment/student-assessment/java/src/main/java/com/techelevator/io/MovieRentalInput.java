package com.techelevator.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.techelevator.model.MovieRental;

public class MovieRentalInput {
	public static List<MovieRental> readCSVToList(String fileName) {
		List<MovieRental> list = new LinkedList<MovieRental>();
		
		String movieRentalRow;
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((movieRentalRow = br.readLine()) != null) {
				String[] movieRowArray = movieRentalRow.split(",");
				String title = movieRowArray[0];
				String format = movieRowArray[1];
				boolean isPremiumMovie = Boolean.parseBoolean(movieRowArray[2]);
				
				MovieRental movieRental = new MovieRental(title, format, isPremiumMovie);
				
				list.add(movieRental);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<MovieRental> makeMovieRentalList() {
		System.out.println("Welcome, Please follow instructions to add movie to the movie rental list");
		System.out.println("----------------------------------------------------------------------------");
		List<MovieRental> movieRentalList = new LinkedList<MovieRental>();
			Scanner in = new Scanner(System.in);
			while (true) {
				System.out.println("Enter a movie title ex - \" The Color Purple \"");
				String title = in.nextLine();
				
				System.out.println("Enter a movie format ex - vhs, dvd, blu-ray");
				String format = movieFormatChecker(in.nextLine());
				
				System.out.println("is the movie premium, enter yes or no :");
				boolean isMoviePremium = isMoviePremiumChecker(in.nextLine());
				
				movieRentalList.add(new MovieRental(title, format, isMoviePremium));
				
				System.out.println("Enter e to [E]xit or c to [C]ontinue");
				if (cancel(in, in.nextLine())) {
					break;
				}
			}
		return movieRentalList;
	}
	public static boolean exitChecker(String input) {
		Pattern regex = Pattern.compile("[e]", Pattern.CASE_INSENSITIVE);
		Matcher match = regex.matcher(input);
		boolean test = match.matches(); 
		return test;
	}
	public static boolean cancel(Scanner scan, String input) {
		if (exitChecker(input)) {
			System.out.println();
			scan.close();
			System.out.println("Movie rental exited!");
			System.out.println();
			return true;
		}
		return false;
	}
	public static boolean isMoviePremiumChecker(String premium) {
		boolean status = false;
		if (premium.trim().toLowerCase().equals("yes")) {
			status = true;
		}
		return status;
	}
	public static String movieFormatChecker(String format) {
		String movieFormat = format.toLowerCase().trim();
		switch(movieFormat) {
			case "vhs":
				return "VHS";
			case "dvd":
				return "DVD";
			case "blu-ray":
				return "Blu-ray";
			default:
				return "";
		}
	}
}
