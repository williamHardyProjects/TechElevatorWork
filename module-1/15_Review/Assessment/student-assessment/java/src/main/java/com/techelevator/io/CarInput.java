package com.techelevator.io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.techelevator.model.Car;

public class CarInput {
	private CarInput() {
		super();
	}
	
	public static List<Car> readCSVToList(String fileName) {
		List<Car> carList = new ArrayList<Car>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			
			String line;
			
			while ((line = br.readLine()) != null) {
				
				String[] carValues = line.split(",");
				int year = Integer.parseInt(carValues[0]);
				String make = carValues[1];
				boolean isClassicCar = Boolean.parseBoolean(carValues[2]);
				
				carList.add(new Car(year, make, isClassicCar));
				
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return carList;
	}

}
