package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SameFirstLastTests {
	SameFirstLast sameFirstLast;
	
	@Before
	public void setUp() {
		sameFirstLast = new SameFirstLast();
	}

	@Test
	public void test_IsItTheSame_with_these_values_will_return_true() {
		boolean exptected = true;
		
		int[] input1 = {1},
				input2 = {2, 2},
				input3 = {3, 4, 3};
		
		boolean actual1 = sameFirstLast.isItTheSame(input1),
				actual2 = sameFirstLast.isItTheSame(input2),
				actual3 = sameFirstLast.isItTheSame(input3);
		
		String message1 = "isItTheSame(" + input1 + ") should return " + exptected + " but instead returned " + actual1,
				message2 = "isItTheSame(" + input2 + ") should return " + exptected + " but instead returned " + actual2,
				message3 = "isItTheSame(" + input3 + ") should return " + exptected + " but instead returned " + actual3;
		
		Assert.assertTrue(message1, actual1);
		Assert.assertTrue(message2, actual2);
		Assert.assertTrue(message3, actual3);
	}
	
	@Test
	public void test_IsItTheSame_with_these_values_will_return_false() {
		boolean exptected = false;
		
		int[] input1 = {},
				input2 = {2, 3},
				input3 = null;
		
		boolean actual1 = sameFirstLast.isItTheSame(input1),
				actual2 = sameFirstLast.isItTheSame(input2),
				actual3 = sameFirstLast.isItTheSame(input3);
		
		String message1 = "isItTheSame(" + input1 + ") should return " + exptected + " but instead returned " + actual1,
				message2 = "isItTheSame(" + input2 + ") should return " + exptected + " but instead returned " + actual2,
				message3 = "isItTheSame(" + input3 + ") should return " + exptected + " but instead returned " + actual3;
		
		Assert.assertFalse(message1, actual1);
		Assert.assertFalse(message2, actual2);
		Assert.assertFalse(message3, actual3);
	}
}
