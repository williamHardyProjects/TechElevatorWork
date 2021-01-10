package com.techelevator.application;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.techelevator.models.OptionCodes;
import com.techelevator.models.VendingInventory;
import com.techelevator.models.VendingItem;
import com.techelevator.models.VendingLoader;
import com.techelevator.ui.screens.Screen;
import com.techelevator.ui.screens.UserInput;
import com.techelevator.ui.screens.UserOutput;

public class VendingMachine 
{
	VendingInventory vendingInventory = new VendingInventory("vendingmachine.csv", VendingLoader.getVendingLoader());
	BigDecimal balance = new BigDecimal(0);

	
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
                vend();
            }
            else if(choice.equals(OptionCodes.EXIT))
            {                
                break;
            }
        }
    }
    
    public void vend() {
    	while(true) {
    		String choice = UserInput.getPurchaseMenuSelection();
    		
    		if(choice.equals(OptionCodes.FEED_MONEY)) {
    			
    			BigDecimal moneyInserted = UserInput.getMoney();
    			balance.add(moneyInserted);
    			
    		}else if(choice.equals(OptionCodes.SELECT_PRODUCT)) {
    			
    			
    			
    		}else if(choice.equals(OptionCodes.FINISH_TRANSACTION)) {
    			break;
    		}
    	}
    }
    
    public void dispense() {
    	
    }
}
