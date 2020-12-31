package com.techelevator.io;

import java.util.List;

import com.techelevator.model.FlowerShopOrder;

public class FlowerShopOrderOutput {
	public static void displayFlowerShopOrderList(List<FlowerShopOrder> list) {
		for (FlowerShopOrder order: list) {
			System.out.println(order);
		}
	}
	
	public static void displayCustomMessage(String message) {
		System.out.println(message);
	}
}
