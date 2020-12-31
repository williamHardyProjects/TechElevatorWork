package com.techelevator.model;

import java.math.BigDecimal;

public class MovieRental implements Billable {
	private String title;
	private String format;
	private boolean isPremiumMovie;
	

	public MovieRental(String title, String format, boolean isPremiumMovie) {
		super();
		this.title = title;
		this.format = format;
		this.isPremiumMovie = isPremiumMovie;
	}
	
	public double getRentalPrice() {
		BigDecimal rentalPrice = new BigDecimal(0),
				premiumFee = new BigDecimal(1),
				VHSFee = new BigDecimal(0.99),
				DVDFee = new BigDecimal(1.99),
				BluRayFee = new BigDecimal(2.99);
		
		if (isPremiumMovie) {
			rentalPrice = rentalPrice.add(premiumFee);
		}
		switch (format) {
			case "DVD":
				rentalPrice = rentalPrice.add(DVDFee);
				break;
			case "VHS":
				rentalPrice = rentalPrice.add(VHSFee);
				break;
			case "Blu-ray":
				rentalPrice = rentalPrice.add(BluRayFee);
				break;
		}
		
		return rentalPrice.doubleValue();
	}
	
	@Override
	public double getLatePenalty(int daysLate) {
		BigDecimal fee = new BigDecimal(0);
		if (daysLate == 1) {
			fee = new BigDecimal(1.99);
		}if (daysLate == 2) {
			fee = new BigDecimal(3.99);
		}
		if (daysLate >= 3) {
			fee = new BigDecimal(19.99);
		}
		return fee.doubleValue();
	}
	@Override
	public String toString() {
		return  "MOVIE - " + title + " - " + format + " " + getRentalPrice();
	}	
}
