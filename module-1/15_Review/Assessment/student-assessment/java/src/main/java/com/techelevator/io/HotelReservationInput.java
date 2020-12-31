package com.techelevator.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.techelevator.model.HotelReservation;

public class HotelReservationInput {
	public static List<HotelReservation> readCSVToList(String fileName) {
		List<HotelReservation> list = new LinkedList<HotelReservation>();
		String hotelReservationRow;
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((hotelReservationRow = br.readLine()) != null) {
				String[] hotelResRowArray = hotelReservationRow.split(",");
				String name = hotelResRowArray[0];
				int numberOfNights = Integer.parseInt(hotelResRowArray[1].trim());
				
				HotelReservation hotelReservation = new HotelReservation(name, numberOfNights);
				list.add(hotelReservation);
						
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
