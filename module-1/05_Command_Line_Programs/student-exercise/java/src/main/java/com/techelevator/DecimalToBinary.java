package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter in a series of decimal values (separated by spaces): ");
		String[] numbers = scanner.nextLine().split(" ");
		scanner.close();
		for (int i = 0; i < numbers.length; i++) {
			String convertedNum = decimalToBinary(numbers[i]);
			System.out.println(numbers[i] + " in binary is " + convertedNum);
		}
	}
	
	public static String decimalToBinary(String decimal) {
		int decimalNum = Integer.parseInt(decimal);
		String digitStr = "";
		int nextDigit;
		while (decimalNum >= 1) {
			nextDigit = decimalNum % 2;
			digitStr = Integer.toString(nextDigit) + digitStr;
			decimalNum /= 2;
		}
		return digitStr;
	}

}
