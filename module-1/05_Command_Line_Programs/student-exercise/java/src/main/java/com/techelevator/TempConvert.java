package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the temperature: ");
		int temperature = Integer.parseInt(scanner.nextLine());
		System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		String scale = scanner.nextLine();
		scanner.close();
		String convertedTemp = convertTemp(temperature, scale);
		System.out.println(temperature + scale + " is " + convertedTemp);
	}

	public static String convertTemp(int temperature, String scale) {
		if (scale.equals("C")) {
			return  ((temperature * 1.8) + 32) + "F";
		}else {
			return (int) ((temperature - 32)/1.8) + "C";
		}
	}
}
