package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTests {
	AnimalGroupName groupName;
	
	@Before
	public void setUp() {
		groupName = new AnimalGroupName();
	}

	@Test
	public void test_getHerd_with_null_not_found_or_empty_argument_should_return_unknown() {
		
		
		String nullArgumentExpected = "unknown",
				emptyArgumentExpected = "unknown",
				notFoundArgumentExpected = "unknown";
		
		String nullArgumentInput = null,
				emptyArgumentInput = "",
				notFoundArgumentInput = "NOT FOUND";
		
		String nullArgumentActual = groupName.getHerd(nullArgumentInput),
				emptyArgumentActual = groupName.getHerd(emptyArgumentInput),
				notFoundArgumentActual = groupName.getHerd(notFoundArgumentInput);
		
		String nullArgumentMessage = "getHerd(" + nullArgumentInput + ") should return: " + nullArgumentExpected + " but instead returned " + nullArgumentActual,
				emptyArgumentMessage = "getHerd(" + emptyArgumentInput + ") should return: " + emptyArgumentExpected + " but instead returned " + emptyArgumentActual,
				notFoundArgumentMessage = "getHerd(" + notFoundArgumentInput + ") should return: " + notFoundArgumentExpected + " but instead returned " + notFoundArgumentActual;

		Assert.assertEquals(nullArgumentMessage, nullArgumentExpected, nullArgumentActual);
		Assert.assertEquals(emptyArgumentMessage, emptyArgumentExpected, emptyArgumentActual);
		Assert.assertEquals(notFoundArgumentMessage, notFoundArgumentExpected, notFoundArgumentActual);		
	}
	

	@Test
	public void test_getHerd_with_mixed_casing_should_return_correct_groupname() {
		
		String rhinotoCrashExpected = "Crash",
				giraffeToTowerExpected = "Tower",
				elephantToHerdExpected = "Herd",
				lionToPrideExpected = "Pride",
				crowToMurderExpected = "Murder",
				pigeonToKitExpected = "Kit",
				flamingoToPatExpected = "Pat",
				deerToHerdExpected = "Herd",
				dogToPackExpected = "Pack",
				crocodileToFloatExpected = "Float";
		
		//given inputs
		String rhinoInput = "rHinO",
				giraffeInput = "GIRAFFE",
				elephantInput = "elephant",
				lionInput = "liON",
				crowInput = "crOW",
				pigeonInput = "PiGeOn",
				flamingoInput = "flaMINgo",
				deerInput = "deeR",
				dogInput = "DOG",
				crocodileInput = "CRocODilE";
		
		//getHerd outputs
		String rhinoActual = groupName.getHerd(rhinoInput),
				giraffeActual = groupName.getHerd(giraffeInput),
				elephantActual = groupName.getHerd(elephantInput),
				lionActual = groupName.getHerd(lionInput),
				crowActual = groupName.getHerd(crowInput),
				pigeonActual = groupName.getHerd(pigeonInput),
				flamingActual = groupName.getHerd(flamingoInput),
				deerActual = groupName.getHerd(deerInput),
				dogActual = groupName.getHerd(dogInput),
				crocodileActual = groupName.getHerd(crocodileInput);
		
		//error messages
		String rhinoMessage = "getHerd(" + rhinoInput + ") should return: " + rhinotoCrashExpected + " but instead returned " + rhinoActual,
				giraffeMessage = "getHerd(" + giraffeInput + ") should return: " + giraffeToTowerExpected + " but instead returned " + giraffeActual,
				elephantMessage = "getHerd(" + elephantInput + ") should return: " + elephantToHerdExpected + " but instead returned " + elephantActual,
				lionMessage = "getHerd(" + lionInput + ") should return: " + lionToPrideExpected + " but instead returned " + lionActual,
				crowMessage = "getHerd(" + crowInput + ") should return: " + crowToMurderExpected + " but instead returned " + crowActual,
				pigeonMessage = "getHerd(" + pigeonInput + ") should return: " + pigeonToKitExpected + " but instead returned " + pigeonActual,
				flamingoMessage = "getHerd(" + flamingoInput + ") should return: " + flamingoToPatExpected + " but instead returned " + flamingActual,
				deerMessage = "getHerd(" + deerInput + ") should return: " + deerToHerdExpected + " but instead returned " + deerActual,
				dogMessage = "getHerd(" + dogInput + ") should return: " + dogToPackExpected + " but instead returned " + dogActual,
				crocodileMessage = "getHerd(" + crocodileInput + ") should return: " + crocodileToFloatExpected + " but returned " + crocodileActual;
		
		Assert.assertEquals(rhinoMessage, rhinotoCrashExpected, rhinoActual);
		Assert.assertEquals(giraffeMessage, giraffeToTowerExpected, giraffeActual);
		Assert.assertEquals(elephantMessage, elephantToHerdExpected, elephantActual);
		Assert.assertEquals(lionMessage, lionToPrideExpected, lionActual);
		Assert.assertEquals(crowMessage, crowToMurderExpected, crowActual);
		Assert.assertEquals(pigeonMessage, pigeonToKitExpected, pigeonActual);
		Assert.assertEquals(flamingoMessage, flamingoToPatExpected, flamingActual);
		Assert.assertEquals(deerMessage, deerToHerdExpected, deerActual);
		Assert.assertEquals(dogMessage, dogToPackExpected, dogActual);
		Assert.assertEquals(crocodileMessage, crocodileToFloatExpected, crocodileActual);		
	}
	
	

}
