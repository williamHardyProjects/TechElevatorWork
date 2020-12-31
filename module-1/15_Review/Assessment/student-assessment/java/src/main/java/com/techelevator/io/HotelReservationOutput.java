package com.techelevator.io;

import java.util.List;

import com.techelevator.model.HotelReservation;

public class HotelReservationOutput {
	public static void displayAllHotelReservations(List<HotelReservation> list) {
		for (HotelReservation reservation: list) {
			System.out.println(reservation);
		}
	}
	
	public static void displayCustomMessage(String message) {
		System.out.println(message);
	}
}
