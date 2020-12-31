package com.techelevator.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.techelevator.io.HotelReservationInput;
import com.techelevator.io.HotelReservationOutput;
import com.techelevator.model.HotelReservation;

public class HotelReservationApp {
	public static void run() {
		List<HotelReservation> list = HotelReservationInput.readCSVToList("data-files/HotelInput.csv");
		
		HotelReservationOutput.displayAllHotelReservations(list);
		
		System.out.println("------------------------------------------------------------");
		
		BigDecimal total = new BigDecimal(0);
		
		for (HotelReservation reservation: list) {
			BigDecimal estimate = new BigDecimal(reservation.getEstimatedTotal());
			total = total.add(estimate);
		}
		
		String message = "The estimated total for all reservations in the list is: " + total.setScale(2, RoundingMode.HALF_UP);
		
		HotelReservationOutput.displayCustomMessage(message);
		
	}
}
