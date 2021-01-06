package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {
		
		System.out.println("Please enter a file to write to");
		Scanner input = new Scanner(System.in);
		String fileName = input.nextLine();
		File filePath = new File(fileName);
		input.close();
		
		try (PrintStream outFile = new PrintStream(filePath)) {
			for (int i = 0; i <= 300; i++) {
				String fizzBuzz = getFizzy(i);
				if (fizzBuzz.length() == 0) {
					outFile.println(i);
				}else {
					outFile.println(fizzBuzz);
				}
				
			}
			System.out.println(filePath.getName() + " has been created.");
		} catch (FileNotFoundException e) {
	
			e.printStackTrace();
		}
		
		
	}
	public static String getFizzy(Integer number) {
		String fizzBuzz = "";

		if (number % 3 == 0 || number.toString().contains("3")) {
			fizzBuzz += "Fizz";
		}
		if (number % 5 == 0 || number.toString().contains("5")) {
			fizzBuzz += "Buzz";
		}
		return fizzBuzz;
	}

}
