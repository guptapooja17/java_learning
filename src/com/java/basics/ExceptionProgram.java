package com.java.basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * A checked exception is an exception that must be declared or handled by the application code where it is thrown. 
 * In Java, checked exceptions all inherit Exception but not RuntimeException.
 * 
 * An unchecked exception is any exception that does not need to be declared or handled by the application code where it is thrown.
 * Unchecked exceptions are often referred to as runtime exceptions, although in Java, unchecked exceptions include any class that 
 * inherits RuntimeException or Error.
 * 
 * Type 					How to recognize					Okay for program to catch? 		Is program required to handle or declare?
 * Runtime exception		Subclass of RuntimeException 		Yes 							No
 * Checked exception        Subclass of Exception				Yes 							Yes
 * Error 					Subclass of Error 					No 								No
 * 
 * try block needs catch or finally or both to work. A rule exists for the order of the catch blocks. Java looks at them in the order they appear. 
 * If it is impossible for one of the catch blocks to be executed, a compiler error about unreachable code occurs.
 * NumberFormatException is a subclass of IllegalArgumentException.
 * 
 * If we place try-catch around methods that won't throw checked exception, a compile time error will be thrown.
 */

public class ExceptionProgram {

	class Sidekick implements AutoCloseable {
		protected String n;
		public Sidekick(String n) { 
			this.n = n;
		}
		public void close() { 
			System.out.print("L"); 
		}
	}
	public void requiresAssistance() {
		try (Sidekick is = new Sidekick("Adeline")) {
			System.out.print("O");
		} finally {
			System.out.print("K");
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

		new ExceptionProgram().requiresAssistance();
		System.out.println("I Finished AutoCloseable program");

		/*
		//catch(Exception1 e | Exception2 e | Exception3 e) 
		//catch(Exception1 e1 | Exception2 e2 | Exception3 e3)
		try {
			System.out.println(Integer.parseInt(args[1]));
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("Missing or invalid input");
		}

		// try with resources can replace finally. They help to close the resources that were declared in try
		try ( FileInputStream fi = new FileInputStream("Exceptions.txt") ) {
			System.out.println("File Opened");
		} catch ( IOException e ) {
			e.printStackTrace();
		}

		// Catch block is optional with try with resources
		try ( FileInputStream fi = new FileInputStream("Exceptions.txt") ) {
			System.out.println("File Opened");
		}

		//Example 1
		System.out.print("a");
		try {
			System.out.print("b");
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			System.out.print("c");
			throw new RuntimeException("1");
		} catch (RuntimeException e) {
			System.out.print("d");
			throw new RuntimeException("2");
		} finally {
			System.out.print("e");
			throw new RuntimeException("Finally block 3");
		}
		 */	
	}
}


