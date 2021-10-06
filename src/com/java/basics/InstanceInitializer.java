package com.java.basics;

// Constructor: the name of the constructor matches the name of the class, and there's no return type. Compiler provides a default no-arg constructor if you haven't declared any.

// Code blocks appear outside a method, is called Instance Initializer. 

// code block appear with static keyword outside a method, is called Static Initializer.

/* Fields and instance initializer blocks are run in order in which they appear in the file.
 * The constructor runs after all fields and initializer blocks have run.
 * Instance initializer block calls everytime the object constructed.
 * Static Initializer block calls once per class.
 */

public class InstanceInitializer {
	
	public InstanceInitializer() {
		num = 5;
		System.out.println("Constructor call");
	}
	
	public static void main (String[] args) {
		
		InstanceInitializer initializer = new InstanceInitializer();
		System.out.println("Final value of num = " + initializer.num);
	}
	
	// Order matters for the fields and blocks of code. You can’t refer to a variable before it has been defined.
	/*
	 * { System.out.println("Name = " + name); }
	 * 
	 * String name = "Fluppy";
	 */
	private int num = 3;
	
	{
		System.out.println("Before calling Instance Initializer num = " + num);
		num = 4;
		System.out.println("Instance Initializer");
	}
	
}