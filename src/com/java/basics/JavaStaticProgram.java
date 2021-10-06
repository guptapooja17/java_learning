package com.java.basics;

import java.util.ArrayList;

public class JavaStaticProgram extends ParentJavStatic{

	static {
		System.out.println("Static block in Main Class");
	}

	static String staticVariable = "Static Variable";

	static void staticMethod(){
		System.out.println("Static Method");
	}

	private static final ArrayList<String> arrLst = new ArrayList<String>();

	// 3. -------------START -------------------
	// Static final variables needs to be initialized before calling main method and once initialized it's can't be changed further.

	private static final String leftRope;
	private static final String rightRope;
	private static final String name = "name";

	static {
		leftRope = "left";
		rightRope = "right";
	}

	static {
		//    name = "name";
		//    rightRope = "right";
	}
	// 3. --------------END---------------------

	public static void main(String[] args) {

		// Static member can also be accessed using the reference and even just the reference, i.e. even if we set it to null
		System.out.println( "---------------------1----------------------" );
		JavaStaticProgram js = new JavaStaticProgram();
		System.out.println( js.staticVariable );
		js.staticMethod();

		js = null;
		System.out.println( js.staticVariable );
		js.staticMethod();
		System.out.println( "----------------------1----------------------" );

		// 2.
		// We cannot reinitialise the final members, but we can updated them
		arrLst.add("Value");

		// 3.
		// Compiler errors count - 4
		// bench = "4";

		// 4.  
		// Static blocks are called when we load the class by either
		// - if the main method is in same class then when program starts
		// - doing a new
		// - accessing a static member 
		System.out.println( "\n\n---------------------4----------------------" );
		System.out.println( JavaStatic2.val );
		System.out.println( "-------------------------4----------------------" );

		// 5.
		// Normal initializer blocks are called when we load the class by new
		System.out.println( "\n\n---------------------5----------------------" );
		JavaStatic3 js3 = new JavaStatic3();
		JavaStatic3 js4 = new JavaStatic3();
		System.out.println( "-------------------------5----------------------" );

	}

}

// 6.
// Static variables can't be accessed before they are defined

class JavaInit {

	private static String varBeforeStaticBlock = " Variable before static block"; 
	static {
		System.out.println( varBeforeStaticBlock );
		// (Cannot reference a field before it is defined)
		// System.out.println( varAfterStaticBlock );
	}
	private static String varAfterStaticBlock = " Variable after static block";
}



//7.
//In inheritance, the static block in parent will be 
//initialized first and then the child
//No matter if we have invoked the child's static variable first

class ParentJavStatic {
	static String parentVar = JavaStaticProgram.staticVariable;
	static {
		System.out.println( "Static block in Parent");
	}
}

class JavaStatic2 {
	static String val = "Hu!!";
	static {
		System.out.println("Static initializer block in JavaStatic2");
	}
}

class JavaStatic3 {
	{
		System.out.println("Normal initializer block in JavaStatic3");
	}
}