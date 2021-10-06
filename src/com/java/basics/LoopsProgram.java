package com.java.basics;

import java.util.ArrayList;
import java.util.List;

/*
 * 	The following is a list of all data types supported by switch statements:
 *  int and Integer / byte and Byte / short and Short / char and Character / String / enum values / var (if the type resolves to one of the preceding types)
 */

public class LoopsProgram {

	final int getCookies() { 
		return 4;
	}
	
	void feedAnimals() {
		final int bananas = 1;
		int apples = 2;
		int numberOfAnimals = 3;
		final int cookies = getCookies();
		
		switch (numberOfAnimals) {
			case bananas:		 //compile because it's final and it's value is known and not gonna change
//			case apples: 		 //The apples variable is not marked final, even though its value is known, so it is not permitted.
//			case getCookies():   //with values getCookies() and cookies, do not compile because methods are not evaluated until runtime.even if one of the values is stored in a final variable.
//			case cookies : 
			case 3 * 5 :		 //as expressions are allowed as case values, provided the value can be resolved at compile-time.
		}
	}
	
	private int getSortOrder(String firstName, final String lastName) {
		String middleName = "Patricia";
		final String suffix = "JR";
		int id = 0;
		switch(firstName) {
		case "Test":
			return 52;
//		case middleName:	// DOES NOT COMPILE 
//			id = 5;
//			break;
		case suffix:
			id = 0;
			break;
//		case lastName: 		// DOES NOT COMPILE
//			id = 8;
//			break;
//		case 5: 			// DOES NOT COMPILE
//			id = 7;
//			break;
//		case 'J': 			// DOES NOT COMPILE
//			id = 10;
//			break;
//		case java.time.DayOfWeek.SUNDAY: // DOES NOT COMPILE
//			id=15;
//			break;
		}
		return id;
	}
	
	public static void main (String[] args) {
		
		for (var counter = 4; counter >= 0; counter--) {
			System.out.print(counter + " ");
		}
		
// problem with this statement: it will never end. The variable pen is never modified, so the expression (pen < 10) will always evaluate to true.
		int pen = 2;
		int pigs = 5;
		while(pen < 10)
		pigs++;

//		for( ; ; ) Create infinite loop
		
		for(int k=0; k<10; )	// Valid
			k++;
		
		List<String> values = new ArrayList<String>();
		values.add("Lisa");
		values.add("Kevin");
		values.add("Roger");
		for(var value : values) {
			System.out.print(value + ", ");
		}
		
		int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};

		for(int[] mySimpleArray : myComplexArray) {
			for(int i=0; i<mySimpleArray.length; i++) {
				System.out.print(mySimpleArray[i]+"\t");
			}
			System.out.println();
		}
		
		OUTER_LOOP: for(int[] mySimpleArray : myComplexArray) {
			INNER_LOOP: for(int i=0; i<mySimpleArray.length; i++) {
				System.out.print(mySimpleArray[i]+"\t");
			}
			System.out.println();
		}
		
		/*
		 * 				Allows optional labels		 Allows break statement		Allows continue statement 
		 * while 		Yes 							Yes 					Yes 
		 * do while 	Yes 							Yes 					Yes 
		 * for 			Yes 							Yes						Yes 
		 * switch 		Yes 							Yes						 No
		 */
	}
}
