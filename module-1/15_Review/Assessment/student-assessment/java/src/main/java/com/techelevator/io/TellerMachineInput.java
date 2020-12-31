package com.techelevator.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


import com.techelevator.model.TellerMachine;

public class TellerMachineInput {
	public static List<TellerMachine> readCSVToList(String fileName) {
		List<TellerMachine> list = new LinkedList<TellerMachine>();
		String TellerMachineRow;
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((TellerMachineRow = br.readLine()) != null) {
				String[] TellerMachineArray = TellerMachineRow.split(",");
				String manufacturer = TellerMachineArray[0];
				double deposits = Double.parseDouble(TellerMachineArray[1].trim());
				double withdrawals = Double.parseDouble(TellerMachineArray[2].trim());
				
				TellerMachine tellerMachine = new TellerMachine(manufacturer, deposits, withdrawals);
				list.add(tellerMachine);
						
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}
