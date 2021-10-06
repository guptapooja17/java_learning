package com.java.basics;

/* Launch Single-File Source-Code Programs, is one of the new features introduced in the JDK 11 release. 
 * This feature allows you to execute a Java source code file directly using the java interpreter. 
 * The source code is compiled in memory and then executed by the interpreter, without producing a .class file on disk.
 */

// However, this feature is limited to code that resides in a single source file. You cannot add additional source files to be compiled in the same run.

/* To work around this limitation, all the classes have to be defined in the same file, but there are no restrictions on the number of classes in the file,
 * and either they are all public classes or not it doesn’t matter as long as they are in the same source file.
 */

/* The first class declared in the source file will be picked up to be used as the main class, 
 * and we should put our main method inside that first class. So the order matter.
 */

// Even if the code compiles properly, no .class file is created 

//Can import code in any available Java library using javac. However, Can only import code that came with the JDK using java single source code feature.

//it is an in-memory compilation process.

public class SingleFileSourceCodeProgram {
	
	public static void main(String[] args) {
		
		System.out.println("Single file: " + args[0]);
		
	}
}
