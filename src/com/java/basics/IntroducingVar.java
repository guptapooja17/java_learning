package com.java.basics;

/* 
 * Starting in Java 10, you have the option of using the keyword var instead of the type for local variables under certain conditions.
 * To use this feature, you just type var instead of the primitive or reference type.
 * The formal name of this feature is local variable type inference.
 * First comes local variable . This means just what it sounds like. You can only use this feature for local variables only.
 * what type inference means. When you type var, you are instructing the compiler to determine the type for you.
 * The compiler looks at the code on the line of the declaration and uses it to infer the type.
 */

// A var is used as a local variable in a constructor, method, or initializer block.

// A var cannot be used in constructor parameters, method parameters, instance variables, or class variables.

public class IntroducingVar {

	//var tricky = "Hello";	'var' is not allowed here as instance variable

	public void whatTypeAmI() {

		var name = "Hello";
		var size = 7;
		// size = "java";  the compiler determines that we want an int variable. Can't assign string.
		System.out.println("name = " + name + "size = " + size);


		var apples = (short)10;
		apples = (byte)5; 
		//apples = 1_000_000; DOES NOT COMPILE one million is well beyond the limits of short.
		System.out.println("apples = " + apples);


		var question 
		= 1; 			//valid
		//var answer;   have to declare and initialize the variable in the same line.
		var answer = 1;
		if (answer < question) {
			answer = 2;
		} else {
			answer = 3;
		}
		System.out.println(answer);

		//var a = 2, b = 3;	'var' is not allowed in a compound declaration. Java does not allow var in multiple variable declarations.

		/*
		 * While a var cannot be initialized with a null value without a type, it can be
		 * assigned a null value after it is declared, provided that the underlying data type of the var is an object.
		 */

		var n = "myData";
		n = null;
		var o = (String)null; // defined type by casting, A var cannot be initialized with a null value without a type.
		var m =4;
		//m = 3.0f;
		//m = null; can't assign null to primitive types
	
	}
}

/*
 * While var is not a reserved word and allowed to be used as an identifier, it is considered a reserved type name.
 * A reserved type name means it cannot be used to define a type, such as a class, interface, or enum.
 */

//class var { }	won't compile

//Java is case sensitive, so Var doesn’t introduce any conflicts as a class name. Naming a local variable var is legal.

class Var {
	public void var() {
		var var = "var";
	}
	public void Var() {
		Var var = new Var();
	}
	public Var() {
		var var = "constructor";
	}
}


