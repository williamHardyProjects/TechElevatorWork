package com.techelevator;

public class Elevator {
	int currentLevel;
	int numberOfFloors;
	boolean doorOpen;

	public Elevator() {
		this(1);
	}
	public Elevator(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
		this.currentLevel = 1;
	}

	public int getCurrentFloor() {
		return currentLevel;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}
	
	public void openDoor() {
		doorOpen = true;
	}
	
	public void closeDoor() {
		doorOpen = false;
	}
	
	public void goUp(int desiredFloor) {
		boolean isDoorOpen = isDoorOpen();
		if (desiredFloor <= numberOfFloors && desiredFloor > currentLevel && isDoorOpen != true) {
			currentLevel = desiredFloor;
		}
	}
	
	public void goDown(int desiredFloor) {
		boolean isDoorOpen = isDoorOpen();
		if (desiredFloor >= 1 && desiredFloor < currentLevel  && isDoorOpen != true) {
			currentLevel = desiredFloor;
		}
	}
}
