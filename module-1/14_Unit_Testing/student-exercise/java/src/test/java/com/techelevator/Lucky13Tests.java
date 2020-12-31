package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lucky13Tests {
	Lucky13 lucky13;
	@Before
	public void setUp() {
		lucky13 = new Lucky13();
	}

	@Test
	public void testGetLucky_returns_return_true_for_these_values() {
		boolean expected = true;
		int[] input1 = {2,4,5};
		
		boolean actual = lucky13.getLucky(input1);
		
		String message = "getLucky(" + input1 + ") should return " + expected + " but instead returned " + actual;
		
		Assert.assertTrue(message, actual);
	}
	
	@Test
	public void testGetLucky_returns_false_for_these_values() {
		boolean expected = false;
		int[] input1 = {1},
				input2 = {3},
				input3 = {1,3};
		
		boolean actual1 = lucky13.getLucky(input1),
				actual2 = lucky13.getLucky(input2),
				actual3 = lucky13.getLucky(input3);
		
		String message1 = "getLucky(" + input1 + ") should return " + expected + " but instead returned " + actual1,
				message2 = "getLucky(" + input2 + ") should return " + expected + " but instead returned " + actual2,
				message3 = "getLucky(" + input3 + ") should return " + expected + " but instead returned " + actual3;
		
		Assert.assertFalse(message1, actual1);
		Assert.assertFalse(message2, actual2);
		Assert.assertFalse(message3, actual3);
	}

}
