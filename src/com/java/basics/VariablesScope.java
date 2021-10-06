package com.java.basics;

//Local Variables : in scope from declaration to end of block. Needs to be in initialized before use.

//Instance Variables : in scope from declaration until object garbage collected

//Class Variables : in scope from declaration until program ends

public class VariablesScope {
	
	Boolean boolean1;
	String nameString;
	static String staticVariableString ;
	
	public int notValid() {
		int y = 10; // if local variable has to be initialized before use, else will give compiler error. Has garbage value. Won't work int y;
		int x = 2; 
		int reply = x + y; 
		return reply;
	}
	
	public void findAnswer(boolean check) {
		int answer;
		int otherAnswer; // if won't give any error because we aren't using it in method. Just declared not used. 
		int onlyOneBranch;
		
		if (check) {
			onlyOneBranch = 1;
			answer = 1;
		} else {
			answer = 2; 
		}
		System.out.println(answer);
		//System.out.println(onlyOneBranch); DOES NOT COMPILE because not initialized 
	}
	
	// You cannot use a non-static variable under a static method. Can use in final method.
	//However, we can use static variables into non-static methods.

	public static void printerName() {
		//System.out.println(nameString); Cannot make a static reference to the non-static field nameString
		System.out.println("staticVariableString = " + staticVariableString);
	}
	
	
}
