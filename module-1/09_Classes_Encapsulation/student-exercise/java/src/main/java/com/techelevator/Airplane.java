package com.techelevator;

public class Airplane {
	
	private String planeNumber;
	private int totalFirstClassSeats;
	private int totalCoachSeats;
	private int bookedFirstClassSeats = 0;
	private int bookedCoachSeats = 0;
	
	public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		super();
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
	
	}
	public int getAvailableFirstClassSeats() {
		return totalFirstClassSeats - bookedFirstClassSeats;
	}
	public String getPlaneNumber() {
		return planeNumber;
	}
	
	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}
	
	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}
	
	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}
	
	public int getAvailableCoachSeats() {
		return totalCoachSeats - bookedCoachSeats;
	}
	
	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}
	
	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
		if (forFirstClass) {
			if (getAvailableFirstClassSeats() >= totalNumberOfSeats){
				bookedFirstClassSeats += totalNumberOfSeats;
				return true;
			}else {
				return false;
			}
			
		}else {
			if ( getAvailableCoachSeats() >= totalNumberOfSeats) {
				bookedCoachSeats += totalNumberOfSeats;
				return true;
			}else {
				return false;
			}
		}
	}
}
