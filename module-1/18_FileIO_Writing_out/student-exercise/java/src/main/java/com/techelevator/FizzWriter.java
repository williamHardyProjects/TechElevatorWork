package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class FizzWriter {

	public static void main(String[] args) {
		
		String fileName = "FizzBuzz.txt";
		File filePath = new File(fileName);
		if (!filePath.exists()) {
			try {
				filePath.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try (PrintStream outFile = new PrintStream(filePath)) {
			for (int i = 1; i <= 300; i++) {
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
