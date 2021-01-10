package com.techelevator.ui.screens;

import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.io.IOResources;

public class UserInput {
	private UserInput() {}
	
	public static String getMainMenuSelection() {
		Screen.getMainScreen();
		
		String input;
		Scanner in = IOResources.getInput();
		input = in.nextLine();
		
		return input;
	}
	
	public static String getPurchaseMenuSelection() {
		Screen.getPurchaseScreen();
		
		String input;
		Scanner in = IOResources.getInput();
		input = in.nextLine();
		
		return input;
	}
	
	public static BigDecimal getMoney() {
		Scanner in = IOResources.getInput();
		BigDecimal moneyInserted = new BigDecimal(0);
		String money = null;
		
		do {
			System.out.println();
			System.out.println();
			System.out.println("Enter whole dollar amounts (ex. 1, 2, 5, 10) and press enter");
			System.out.println("Press enter without entering anything to exit");
			System.out.println();
			System.out.println();
			
			money = in.nextLine();
			if (!money.isBlank()) {
				moneyInserted = moneyInserted.add(new BigDecimal(money));
			}
			
			System.out.println();
			System.out.println("The current money inserted is: " + moneyInserted);
			System.out.println();

		}while(!money.isBlank());
		
		return moneyInserted;
	}
	
	public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
	}
}
