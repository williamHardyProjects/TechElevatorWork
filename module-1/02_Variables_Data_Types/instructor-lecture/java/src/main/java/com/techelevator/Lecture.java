package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/	
		
		// how to declare a variable
		// datatype variableName;
		// use camelCase convention for variable names
		int numberOfExercises;
		numberOfExercises = 26;	
		System.out.println("1. numberOfExercises = " + numberOfExercises);
		
		
		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		
		double half = 0.5;
		System.out.println("2. half = " + half);
		

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/

		String name = "TechElevator";
		System.out.println("3. name = " + name);

		
		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/

		byte seasonsOfFirefly = 1;
		System.out.println("4. seasonsOfFirefly = " + seasonsOfFirefly);

		
		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/

		String myFavoriteLanguage;
		myFavoriteLanguage = "Java";
		System.out.println("5. myFavoriteLanguage = " + myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/

		double pi = 3.1416;
		System.out.println("6. pi = " + pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		
		String myName = "Gregor";
		System.out.println("7. myName = " + myName);
		
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		
		int numberOfButtonsOnMouse = 7;
		System.out.println("8. numberOfButtonsOnMouse = " + numberOfButtonsOnMouse);
		

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		
		double percentBattery;
		percentBattery = .97;
		System.out.println("9. percentBattery = " + percentBattery);
		

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		
		int number121 = 121;
		int number27 = 27;
		int difference = number121 - number27;
		System.out.println("10. 121 - 27 = " + difference);

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		
		double one11 = 12.3;
		double two11 = 32.1;
		double answer11 = one11 + two11;
		System.out.println("11. 12.3 + 32.1 = " + answer11);
		

		/*
		12. Create a String that holds your full name.
		*/
		
		String fullName = "Gregor Dzierzon";
		System.out.println("12. " + fullName);

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		
		String helloFullName = "Hello " + fullName;
		System.out.println("13. " + helloFullName);

		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		
		// current 
		// fullName -> Gregor Dzierzon
		// goal
		// fullName -> Gregor Dzierzon Esquire
		fullName = fullName + " Esquire";
		System.out.println("14. " + fullName);

		/*
		15. Now do the same as exercise 14, but use the += operator.
		
		the + and the += are used to concatenate Strings.
		
		For numbers + and += are used to add 		
		Other arithmetic operators
		number += 1 -> number = number + 1
		number -= 1 -> number = number - 1
		number /= 2 -> number = number / 2
		number *= 2 -> number = number * 2
		number %= 2 -> number = number % 2	// remainder	
		
		*/
		
		// the following is the same as 
		// fullName = fullName + " Esquire";
		fullName += " Esquire";
		System.out.println("15. " + fullName);

		
		
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		
		String movie = "Saw";
		movie += 2;
		System.out.println("16. " + movie);

		
		
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		movie += 0;
		System.out.println("17. " + movie);

		
		
		/*
		18. What is 4.4 divided by 2.2?
		*/
		
		double numerator18 = 4.4;
		double denominator18 = 2.2;
		double answer18 = numerator18 / denominator18;
		System.out.println("18. 4.4 / 2.2 = " + answer18);

		
		
		/*
		19. What is 5.4 divided by 2?
		*/		
		double numerator19 = 5.4;
		int denominator19 = 2;
		double answer19 = numerator19 / denominator19;
		System.out.println("19. 5.4 / 2 = " + answer19);

		/*
		20. What is 5 divided by 2?
		*/
		int numerator20 = 5;
		int denominator20 = 2;
		double answer20 = numerator20 / denominator20;
		System.out.println("20. 5 / 2 = " + answer20);

		/*
		21. What is 5.0 divided by 2?
		*/
		double numerator21 = 5;
		int denominator21 = 2;
		double answer21 = numerator21 / denominator21;
		System.out.println("21. 5.0 / 2 = " + answer21);

		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		
		double numerator22 = 66.6;
		int denominator22 = 100;
		double answer22 = numerator22  / denominator22;
		System.out.println("22. " + answer22);

		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		
		int one23 = 19;
		int two23 = 4;
		int division = one23 / two23;
		int remainder = one23 % two23; // % returns the remainder
		System.out.println("23. 19 / 4 =  " + division + " R" + remainder);

		/*
		24. What is 1,000,000,000 * 3?
		*/

		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE + 1);
		
		int billion = 1000000000;
		long number = 3;
		long threeBillion = billion * number;
		System.out.println("24. Three Billion = " + threeBillion);

		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		
		boolean doneWithExercises = false;
		System.out.println("25. doneWithExercises = " + doneWithExercises);

		/*
		26. Now set doneWithExercise to true.
		*/
			
		doneWithExercises = true;
		System.out.println("26. doneWithExercises = " + doneWithExercises);
		
	}

}
