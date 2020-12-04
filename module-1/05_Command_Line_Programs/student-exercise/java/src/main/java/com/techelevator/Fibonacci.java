package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the Fibonacci number: ");
		int number = Integer.parseInt(scanner.nextLine());
		scanner.close();
		int sum = 0;
		int prevNum = 0;
		int currentNum = 1;
		System.out.print(prevNum + " " + currentNum + " ");
		while (currentNum <= number) {
			sum = prevNum + currentNum;
			prevNum = currentNum;
			currentNum = sum;
			if (currentNum > number) {
				break;
			}else {
				System.out.print(currentNum + " ");
			}
			
		}
	}
	
	
	

}
