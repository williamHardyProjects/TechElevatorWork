package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxEnd3Tests {
	MaxEnd3 maxEnd3;
	
	@Before
	public void setUp() {
		maxEnd3 = new MaxEnd3();
	}
	
	@Test
	public void test_MakeArray_with_these_values_should_return_array_with_all_entries_equal_to_first() {
		int[] expected = {3, 3, 3};
		
		int[] input = {3, 2, 1};
		
		int[] actual = maxEnd3.makeArray(input);
		
		String message = "makeArray(" + input + ") should return " + expected + " but instead returned " + actual;
		
		Assert.assertArrayEquals(message, expected, actual);
	}
	
	@Test
	public void test_MakeArray_with_these_values_should_return_array_with_all_entries_equal_to_last() {
		int[] expected = {3, 3, 3};
		
		int[] input = {1, 2, 3};
		
		int[] actual = maxEnd3.makeArray(input);
		
		String message = "makeArray(" + input + ") should return " + expected + " but instead returned " + actual;
		
		Assert.assertArrayEquals(message, expected, actual);
	}
}
