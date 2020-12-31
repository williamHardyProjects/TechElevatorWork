package com.techelevator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FlowerShopOrder implements Deliverable {
	private String bouquetType;
	private int numberOfRoses;
	
	public FlowerShopOrder(String bouquetType, int numberOfRoses) {
		super();
		this.bouquetType = bouquetType;
		this.numberOfRoses = numberOfRoses;
	}
	
	public double getSubtotal() {
		BigDecimal standard = new BigDecimal(19.99),
					costPerRose = new BigDecimal(2.99),
					totalRoseCost = costPerRose.multiply(new BigDecimal(numberOfRoses));
		
		
		double subtotal = standard.add(totalRoseCost).setScale(2, RoundingMode.HALF_UP).doubleValue();
		
		return subtotal;
	}

	@Override
	public double getDeliveryFee(boolean sameDayDelivery, String zipCode) {
		int zip = Integer.parseInt(zipCode);
		
		BigDecimal sameDayDeliveryFee = new BigDecimal(5.99),
					deliveryFee = new BigDecimal(0);
		
		boolean isZipCloser = (20000 <= zip) && (zip <= 29999),
				isZipClose = (30000 <= zip) && (zip <= 39999);
		
		if (isZipCloser) {
			deliveryFee = new BigDecimal(3.99);
		}
		if (isZipClose) {
			deliveryFee = new BigDecimal(6.99);
		}
		if ((isZipClose || isZipCloser) && sameDayDelivery) {
			deliveryFee.add(sameDayDeliveryFee);
		}
		if (!isZipClose && !isZipCloser) {
			deliveryFee = new BigDecimal(19.99);
		}
		return deliveryFee.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	@Override
	public String toString() {
		return "ORDER - " + bouquetType + " - " + numberOfRoses + " roses - " + getSubtotal();
	}	
}
