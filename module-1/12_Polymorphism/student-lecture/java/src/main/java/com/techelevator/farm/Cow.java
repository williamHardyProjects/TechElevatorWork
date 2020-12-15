package com.techelevator.farm;

public class Cow extends FarmAnimal
{
	private boolean isEating;

	public Cow()
	{
		super("Cow", "moo!");
	}	
	
	public boolean isEating()
	{
		return isEating;
	}

	public void setEating(boolean isEating)
	{
		this.isEating = isEating;
	}

	@Override
	public String getSound()
	{
		if(isEating)
		{
			return "chew!";
		}
		else 
		{
			return super.getName();
		}
	}

}