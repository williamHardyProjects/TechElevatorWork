package com.techelevator.model;

public interface Deliverable {
	double getDeliveryFee(boolean sameDayDelivery, String zipCode);
}
