package com.techelevator.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.techelevator.model.FlowerShopOrder;

public class FlowerShopOrderInput {
	public static List<FlowerShopOrder> readCSVToList(String fileName) {
		List<FlowerShopOrder> flowerShopOrderList = new LinkedList<FlowerShopOrder>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String orderRow;
			while ((orderRow = br.readLine()) != null) {
				String[] orderRowArray = orderRow.split(",");
				String bouquetType = orderRowArray[0];
				int numberOfRoses = Integer.parseInt(orderRowArray[1]);
				
				FlowerShopOrder order = new FlowerShopOrder(bouquetType, numberOfRoses);
				flowerShopOrderList.add(order);
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return flowerShopOrderList;
	}
	
}
