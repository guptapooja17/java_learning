package com.java.basics;

/*
 * Post-unary operators			 		expression++, expression--
 * Pre-unary operators 					++expression, --expression
 * Other unary operators				-, !, ~, +, (type)
 * Multiplication/division/modulus		*, /, %
 * Addition/subtraction				 	+, -
 * Shift operators 						<<, >>, >>>
 * Relational operators					<, >, <=, >=, instanceof
 * Equal to/not equal to				==, !=
 * Logical operators 					&, ^, |
 * Short-circuit logical operators		&&, ||
 * Ternary operators 					boolean expression ? expression1 : expression2
 * Assignment operators				 	=, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=
 */

//A Java operator is a special symbol that can be applied to a set of variables, values, or literals—referred to as operands and that returns a result.

/*
 * Numeric Promotion Rules :
 * If two values have different data types, Java will automatically promote one of the values to the larger of the two data types.
 * If one of the values is integral and the other is floating-point, Java will automatically promote the integral value to the floating-point value’s data type.
 * Smaller data types, namely, byte, short , and char , are first promoted to int any time they’re used with a Java binary arithmetic operator, even if neither of the 
 * operands is int. After all promotion has occurred and the operands have the same data type, the resulting value will have the same data type as its promoted operands.
 */

/*
 * == 	Returns true if the two values represent the same value		Returns true if the two values reference the same object
 * != 	Returns true if the two values represent different values	Returns true if the two values do not reference the same object
 * 
 * Comparing two numeric or character primitive types. If the numeric values are of different data types, the values are automatically promoted.
 * Comparing two objects, including null and String values
 */

/*
 * a instanceof b Returns true if the reference that a points to is an instance of a class,subclass, or class that implements a particular interface, as named in b.
 * calling instanceof on the null literal or a null reference always returns false.
 */

/*
 * & 		Logical AND is true only if both values are true.
 * | 		Inclusive OR is true if at least one of the values is true.
 * ^ 		Exclusive XOR is true only if one value is true and the other is false.
 */

/*
 * && 		Short-circuit AND is true only if both values are true. If the left side is false,then the right side will not be evaluated.
 * || 		Short-circuit OR is true if at least one of the values is true. If the left side is true, then the right side will not be evaluated.
 */
public class OperatorPrecedence {
	
	public static void main (String[] args) {
		
		boolean isAnimalAsleep = false;
		isAnimalAsleep = !isAnimalAsleep;
		System.out.println(isAnimalAsleep);
		//boolean peacock = !0;					 Work only with boolean
		
		double zooTemperature = 1.21;
		zooTemperature = -zooTemperature;
		System.out.println(zooTemperature);
		zooTemperature = -(-zooTemperature);
		System.out.println(zooTemperature);
		
		//left - right evaluation
		int lion = 3;
		int tiger = ++lion * 5 / lion--;
		System.out.println("lion is " + lion);
		System.out.println("tiger is " + tiger);
		
		System.out.println(9 / 3);
		System.out.println(9 % 3);
		
		double x = 39.21;
		//float y = 2.1;
		float y = 2.1f;
		var z = x + y;
		System.out.println(z);
		
		//float egg = 2.0 / 9; 			// DOES NOT COMPILE assigning larger data type to smaller data type
		//int tadpole = (int)5 * 2L; 	
		//short frog = 3 - 2.0; 		
		
		float egg = (float) (2.0 / 9); 
		int tadpole = (int)((int)5 * 2L); 
		short frog = (int)(3 - 2.0);
		
		var egg1 = 2.0 / 9; 
		var tadpole1 = (int)5 * 2L; 
		var frog1 = 3 - 2.0;
		
		egg1 = 3.0f;
		//tadpole1 = 5.0f;	var is of long type
		tadpole1 = 7L;
		frog1 = 4.0;
		
		//long feathers = 10(long);
		long feathers = (long)10;
		
		int camel = 2, giraffe = 3;
		camel *= giraffe;
		
		Number time = 1;
        String str = "time";
        // System.out.println(time instanceof String);	Incompatible conditional operand types Number and String )
		
		System.out.println(null instanceof Object);
		Object noObjectHere = null;
		System.out.println(noObjectHere instanceof String);
		
		//System.out.print(null instanceof null);	right side of instanceof must not be a  null
		
		//if(duck!=null & duck.getAge()<5) 	Could throw NPE, (&) operator evaluates both sides of the expression.
		//if(duck!=null && duck.getAge()<5) If the duck is null, second expression will never be evaluated.
		
		int rabbit = 6;
		boolean bunny = (rabbit >= 6) || (++rabbit <= 7);
		System.out.println(rabbit);
		
		int stripes = 7;
		System.out.print((stripes > 5) ? 21 : "Zebra");	//System.out.print() doesn't care that the expressions are completely different types, because it can convert both to Object values and call toString() on them.
		//int animal = (stripes < 9) ? 3 : "Horse";	Compiler detects that one value is string and can't be assigned to int
		
	
		
		
	}

}
