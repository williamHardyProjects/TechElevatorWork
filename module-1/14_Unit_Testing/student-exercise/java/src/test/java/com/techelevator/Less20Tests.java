package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Less20Tests {
	Less20 less20;
	@Before
	public void setUp() {
		less20 = new Less20();
	}

	@Test
	public void test_IsLessThanMultipleOf20_with_arguments_should_return_true() {
		boolean expected = true;
		int input1 = 18,
			input2 = 19,
			input3 = 38,
			input4 = 39;
		
		boolean actual1 = less20.isLessThanMultipleOf20(input1),
				actual2 =less20.isLessThanMultipleOf20(input2),
				actual3 = less20.isLessThanMultipleOf20(input3),
				actual4 = less20.isLessThanMultipleOf20(input4);
		
		String message1 = "isLessThanMultipleOf20(" + input1 + ") should return " + expected + " but instead returned " + actual1,
				message2 = "isLessThanMultipleOf20(" + input2 + ") should return " + expected + " but instead returned " + actual2,
				message3 = "isLessThanMultipleOf20(" + input3 + ") should return " + expected + " but instead returned " + actual3,
				message4 = "isLessThanMultipleOf20(" + input4 + ") should return " + expected + " but instead returned " + actual4;
		
		Assert.assertTrue(message1, actual1);
		Assert.assertTrue(message2, actual2);
		Assert.assertTrue(message3, actual3);
		Assert.assertTrue(message4, actual4);
	}
	
	@Test
	public void test_IsLessThanMultipleOf20_with_arguments_should_return_false() {
		boolean expected = false;
		
		int input1 = -2,
			input2 = -1,
			input3 = 17,
			input4 = 20,
			input5 = 37,
			input6 = 40;
		
		boolean actual1 = less20.isLessThanMultipleOf20(input1),
				actual2 = less20.isLessThanMultipleOf20(input2),
				actual3 = less20.isLessThanMultipleOf20(input3),
				actual4 = less20.isLessThanMultipleOf20(input4),
				actual5 = less20.isLessThanMultipleOf20(input5),
				actual6 = less20.isLessThanMultipleOf20(input6);
		
		String message1 = "isLessThanMultipleOf20(" + input1 + ") should return " + expected + " but instead returned " + actual1,
				message2 = "isLessThanMultipleOf20(" + input2 + ") should return " + expected + " but instead returned " + actual2,
				message3 = "isLessThanMultipleOf20(" + input3 + ") should return " + expected + " but instead returned " + actual3,
				message4 = "isLessThanMultipleOf20(" + input4 + ") should return " + expected + " but instead returned " + actual4,
				message5 = "isLessThanMultipleOf20(" + input5 + ") should return " + expected + " but instead returned " + actual5,
				message6 = "isLessThanMultipleOf20(" + input6 + ") should return " + expected + " but instead returned " + actual6;
		
		Assert.assertFalse(message1, actual1);
		Assert.assertFalse(message2, actual2);
		Assert.assertFalse(message3, actual3);
		Assert.assertFalse(message4, actual4);
		Assert.assertFalse(message5, actual5);
		Assert.assertFalse(message6, actual6);
	}
}
