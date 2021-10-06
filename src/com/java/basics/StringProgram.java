package com.java.basics;

import java.util.stream.Collectors;

/* 
 * A string is basically a sequence of characters. Once a String object is created, it is not allowed to change. It cannot be made larger or
 * smaller, and you cannot change one of the characters inside it. The strings are immutable because string objects are cached in STRING POOL. 
 * Since it can be shared by multiple clients, we can't allow it to be changed. Immutability is achieved using STRING CONSTANT POOL.
 */

/*
 * String class implemented CharSequence interface.
 */

/*
 * String s = new string ("ABC"). How many objects are created after the above statement? 	-	Two
 * So when the class containing this code is loaded, JVM finds the string literal "ABC", 
 * creates a string object and puts its reference into string constant pool. Now when the statement is executed, 
 * JVM is forced to create a new string object with contents "ABC" because of the new operator. 
 * This time no reference will be put into string constant pool because already there is reference for the same literal.
 */
public class StringProgram {

	public static void main (String[] arg) {

		String s1 = "abc";
		String s2 = "abc";
		System.out.println((s1 == s2) ? true : false);
		System.out.println((s1.equals(s2)) ? true : false);	//check the content of string/string object.
		System.out.println("___________________________");

		String objs1 = new String("abc");
		String objs2 = new String("abc");
		System.out.println((objs1 == objs2) ? true : false);
		System.out.println((objs1.equals(objs2)) ? true : false);
		System.out.println("___________________________");

		System.out.println((objs1 == s1) ? true : false);
		System.out.println((objs1.equals(s1)) ? true : false);
		System.out.println("___________________________");

		String s = "DataScience";
		String s3 = new String("DataScience");
		String objs3 = new String("DataScience").intern(); //puts the string into  STRING POOL or refer another string literal from STRING POOL having the same value.
		System.out.println((s == objs3) ? true : false);
		System.out.println((s3 == objs3) ? true : false);
		System.out.println("___________________________");

		System.out.println(s3.length());

		System.out.println(s3.charAt(10)); // index not found then java.lang.StringIndexOutOfBoundsException

		System.out.println(s3.indexOf('e'));
		System.out.println(s3.indexOf('e', 3)); // Start checking char from the index specified
		System.out.println(s3.indexOf("enc", 3));

		System.out.println(s3.substring(4));
		System.out.println(s3.substring(2, 7));
		System.out.println(s3.substring(3, 3));	 // Empty String
		System.out.println(s3.substring(2, 11)); //	Last index should be "end of string" index else exception at runtime. java.lang.StringIndexOutOfBoundsException

		System.out.println("datascience".equals(s3));
		System.out.println("datascience".equalsIgnoreCase(s3));

		System.out.println("datascience".startsWith("DATA"));	//	case-sensitive
		System.out.println("datascience".startsWith("data"));

		System.out.println("datascience".endsWith("NCE"));		//	case-sensitive
		System.out.println("datascience".endsWith("ce"));

		System.out.println(s3.contains("DaTA"));				//	case-sensitive
		System.out.println(s3.contains("Data"));	

		System.out.println(s3.toLowerCase());
		System.out.println(s3.toUpperCase());

		System.out.println(s3.replace('D', 'K'));				//	case-sensitive
		System.out.println(s3.replace("Data", "KATA"));
		System.out.println("___________________________");

		//		strip() and trim() methods remove whitespace from beginning and end of a String. strip() method is new in Java 11. It does everything that trim() does, but it supports Unicode.
		String text = " abc\t ";
		System.out.println(text.trim().length()); 				// 
		System.out.println(text.strip().length()); 				// Java 11
		System.out.println(text.stripLeading().length()); 		// Java 11
		System.out.println(text.stripTrailing().length());		// Java 11

		//		isBlank() returns true if the given string is empty or contains only whitespace. It uses Character.isWhiteSpace(char) to determine whitespace character.
		System.out.println("isBlank() Method" + "ABC".isBlank());	// Java 11
		System.out.println("isBlank() Method" + " ABC ".isBlank());
		System.out.println("isBlank() Method" + " ".isBlank());
		System.out.println("isBlank() Method" + "".isBlank());

		//		isEmpty() return true if and only if string is of length 0
		System.out.println("isEmpty() Method" + "ABC".isEmpty());
		System.out.println("isEmpty() Method" + " ABC ".isEmpty());
		System.out.println("isEmpty() Method" + " ".isEmpty());
		System.out.println("isEmpty() Method" + "".isEmpty());

		//		lines() return a collection of strings '\n'
		System.out.println("Geeks\nfor\nGeeks".lines().collect(Collectors.toList()));	//java 11
		System.out.println("Geeks\tfor\tGeeks".lines().collect(Collectors.toList()));

		s = "Geeks\nfor\nGeeks\nfor\nGeeks";
		String[] arr = s.split("\\n", 3);
		for (String string : arr) 
			System.out.print(string);

		// 		repeat() results is concatenated string is original string repeated no. of times in the argument.
		System.out.println("\n" + "Pooja".repeat(5));	//java 11
	}

}
