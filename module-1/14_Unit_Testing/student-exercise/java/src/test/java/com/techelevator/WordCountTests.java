package com.techelevator;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static java.util.Map.entry;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordCountTests {
	WordCount wordCount;
	
	@Before
	public void setUp() {
		wordCount = new WordCount();
	}

	@Test
	public void test_GetCount_with_these_values_should_return_this() {
		Map<String, Integer> expected = Map.ofEntries(
					entry("a", 1),
					entry("b", 2)
					
				);
		String[] input = {null, "a", "b", "b"};
		
		Map<String, Integer> actual = wordCount.getCount(input);
		
		String message = "getCount(" + input + ") should return " + expected + " but instead returned " + actual;
		
		Assert.assertTrue(message, expected.equals(actual));
	}

}
