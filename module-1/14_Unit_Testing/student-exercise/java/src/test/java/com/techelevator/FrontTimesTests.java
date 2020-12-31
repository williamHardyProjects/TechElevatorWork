package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTests {
	FrontTimes frontTimes;
	
	@Before
	public void setUp() {
		frontTimes = new FrontTimes();
	}

	@Test
	public void test_GenerateString_with_arguments_returns_empty_string() {
		String expected = "";
		
		String input1A = "",
				input2A = "",
				input3A = "ab",
				input4A = "abc",
				input5A = "abcd";
		
		int input1B = 0,
			input2B = 5,
			input3B = 0,
			input4B = 0,
			input5B = 0;
		
		String actual1 = frontTimes.generateString(input1A, input1B),
				actual2 = frontTimes.generateString(input2A, input2B),
				actual3 = frontTimes.generateString(input3A, input3B),
				actual4 = frontTimes.generateString(input4A, input4B),
				actual5 = frontTimes.generateString(input5A, input5B);
		
		String message1 = "generateString(" + input1A + ", " + input1B + ") should return " + expected + " but instead returned " + actual1,
				message2 = "generateString(" + input2A + ", " + input2B + ") should return " + expected + " but instead returned " + actual2,
				message3 = "generateString(" + input3A + ", " + input3B + ") should return " + expected + " but instead returned " + actual3,
				message4 = "generateString(" + input4A + ", " + input4B + ") should return " + expected + " but instead returned " + actual4,
				message5 = "generateString(" + input5A + ", " + input5B + ") should return " + expected + " but isntead returned " + actual5;
		
		Assert.assertEquals(message1, expected, actual1);
		Assert.assertEquals(message2, expected, actual2);
		Assert.assertEquals(message3, expected, actual3);
		Assert.assertEquals(message4, expected, actual4);
		Assert.assertEquals(message5, expected, actual5);
	}
	
	@Test
	public void test_GenerateString_with_arguments_returns_non_empty_string_less_than_3n_length() {
		String expected = "ab", inputA = "ab";
		int inputB = 1;
		String actual = frontTimes.generateString(inputA, inputB);
		
		String message = "generateString(" + inputA + ", " + inputB + ") should return " + expected + " but instead returned " + actual;
		
		Assert.assertEquals(message, expected, actual);
	}
	
	@Test
	public void test_GenerateString_with_arguments_returns_non_empty_string_atleast_3n_length() {
		String expected1 = "abcabcabcabcabc",
				expected2 = "abcd";
		
		String input1A = "abc",
				input2A = "abcd";
		
		int input1B = 5,
			input2B = 1;
		
		String actual1 = frontTimes.generateString(input1A, input1B),
				actual2 = frontTimes.generateString(input2A, input2B);
		
		String message1 = "generateString(" + input1A + ", " + input1B + ") should return " + expected1 + " but instead returned " + actual1,
				message2 = "generateString(" + input2A + ", " + input2B + ") should return " + expected2 + " but instead returned " + actual2;
		
		Assert.assertEquals(message1, expected1, actual1);
		Assert.assertEquals(message2, expected2, actual2);
	}
}
