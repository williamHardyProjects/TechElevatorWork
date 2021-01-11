package com.techelevator.application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import com.sun.tools.javac.util.List;
import com.techelevator.io.IOResources;
import com.techelevator.models.Logger;
import com.techelevator.models.OptionCodes;
import com.techelevator.models.VendingInventory;
import com.techelevator.models.VendingItem;
import com.techelevator.models.VendingLoader;
import com.techelevator.models.exceptions.CardDeclinedException;
import com.techelevator.ui.screens.UserInput;
import com.techelevator.ui.screens.UserOutput;

public class VendingMachine 
{
	VendingInventory vendingInventory = new VendingInventory("vendingmachine.csv", VendingLoader.getVendingLoader());
	BigDecimal balance = new BigDecimal(0);
	Logger logger = new Logger("../../../../../");

	
    public void run()
    {
        while(true)
        {
            String choice = UserInput.getMainMenuSelection();
          
            if(choice.equals(OptionCodes.DISPLAY))
            {
                UserOutput.displayVendingItems(vendingInventory.getContents(), vendingInventory.getStock());
            }
            else if(choice.equals(OptionCodes.PURCHASE))
            {
            	try {
            		vend();
            	}catch(CardDeclinedException e) {
            		System.out.println(e.getMessage());
            	}
                
            }
            else if(choice.equals(OptionCodes.EXIT))
            {   
            	IOResources.closeResources();
                break;
            }
        }
    }
    
    public void vend() throws CardDeclinedException {
    	while(true) {
    		System.out.println();
    		System.out.println("Your current balance is: " + balance);
    		System.out.println();
    		String choice = UserInput.getPurchaseMenuSelection();
    		
    		if(choice.equals(OptionCodes.FEED_MONEY)) {
    			
    			BigDecimal moneyInserted = UserInput.getMoney();
    			BigDecimal prevBalance = balance;
    			balance = balance.add(moneyInserted);
    			logger.logMessage("FEED MONEY: $" + prevBalance + " $" + balance);		
    		}else if(choice.equals(OptionCodes.SELECT_PRODUCT)) {
    			BigDecimal prevBalance = balance;
    			String slotID = UserInput.getProductSelection(vendingInventory.getContents(), vendingInventory.getStock());
    			if (slotID == null) {
    				continue;
    			}
    			VendingItem item = vendingInventory.inspectItem(slotID);
    			BigDecimal change = balance.subtract(item.getPrice());
    			
    			if (change.compareTo(BigDecimal.ZERO) < 0) {
    				throw new CardDeclinedException("You need more money sir", balance, item.getPrice());
    			}else {
    				balance = change;
    				item = vendingInventory.takeItem(slotID);
    				logger.logMessage(item.getName() + " " + item.getSlotID() + " $" + prevBalance + " $" + balance);
    				dispense(item);
    			}
    		}else if(choice.equals(OptionCodes.FINISH_TRANSACTION)) {
    			getChange();
    			break;
    		}
    	}
    }
    
    
    public void dispense(VendingItem item) {
    	System.out.println();
    	System.out.println("Dispensing item...");
    	System.out.println("__________________________________________");
    	System.out.println("You bought: " + item.getName());
    	System.out.println();
    	System.out.println("This vending product cost: " + item.getPrice());
    	System.out.println();
    	System.out.println("Your remaing balance is: " + balance);
    	System.out.println();
    	System.out.println(item);
    	System.out.println();
    	System.out.println("Finished dispensing vending product");
    	System.out.println("__________________________________________");
    }
    
    public void getChange() {
    	int pennyBalance = balance.setScale(2).multiply(new BigDecimal(100)).intValue();
    	System.out.println(pennyBalance);
    	int quarter = 25;
    	int dime = 10;
    	int nickel = 5;
    	int quarterQty = 0;
    	int dimeQty = 0;
    	int nickelQty = 0;
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	ArrayList<Integer> qtyList = new ArrayList<Integer>();
    	qtyList.add(quarterQty);
    	qtyList.add(dimeQty);
    	qtyList.add(nickelQty);
    	list.add(quarter);
    	list.add(dime);
    	list.add(nickel);
    
    	for (int i = 0; i < list.size(); i++) {
    		int dividend = pennyBalance / list.get(i);
    		System.out.println(dividend);
    		if (dividend > 0) {
    			pennyBalance = pennyBalance - list.get(i)*dividend;
    			qtyList.set(i, dividend);
    		}
    		
    	}
    	balance = new BigDecimal(0);
    	
    	System.out.println("Your change is: Quarters - " + qtyList.get(0) + "| Dimes - " + qtyList.get(1) + "| Nickels - " + qtyList.get(2));
    }
}
