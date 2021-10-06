package com.java.basics;

public class SingleSourceCodeProgramCompile {
	
	public static void main(String[] args) {
	
		//SingleSourceCodeProgram3.printMethod("Checking Compile Two Programs in different Files");
		
		String nameString = "Single file source code";
		System.out.println(nameString);		
	}
}


/* java /Users/pooja.gupta/eclipse-workspace/java11-learning/src/basics/SingleSourceCodeProgramCompile.java
 * /Users/pooja.gupta/eclipse-workspace/java11-learning/src/basics/SingleSourceCodeProgramCompile.java:7: error: cannot find symbol 
 * SingleSourceCodeProgram3.printMethod("Checking Compile Two Programs in diffenrent Files");
 * variable SingleSourceCodeProgram3 location: class
 * SingleSourceCodeProgramCompile 1 error error: compilation failed
 */

// if, I comment out line 7 then program compiles and run, because only allowed to run the program in a single file. 

/* If it finds any .class in the classpath with the same name of program you running through java command then java forces to use javac 
 * Error: Could not find or load main class .Users.pooja.gupta.eclipse-workspace.java11-learning.src.basics.SingleFileSourceCodeProgram2.java
 *
 * Caused by: java.lang.ClassNotFoundException: /Users/pooja/gupta/eclipse-workspace/java11-learning/src/basics/SingleFileSourceCodeProgram2/java
 */