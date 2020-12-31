package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonStartTests {
	NonStart nonStart;
	@Before
	public void setUp() {
		nonStart = new NonStart();
	}

	@Test
	public void test_GetPartialString_with_these_values_will_return_string_length_0() {
		String expected = "";
		
		String input1A = "a",
				input1B = "b",
				input2A = "",
				input2B = "c",
				input3A = "d",
				input3B = "";
		
		String actual1 = nonStart.getPartialString(input1A, input1B),
				actual2 = nonStart.getPartialString(input2A, input2B),
				actual3 = nonStart.getPartialString(input3A, input3B);
		
		String message1 = "getPartialString(" + input1A + ", " + input1B + ") should return " + expected + " but instead returned " + actual1,
				message2 = "getPartialString(" + input2A + ", " + input2B + ") should return " + expected + " but instead returned " + actual2,
				message3 = "getPartialString(" + input3A + ", " + input3B + ") should return " + expected + " but instead returned " + actual3;
		
		Assert.assertEquals(message1, expected, actual1);
		Assert.assertEquals(message2, expected, actual2);
		Assert.assertEquals(message3, expected, actual3);
	}
	
	@Test
	public void test_GetPartialString_with_these_values_will_return_string_length_1() {
		String expected1 = "c",
				expected2 = "e",
				expected3 = "h",
				expected4 = "j";
		
		String input1A = "a",
				input1B = "bc",
				input2A = "de",
				input2B = "f",
				input3A = "",
				input3B = "gh",
				input4A = "ij",
				input4B = "";;
		
		String actual1 = nonStart.getPartialString(input1A, input1B),
				actual2 = nonStart.getPartialString(input2A, input2B),
				actual3 = nonStart.getPartialString(input3A, input3B),
				actual4 = nonStart.getPartialString(input4A, input4B);
		
		String message1 = "getPartialString(" + input1A + ", " + input1B + ") should return " + expected1 + " but instead returned " + actual1,
				message2 = "getPartialString(" + input2A + ", " + input2B + ") should return " + expected2 + " but instead returned " + actual2,
				message3 = "getPartialString(" + input3A + ", " + input3B + ") should return " + expected3 + " but instead returned " + actual3,
				message4 = "getPartialString(" + input4A + ", " + input4B + ") should return " + expected4 + " but instead returned " + actual4;
		
		Assert.assertEquals(message1, expected1, actual1);
		Assert.assertEquals(message2, expected2, actual2);
		Assert.assertEquals(message3, expected3, actual3);
		Assert.assertEquals(message4, expected4, actual4);
		
	}
	
	@Test
	public void test_GetPartialString_with_these_values_will_return_string_length_atleast_2() {
		String expected1 = "bd",
				expected2 = "fgij";
		
		String input1A = "ab",
				input1B = "cd",
				input2A = "efg",
				input2B = "hij";
		
		String actual1 = nonStart.getPartialString(input1A, input1B),
				actual2 = nonStart.getPartialString(input2A, input2B);
		
		String message1 = "getPartialString(" + input1A + ", " + input1B + ") should return " + expected1 + " but instead returned " + actual1,
				message2 = "getPartialString(" + input2A + ", " + input2B + ") should return " + expected2 + " but instead returned " + actual2;
		
		Assert.assertEquals(message1, expected1, actual1);
		Assert.assertEquals(message2, expected2, actual2);
	}

}
