package com.techelevator.app;

import java.math.BigDecimal;
import java.util.List;

import com.techelevator.io.FlowerShopOrderInput;
import com.techelevator.io.FlowerShopOrderOutput;
import com.techelevator.model.FlowerShopOrder;

public class FlowerShopOrderApp {
	public static void run() {
		List<FlowerShopOrder> list = FlowerShopOrderInput.readCSVToList("data-files/FlowerInput.csv");
		
		FlowerShopOrderOutput.displayFlowerShopOrderList(list);
		
		System.out.println("----------------------------------------------------");
		
		BigDecimal allOrdersSubtotal = new BigDecimal(0);
		for (FlowerShopOrder order: list) {
			allOrdersSubtotal = allOrdersSubtotal.add(new BigDecimal(order.getSubtotal()));
		}
		String message = "The gross amount for all flower shop orders is: " + allOrdersSubtotal.doubleValue();
		FlowerShopOrderOutput.displayCustomMessage(message);
	}
}
