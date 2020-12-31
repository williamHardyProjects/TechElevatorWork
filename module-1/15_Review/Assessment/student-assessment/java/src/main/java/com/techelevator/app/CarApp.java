package com.techelevator.app;

import java.util.List;

import com.techelevator.io.CarInput;
import com.techelevator.io.CarOutput;
import com.techelevator.model.Car;

public class CarApp {
	public static void run() {
		List<Car> carList = CarInput.readCSVToList("data-files/CarInput.csv");
		
		CarOutput.displayAllCars(carList);
		
		String divider = "**********************************************";
		CarOutput.displayCustomMessage(divider);
		
		int total = 0;
		for (Car car: carList) {
			total += car.getAge();
		}
		
		String message = "The age of all cars in the csv file is: " + total;
		CarOutput.displayCustomMessage(message);
	}
}
