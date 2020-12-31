package com.techelevator.model;

public interface Billable {
	public double getLatePenalty(int daysLate);
}
