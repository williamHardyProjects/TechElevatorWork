package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

		
        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		
		int racoonsInWoods = 3;
		int racoonsAtHome = 2;
		
		int racoonsLeftInWoods = racoonsInWoods - racoonsAtHome;
		System.out.println("3. racoonsInWoods - racoonsAtHome = " + racoonsLeftInWoods);

        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		
		int numberOfBeesLessThanFlowers = numberOfFlowers- numberOfBees;
		System.out.println("4. numberOfFlowers- numberOfBees = " + numberOfBeesLessThanFlowers);
		
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		
		int lonelyPigeon = 1;
		int hungryPigeon = 1;
		
		int totalPigeons = lonelyPigeon + hungryPigeon;
		System.out.println("5. lonelyPigeon + hungryPigeon = " + totalPigeons);
		
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		
		int owlsSitting = 3;
		int owlsJoining = 2;
		
		int totalOwlsSitting = owlsSitting + owlsJoining;
		System.out.println("6. owlsSitting + owlsJoining = " + totalOwlsSitting);
		
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		
		int beaversAtHome = 2;
		int beaversGoingSwimming = 1;
		
		int beaversLeftAtHome = beaversAtHome - beaversGoingSwimming;
		System.out.println("7. beaversAtHome - beaversGoingSwimming = " + beaversLeftAtHome);
		
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		
		int toucansSitting = 2;
		int toucansJoining = 1;
		
		int totalToucansSitting = toucansSitting + toucansJoining;
		System.out.println("8. toucansSitting + toucansJoining = " + totalToucansSitting);
		

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		
		int numberOfSquirrels = 4;
		int numberOfNuts = 2;
		
		int numberOfSquirrelsMoreThanNuts = numberOfSquirrels - numberOfNuts;
		System.out.println("9. numberOfSquirrels - numberOfNuts = " + numberOfSquirrelsMoreThanNuts);

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		
		int quartersFound = 1;
		int dimesFound = 1;
		int nickelsFound = 2;
		
		int quarterValueInCents = 25;
		int dimeValueInCents = 10;
		int nickelValueInCents = 5;
		
		int totalChangeFound = quartersFound*quarterValueInCents + dimesFound*dimeValueInCents + nickelsFound*nickelValueInCents;
		System.out.println("10. quartersFound*quarterValue + dimesFound*dimeValue + nickelsFound*nickelValue = " + totalChangeFound);

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		
		int briersMuffins = 18;
		int macadamsMuffins = 20;
		int flannerysMuffins = 17;
		
		int totalMuffins = briersMuffins + macadamsMuffins + flannerysMuffins;
		System.out.println("11. briersMuffins + macadamsMuffins + flannerysMuffins = " + totalMuffins);

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		
		int yoyoCostInCents = 24;
		int whistleCostInCents = 14;
		
		int totalCostInCents = yoyoCostInCents + whistleCostInCents;
		System.out.println("12. yoyoCostInCents + whistleCostInCents = " + totalCostInCents);

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		
		int numberOfLargeMarshmellows = 8;
		int numberOfminiMarshmellows = 10;
		
		int totalMarshmellows = numberOfLargeMarshmellows + numberOfminiMarshmellows;
		System.out.println("13. numberOfLargeMarshmellows + numberOfminiMarshmellows = " + totalMarshmellows);

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		
		int inchesOfSnowAtHome = 29;
		int inchesOfSnowAtSchool = 17;
		
		int inchesOfSnowAtHomeMoreThanSchool = inchesOfSnowAtHome - inchesOfSnowAtSchool;
		System.out.println("14. inchesOfSnowAtHome - inchesOfSnowAtSchool = " + inchesOfSnowAtHomeMoreThanSchool);

        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		
		int numberOfDollars = 10;
		int costOfTruck = 3;
		int costOfPencilCase = 2;
		
		int numberOfDollarsLeft = numberOfDollars - (costOfTruck + costOfPencilCase);
		System.out.println("15. numberOfDollars - (costOfTruck + costOfPencilCase) = " + numberOfDollarsLeft);

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		
		int numberOfMarbles = 16;
		int marblesLost = 7;
		
		int marblesLeft = numberOfMarbles - marblesLost;
		System.out.println("16. numberOfMarbles - marblesLost = " + marblesLeft);

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		
		int seashellsNeeded = 25;
		int seashellsHad = 19;
		
		int seashellsLeft = seashellsNeeded - seashellsHad;
		System.out.println("17. seashellsNeeded - seashellsHad = " + seashellsLeft);

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		
		int totalNumberOfBalloons = 17;
		int numberOfRedBalloons = 8;
		
		int numberOfGreenBalloons = totalNumberOfBalloons - numberOfRedBalloons;
		System.out.println("18. totalNumberOfBalloons - numberOfRedBalloons = " + numberOfGreenBalloons);

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		
		int booksOnShelf = 38;
		int booksAdded = 10;
		
		int totalBooksOnShelf = booksOnShelf + booksAdded;
		System.out.println("19. booksOnShelf + booksAdded = " + totalBooksOnShelf);
		
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		
		int beeCount = 8;
		int numberOfLegs = 6;
		
		int totalNumberOfLegs = beeCount*numberOfLegs;
		System.out.println("20. beeCount*numberOfLegs = " + totalNumberOfLegs);

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		
		int qtyOfIcegreem = 2;
		double costOfIcecreamInDollars = 0.99;
		
		double totalCostIcecream = qtyOfIcegreem*costOfIcecreamInDollars;
		System.out.println("21. qtyOfIcegreem*costOfIcecreamInDollars = " + totalCostIcecream);

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		
		int rocksNeeded = 125;
		int rocksHad = 64;
		
		int rocksNeededToCompleteBorder = rocksNeeded - rocksHad;
		System.out.println("22. rocksNeeded - rocksHad = " + rocksNeededToCompleteBorder);

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		
		int marblesHad = 38;
		int lostMarbles = 15;
		
		int marblesRemaining = marblesHad - lostMarbles;
		System.out.println("23. marblesHad - lostMarbles = " + marblesRemaining);

        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		
		int totalMiles = 78;
		int milesDriven = 32;
		
		int milesLeft = totalMiles - milesDriven;
		System.out.println("24. totalMiles - milesDriven = " + milesLeft);

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */ 
		
		double morningHoursShovelingSnow = 1.5;
		double afternernoonHoursShovelingSnow = 0.75;
		
		double totalTimeShovelingSnow = morningHoursShovelingSnow + afternernoonHoursShovelingSnow;
		System.out.println("25. morningHoursShovelingSnow + afternernoonHoursShovelingSnow = " + totalTimeShovelingSnow);

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		
		int hotDogsBought = 6;
		double hotDogCost = 0.5;
		
		double costOfHotDogs = hotDogCost*hotDogsBought;
		System.out.println("26. hotDogCost*hotDogsBought = " + costOfHotDogs);

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		
		int moneyInCents = 50;
		int pencilCostInCents = 7;
		
		int totalPencilsAffordable = moneyInCents/pencilCostInCents;
		System.out.println("27. moneyInCents/pencilCostInCents = " + totalPencilsAffordable);

        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		
		int totalButterflies = 33;
		int orangeButterFlies = 20;
		
		int redButterFlies = totalButterflies - orangeButterFlies;
		System.out.println("28. totalButterflies - orangeButterFlies = " + redButterFlies);

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		
		int moneyTenderedInCents = 100;
		int candyCostInCents = 54;
		
		int change = moneyTenderedInCents - candyCostInCents;
		System.out.println("29. moneyTenderedInCents - candyCostInCents = " + change);
		
		

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		
		int treesInBackyard = 13;
		int treesPlanted = 12;
		
		int totalTrees = treesInBackyard + treesPlanted;
		System.out.println("30. treesInBackyard + treesPlanted = " + totalTrees);

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		
		int days = 2;
		int hoursInADay = 24;
		
		int totalHours = days*hoursInADay;
		System.out.println("31. days*hoursInADay = " + totalHours);

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		
		int numberOfCousins = 4;
		int gumPerCousin = 5;
		
		int totalGumNeeded = numberOfCousins*gumPerCousin;
		System.out.println("32. numberOfCousins*gumPerCousin = " + totalGumNeeded);

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		
		double currentCash = 3;
		double spentCash = 1;
		
		double cashLeft = currentCash - spentCash;
		System.out.println("33. currentCash - spentCash = " + cashLeft);

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		
		int numberOfBoats = 5;
		int peoplePerBoat = 3;
		
		int totalPeople = numberOfBoats*peoplePerBoat;
		System.out.println("34. numberOfBoats*peoplePerBoat = " + totalPeople);

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		
		int legosHad = 380;
		int legosLost = 57;
		
		int legosLeft = legosHad - legosLost;
		System.out.println("35. legosHad - legosLost = " + legosLeft);

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		
		int totalMuffinsNeeded = 83;
		int currentMuffinCount = 35;
		
		int muffinesNeeded = totalMuffinsNeeded - currentMuffinCount;
		System.out.println("36. totalMuffinsNeeded - currentMuffinCount = " + muffinesNeeded);

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		
		int willysCrayons = 1400;
		int lucysCrayons = 290;
		
		int WillysCrayonsMoreThanLucy = willysCrayons - lucysCrayons;
		System.out.println("37. willysCrayons - lucysCrayons = " + WillysCrayonsMoreThanLucy);

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		
		int pagesOfStickers = 22;
		int stickersPerPage = 10;
		
		int totalStickers = pagesOfStickers*stickersPerPage;
		System.out.println("38. pagesOfStickers*stickersPerPage = " + totalStickers);

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		
		int totalCupcakes = 96;
		int totalChildren = 8;
		
		int cupcakesPerPerson = totalCupcakes/totalPeople;
		System.out.println("39. totalCupcakes/totalPeople = " + cupcakesPerPerson);
		
		

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		
		int totalCookies = 47;
		int numberOfJars = 6;
		
		int cookiesNotPlaced = totalCookies % numberOfJars;
		System.out.println("40. totalCookies % numberOfJars = " + cookiesNotPlaced);

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		
		int totalCroissants = 59;
		int numberOfCroissants = 8;
		
		int CroissantsNotPlaced = totalCroissants % numberOfCroissants;
		System.out.println("41. totalCroissants % numberOfCroissants = " + CroissantsNotPlaced);

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		
		int cookiesBaked = 276;
		int cookiesPerTray = 12;
		
		int traysNeeded = cookiesBaked/cookiesPerTray;
		System.out.println("42. cookiesBaked/cookiesPerTray = " + traysNeeded);
		
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		
		int numberOfPretzels = 480;
		int servingSize = 12;
		
		int servings = numberOfPretzels/servingSize;
		System.out.println("43. numberOfPretzels/servingSize = " + servings);

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		
		int numberOfCupcakes = 53;
		int cupcakesLeftHome = 2;
		int boxSize = 3;
		
		int boxes = (numberOfCupcakes - cupcakesLeftHome)/boxSize;
		System.out.println("44. (numberOfCupcakes - cupcakesLeftHome)/boxSize = " + boxes);

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		
		int totalCarrots = 74;
		int people = 12;
		
		int remainingCarrots = totalCarrots%people;
		System.out.println("45. totalCarrots%people = " + remainingCarrots);

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		
		int numberOfTeddybears = 98;
		int teddybearPerShelf = 7;
		
		int numberOfShelvesFilled = numberOfTeddybears/teddybearPerShelf;
		System.out.println("46. numberOfTeddybears/teddybearPerShelf = " + numberOfShelvesFilled);
		
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		
		int numberOfPictures = 480;
		int picturesPerAlbum = 20;
		
		int totalAlbumsFilled = numberOfPictures/picturesPerAlbum;
		System.out.println("47. numberOfPictures/picturesPerAlbum = " + totalAlbumsFilled);

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		
		int totalCards = 94;
		int cardsPerBox = 8;
		
		int remainingCards = totalCards % cardsPerBox;
		System.out.println("48. totalCards % cardsPerBox = " + remainingCards);

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		
		int numberOfBooks = 210;
		int numberOfBookshelves = 10;
		
		int booksPerShelf = numberOfBooks/numberOfBookshelves;
		System.out.println("49. numberOfBooks/numberOfBookshelves = " + booksPerShelf);

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		
		int qtyOfCroissants = 17;
		int numberOfGuest = 7;
		
		int numberOfCroissantsPerGuest = qtyOfCroissants/numberOfGuest;
		System.out.println("50. qtyOfCroissants/numberOfGuest = " + numberOfCroissantsPerGuest);

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		
		//work = unitRate*time time = work/unitRate 
		
		double billsRate = 1/2.15;
		double jillsRate = 1/1.9;
		double numberOfJobs = 5;
		
		double totalTime = numberOfJobs/(billsRate + jillsRate);
		System.out.println("Challenge 1: numberOfJobs/(billsRate + jillsRate) = " + totalTime);
		
		double secondContract = 623;
		int hoursPerDay = 8;
		double hoursRequired = secondContract/(billsRate + jillsRate);

		int daysWorked = (int) hoursRequired/hoursPerDay;
		System.out.println("Challenge 1: hoursRequired/hoursPerDay = " + daysWorked);
		
        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
		
		String firstname = "William";
		String lastname = "Hardy";
		String MI = "B";
		
		String fullname = lastname + ", " + firstname + " " + MI + "."; 
		System.out.println("Challenge 2: fullname = " + fullname);

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
		
		double milesTravelled = 537;
		double milesForTrip = 800;
		
		int percentCompleted = (int) (milesTravelled/milesForTrip)*100;
		System.out.println("Challenge 3: (milesTravelled/milesForTrip)*100 = " + percentCompleted);


	}

}
