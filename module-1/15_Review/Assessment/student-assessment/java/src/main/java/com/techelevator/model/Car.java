package com.techelevator.model;

import java.time.LocalDate;

public class Car implements ECheckable {
	private int year;
	private String make;
	private boolean isClassicCar;

	public Car(int year, String make, boolean isClassicCar) {
		super();
		this.year = year;
		this.make = make;
		this.isClassicCar = isClassicCar;
	}
	public int getAge() {
		return LocalDate.now().getYear() - year;
	}
	
	@Override
	public boolean eCheck(int yearToCheck) {
		int age = getAge();
		boolean bothEvenOrOdd = (yearToCheck % 2 ) == (year % 2);
		boolean under4OrOver25 = (age < 4) || (age > 25);
		if (under4OrOver25 || isClassicCar) {
			return false;
		}
		return bothEvenOrOdd;
	}
	@Override
	public String toString() {
		return "CAR - " + year + " - " + make;
	}
}
