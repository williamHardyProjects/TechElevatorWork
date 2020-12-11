package com.techelevator;

public class FruitTree {
	private String typeOfFruit;
	private int piecesOfFruitLeft;
	
	public FruitTree(String typeOfFruit, int piecesOfFruitLeft) {
		this.typeOfFruit = typeOfFruit;
		this.piecesOfFruitLeft = piecesOfFruitLeft;
	}

	public String getTypeOfFruit() {
		return typeOfFruit;
	}

	public int getPiecesOfFruitLeft() {
		return piecesOfFruitLeft;
	}
	
	public boolean pickFruit(int numberOfPieciesToRemove) {
		if (numberOfPieciesToRemove > piecesOfFruitLeft) {
			return false;
		}else {
			piecesOfFruitLeft -= numberOfPieciesToRemove;
			return true;
		}
	}
	
	
}
