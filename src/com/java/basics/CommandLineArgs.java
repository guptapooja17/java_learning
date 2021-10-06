package com.java.basics;

/*
 *  public final/static/abstract/synchronized void nap(int minutes) throws InterruptedException { }
 *  final/static/abstract/synchronized and throws InterruptedException are optional
 */

/*
 * public : Any object in any package can see the variable/methods.
 * protected : Any object defined in the same package or a subclass (defined in any package) can see variables/methods.
 * Default or package private : Only objects whose classes are defined in the same package can see variables/methods
 * private : Only the class containing the variables/methods can see those.
 */


/* String[] args
 * String args[]
 * String... args
 * All three are same way to declare array
 */

/* 
 * A varargs parameter must be the last element in a method’s parameter list. This means you are allowed to have only one varargs parameter per method.
 * public void walk1(int... nums) {}
 * public void walk2(int start, int... nums) {}
 * public void walk3(int... nums, int start) {} // DOES NOT COMPILE
 * public void walk4(int... start, int... nums) {} // DOES NOT COMPILE
 */

public class CommandLineArgs {

	public static void main (String[] args) {

		System.out.println("Argument 0 = " + args[0]);
		System.out.println("Argument 1 = " + args[1]);
	}
}

// arguments set-1 {PoojaGupta Aryan,poonam}

// arguments set-2 {"San Diego" Zoo}

/* If not provided enough argumenets - Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:
Index 1 out of bounds for length 1*/