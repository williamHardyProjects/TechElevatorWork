package com.techelevator;


import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the length: ");
		int length = Integer.parseInt(scanner.nextLine());
		System.out.println("Is the measurement in (m)eter, or (f)eet? ");
		String scale = scanner.nextLine();
		scanner.close();
		String convertedLength = convertLength(length, scale);
		System.out.println(length + scale + " is " + convertedLength);
	}

	public static String convertLength(int length, String scale) {
		if (scale.equals("m")) {
			return  (int) (length * 3.2808399) + "f";
		}else {
			return  (int) (length * 0.3048) + "m";
		}
	}

}
