package com.techelevator.ui.screens;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.io.IOResources;
import com.techelevator.models.VendingItem;

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
		System.out.println();
		System.out.println("Inserting money...");
		System.out.println("______________________________________________________________");
		Scanner in = IOResources.getInput();
		BigDecimal moneyInserted = new BigDecimal(0);
		String money = null;
		
		do {
			System.out.println();
			System.out.println();
			System.out.println("Enter whole dollar amounts (ex. 1, 2, 5, 10) and press enter");
			System.out.println("Press enter without entering anything to exit");
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			System.out.println();
			
			money = in.nextLine();
			if (!money.isBlank()) {
				moneyInserted = moneyInserted.add(new BigDecimal(money));
			}
			
			System.out.println("************************************");
			System.out.println();
			System.out.println("The current money inserted is: " + moneyInserted);
			System.out.println();
			System.out.println("************************************");

		}while(!money.isBlank());
		System.out.println();
		System.out.println("Finished inserting money");
		System.out.println("______________________________________________________________");
		System.out.println();
		
		return moneyInserted;
	}
	
	public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
	}
	
	public static String getProductSelection(List<VendingItem> contents, Map<String, LinkedList<VendingItem>> stock) {
		System.out.println();
		System.out.println("Selecting product");
		System.out.println("______________________________________________________________");
		System.out.println();
		Scanner in = IOResources.getInput();
		UserOutput.displayVendingItems(contents, stock);
		System.out.println("Please enter the slot id of the item you would like to buy");
		System.out.println();
		String slotID;
		slotID = in.nextLine();
		System.out.println();
		
		if (!stock.containsKey(slotID)) {
			System.out.println("The product code: " + slotID + " does not exist");
			slotID = null;
			return slotID;
		}else if (stock.get(slotID).size() == 0) {
			System.out.println("SOLD OUT");
			
			slotID = null;
			return slotID;
		}
		
		System.out.println();
		System.out.println("finished selecting product");
		System.out.println("______________________________________________________________");
		System.out.println();
		
		return slotID;
	}
}
