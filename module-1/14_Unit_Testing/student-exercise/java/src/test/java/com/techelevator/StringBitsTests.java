package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBitsTests {
	StringBits stringBits;
	@Before
	public void setUp() {
		stringBits = new StringBits();
	}

	@Test
	public void testGetBits_with_these() {
		String expected1 = "",
				expected2 = "a",
				expected3 = "b",
				expected4 = "df";
		
		String input1 = null,
				input2 = "a",
				input3 = "bc",
				input4 = "def";
		
		String actual1 = stringBits.getBits(input1),
				actual2 = stringBits.getBits(input2),
				actual3 = stringBits.getBits(input3),
				actual4 = stringBits.getBits(input4);
		
		String message1 = "getBits(" + input1 + ") should return " + expected1 + " but instead returned " + actual1,
				message2 = "getBits(" + input2 + ") should return " + expected2 + " but instead returned " + actual2,
				message3 = "getBits(" + input3 + ") should return " + expected3 + " but instead returned " + actual3,
				message4 = "getBits(" + input4 + ") should return " + expected4 + " but instead returned " + actual4;
		
		Assert.assertEquals(message1, expected1, actual1);
		Assert.assertEquals(message2, expected2, actual2);
		Assert.assertEquals(message3, expected3, actual3);
		Assert.assertEquals(message4, expected4, actual4);
	}

}
