package com.techelevator.io;

import java.util.List;
import com.techelevator.model.TellerMachine;

public class TellerMachineOutput {
	public static void displayAllTellerMachines(List<TellerMachine> list) {
		for (TellerMachine tellerMachine: list) {
			System.out.println(tellerMachine);
		}
	}
	
	public static void displayCustomMessage(String message) {
		System.out.println(message);
	}
}
