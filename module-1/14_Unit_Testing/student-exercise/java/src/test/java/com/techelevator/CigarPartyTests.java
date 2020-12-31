package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTests {
	CigarParty cigarParty;
	@Before
	public void setUp() {
		cigarParty = new CigarParty();
	}

	@Test
	public void test_HaveParty_with_these_values_should_return_true() {
		
		boolean lowerBound40NotWeekendExpected = true,
				upperBound60NotWeekendExpected = true,
				interval40To60NotWeekendExpected = true,
				lowerBound40WeekendExpected = true,
				interval40To60WeekendExpected = true,
				noUpperBoundWeekendExpected = true;
			
		
		boolean isWeekendInput = true,
				isNotWeekendInput = false;
		
		int lowerBoundCigarInput = 40,
			upperBoundCigarInput = 60,
			interval1CigarInput = 43,
			interval2CigarInput = 58,
			noUpperBoundCigarInput = 200;
		
		boolean lowerBound40NotWeekendActual = cigarParty.haveParty(lowerBoundCigarInput, isNotWeekendInput),
				upperBound60NotWeekendActual = cigarParty.haveParty(upperBoundCigarInput, isNotWeekendInput),
				interval40To60NotWeekendActual1 = cigarParty.haveParty(interval1CigarInput, isNotWeekendInput),
				interval40To60NotWeekendActual2 = cigarParty.haveParty(interval2CigarInput, isNotWeekendInput),
				lowerBound40WeekendActual = cigarParty.haveParty(lowerBoundCigarInput, isWeekendInput),
				interval40To60WeekendActual2 = cigarParty.haveParty(interval2CigarInput, isWeekendInput),
				noUpperBoundWeekendActual = cigarParty.haveParty(noUpperBoundCigarInput, isWeekendInput);
		
		String lowerBound40NotWeekendMessage = "cigarParty (" + lowerBoundCigarInput + ", " + isNotWeekendInput + ") should return " + lowerBound40NotWeekendExpected + " but instead returned " + lowerBound40NotWeekendActual,
				upperBound60NotWeekendMessage = "cigarParty (" + upperBoundCigarInput + ", " + isNotWeekendInput + ") should return " + upperBound60NotWeekendExpected + " but instead returned " + upperBound60NotWeekendActual,
				interval40To60NotWeekendMessage1 = "cigarParty (" + interval1CigarInput + ", " + isNotWeekendInput + ") should return " + interval40To60NotWeekendExpected + " but instead returned " + interval40To60NotWeekendActual1,
				interval40To60NotWeekendMessage2 = "cigarParty (" + interval2CigarInput + ", " + isNotWeekendInput + ") should return " + interval40To60NotWeekendExpected + " but instead returned " + interval40To60NotWeekendActual2,
				lowerBound40WeekendMessage = "cigarParty (" + lowerBoundCigarInput + ", " + isWeekendInput + ") should return " + lowerBound40WeekendExpected + " but instead returned " + lowerBound40WeekendActual,
				interval40To60WeekendMessage2 = "cigarParty (" + interval2CigarInput + ", " + isWeekendInput + ") should return " + interval40To60WeekendExpected + " but instead returned " + interval40To60NotWeekendActual2,
				noUpperBoundWeekendMessage = "cigarParty (" + noUpperBoundCigarInput + ", " + isWeekendInput + ") should return " + noUpperBoundWeekendExpected + " but instead returned " + noUpperBoundWeekendActual;
		
		Assert.assertTrue(lowerBound40NotWeekendMessage, lowerBound40NotWeekendActual);
		Assert.assertTrue(upperBound60NotWeekendMessage, upperBound60NotWeekendActual);
		Assert.assertTrue(interval40To60NotWeekendMessage1, interval40To60NotWeekendActual1);
		Assert.assertTrue(interval40To60NotWeekendMessage2, interval40To60NotWeekendActual2);
		Assert.assertTrue(lowerBound40WeekendMessage, lowerBound40WeekendActual);
		Assert.assertTrue(interval40To60WeekendMessage2, interval40To60WeekendActual2);
		Assert.assertTrue(noUpperBoundWeekendMessage, noUpperBoundWeekendActual);
	}
	
	@Test
	public void test_HaveParty_with_these_values_should_return_false() {
		
		boolean belowLowerBound40NotWeekendExpected = false,
				aboveUpperBound60NotWeekendExpected = false,
				belowLowerBound40WeekendExpected = false,
				upperBoundWeekendExpected = false;
			
		
		boolean isWeekendInput = true,
				isNotWeekendInput = false;
		
		int belowLowerBoundCigarInput = 39,
			aboveUpperBoundCigarInput = 61,
			upperBoundCigarInput = 200;
		
		boolean belowlowerBound40NotWeekendActual = cigarParty.haveParty(belowLowerBoundCigarInput, isNotWeekendInput),
				aboveUpperBound60NotWeekendActual = cigarParty.haveParty(aboveUpperBoundCigarInput, isNotWeekendInput),
				belowLowerBound40WeekendActual = cigarParty.haveParty(belowLowerBoundCigarInput, isWeekendInput),
				upperBoundWeekendActual = cigarParty.haveParty(upperBoundCigarInput, isWeekendInput);
		
		String belowLowerBound40NotWeekendMessage = "cigarParty (" + belowLowerBoundCigarInput + ", " + isNotWeekendInput + ") should return " + belowLowerBound40NotWeekendExpected + " but instead returned " + belowlowerBound40NotWeekendActual,
				aboveUpperBound60NotWeekendMessage = "cigarParty (" + aboveUpperBoundCigarInput + ", " + isNotWeekendInput + ") should return " + aboveUpperBound60NotWeekendExpected + " but instead returned " + aboveUpperBound60NotWeekendActual,
				belowLowerBound40WeekendMessage = "cigarParty (" + belowLowerBoundCigarInput + ", " + isWeekendInput + ") should return " + belowLowerBound40WeekendExpected + " but instead returned " + belowLowerBound40WeekendActual,
				upperBoundWeekendMessage = "cigarParty (" + upperBoundCigarInput + ", " + isWeekendInput + ") should return " + upperBoundWeekendExpected + " but instead returned " + upperBoundWeekendActual;
	
		Assert.assertFalse(belowLowerBound40NotWeekendMessage, belowlowerBound40NotWeekendActual);
		Assert.assertFalse(aboveUpperBound60NotWeekendMessage, aboveUpperBound60NotWeekendActual);
		Assert.assertFalse(belowLowerBound40WeekendMessage, belowLowerBound40WeekendActual);
		Assert.assertFalse(upperBoundWeekendMessage, upperBoundWeekendActual);
	}
}
