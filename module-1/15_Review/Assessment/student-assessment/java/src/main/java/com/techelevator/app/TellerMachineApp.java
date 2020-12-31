package com.techelevator.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import com.techelevator.io.HotelReservationOutput;
import com.techelevator.io.TellerMachineInput;
import com.techelevator.io.TellerMachineOutput;
import com.techelevator.model.TellerMachine;

public class TellerMachineApp {
	public static void run() {
		List<TellerMachine> list = TellerMachineInput.readCSVToList("data-files/TellerInput.csv");
		
		TellerMachineOutput.displayAllTellerMachines(list);
		
		System.out.println("------------------------------------------------------------");
		
		BigDecimal totalBalance = new BigDecimal(0);
		
		for (TellerMachine tellerMachine: list) {
			BigDecimal balance = new BigDecimal(tellerMachine.getBalance());
			totalBalance = totalBalance.add(balance);
		}
		
		String message = "The total balance for all teller machines in the list is: " + totalBalance.setScale(2, RoundingMode.HALF_UP);
		
		HotelReservationOutput.displayCustomMessage(message);
		
	}
}
