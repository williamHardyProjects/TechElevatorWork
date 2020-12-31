package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;




public class DateFashionTests {
	DateFashion date;
	
	
	@Before
	public void setUp() {
		date = new DateFashion();
		
	}

	@Test
	public void test_GetATable_with_these_values_returns_0() {
		
		int expected = 0,
			
			dressedPoor1Input = 1,
			dressedPoor2Input = 2,
			dressedOk6Input = 6,
			dressedOk7Input = 7,
			dressedWell8Input = 8,
			dressedWell9Input = 9;
		
		int youPoorDateOkActual = date.getATable(dressedPoor1Input, dressedOk7Input),
			youOkDatePoorActual = date.getATable(dressedOk6Input, dressedPoor1Input),
			youPoorDateWellActual = date.getATable(dressedPoor2Input, dressedWell9Input),
			youWellDatePoorActual = date.getATable(dressedWell8Input, dressedPoor2Input);
		
		String youPoorDateOkMessage = "getATable(" + dressedPoor1Input + ", " + dressedOk7Input + ") should return " + expected + " but instead returned " + youPoorDateOkActual,
				youOkDatePoorMessage = "getATable(" + dressedOk6Input + ", " + dressedPoor1Input + ") should return " + expected + " but instead returned " + youOkDatePoorActual,
				youPoorDateWellMessage = "getATable(" + dressedPoor2Input + ", " + dressedWell9Input + ") should return " + expected + " but instead returned " + youPoorDateWellActual,
				youWellDatePoorMessage = "getATable(" + dressedWell8Input + ", " + dressedPoor2Input + ") should return " + expected + " but instead returned " + youWellDatePoorActual;
		
		Assert.assertEquals(youPoorDateOkMessage, expected, youPoorDateOkActual);
		Assert.assertEquals(youOkDatePoorMessage, expected, youOkDatePoorActual);
		Assert.assertEquals(youPoorDateWellMessage, expected, youPoorDateWellActual);
		Assert.assertEquals(youWellDatePoorMessage, expected, youWellDatePoorActual);
		

	}
	
	@Test
	public void test_GetATable_with_these_values_return_1() {
	
		int expected = 1,
				
			dressedOk3Input = 3,
			dressedOk4Input = 4,
			dressedOk7Input = 7;
		
		int bothDressOkActual1 = date.getATable(dressedOk3Input, dressedOk7Input),
			bothDressOkActual2 = date.getATable(dressedOk7Input, dressedOk3Input);
		
		String bothDressOkMessage1 = "getATable(" + dressedOk3Input + ", " + dressedOk7Input + ") should return " + expected + " but instead returned " + bothDressOkActual1,
				bothDressOkMessage2 = "getATable(" + dressedOk7Input + ", " + dressedOk3Input + ") should return " + expected + " but instead returned " + bothDressOkActual2;
		
		Assert.assertEquals(bothDressOkMessage1, expected, bothDressOkActual1);
		Assert.assertEquals(bothDressOkMessage2, expected, bothDressOkActual2);
		
	}
	
	@Test
	public void test_GetATable_with_these_values_return_2() {

		int expected = 2,
			
			dressedOk3Input = 3,
			dressedOk4Input = 4,
			dressedWell8Input = 8,
			dressedWell9Input = 9;
		
		int youOkDateWellActual = date.getATable(dressedOk3Input, dressedWell9Input),
			youWellDateOkActual = date.getATable(dressedWell8Input, dressedOk4Input),
			youWellDateWellActual = date.getATable(dressedWell8Input, dressedWell9Input);
		
		String youOkDateWellMessage = "getATable(" + dressedOk3Input + ", " + dressedWell9Input + ") should return " + expected + " but instead returned " + youOkDateWellActual,
				youWellDateOkMessage = "getATable(" + dressedWell8Input + ", " + dressedOk4Input + ") should return " + expected + " but instead returned " + youWellDateOkActual,
				youWellDateWellMessage = "getATable(" + dressedWell8Input + ", " + dressedWell9Input + ") should return " + expected + " but instead returned " + youWellDateWellActual;
		
		Assert.assertEquals(youOkDateWellMessage, expected, youOkDateWellActual);
		Assert.assertEquals(youWellDateOkMessage, expected, youWellDateOkActual);
		Assert.assertEquals(youWellDateWellMessage, expected, youWellDateWellActual);
	}

}
