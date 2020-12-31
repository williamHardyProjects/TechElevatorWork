package com.techelevator.io;

import java.util.List;

import com.techelevator.model.Car;

public class CarOutput {
	private CarOutput() {
		super();
	}
	public static void displayAllCars(List<Car> carList) {
		for (Car car: carList) {
			System.out.println(car);
		}
	}
	
	public static void displayCustomMessage(String message) {	
		System.out.println(message);
	}
}
