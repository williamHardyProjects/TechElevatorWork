package com.techelevator.model;

import java.math.BigDecimal;

public class HotelReservation implements UpChargeable {
	String name;
	int numberOfNights;
	

	public HotelReservation(String name, int numberOfNights) {
		super();
		this.name = name;
		this.numberOfNights = numberOfNights;
	}
	
	public double getEstimatedTotal() {
		BigDecimal dailyRate = new BigDecimal(59.99);
		double estimatedTotal = dailyRate.multiply(new BigDecimal(numberOfNights)).doubleValue();
		
		return estimatedTotal;
	}

	@Override
	public double actualTotal(boolean requiresCleaning, boolean usedMinibar) {
		BigDecimal total = new BigDecimal(getEstimatedTotal()),
				cleaningFee = new BigDecimal(34.99),
				miniBarFee = new BigDecimal(12.99);
		
		if (usedMinibar) {
			total = total.add(miniBarFee);
			if (requiresCleaning) {
				cleaningFee = new BigDecimal(2).multiply(cleaningFee);
				total = total.add(cleaningFee);
			}
			
		}else {
			if (requiresCleaning) {
				total = total.add(cleaningFee);
			}
		}
		
		return total.doubleValue();
	}

	@Override
	public String toString() {
		return "RESERVATION - " + name + " - " + getEstimatedTotal();
	}
}
