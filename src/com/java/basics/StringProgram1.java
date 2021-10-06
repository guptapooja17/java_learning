package com.java.basics;

/*
 * The StringBuilder class creates a String without storing all those interim String values.
 * charAt(), indexOf(), length(), substring() works like String 
 * append(), insert(), delete() / deleteCharAt(), reverse(), toString(), replace()
 */

public class StringProgram1 {

	public static void main(String[] args) {

		System.out.println(("Hello" == "Hello".trim()) ? true : false);	// strings are same but trim() calculated at runtime. Since it's not same as compile time a new string is created

		String s1 = "Hello!!!";
		s1.concat("HI");		//need to store the reference
		System.out.println(s1);
		s1 = s1.concat("HI");
		System.out.println(s1);


		String soutString = new String("Hello!!!");
		soutString.concat("HI");	//need to store the reference
		System.out.println(soutString);
		soutString = soutString.concat("HI");
		System.out.println(soutString);


		StringBuilder sBuilder = new StringBuilder("Hello!!!");
		sBuilder.append("HI");
		System.out.println(sBuilder);

		//		System.out.println(s1 == sBuilder);	//Incompatible operand types String and StringBuilder
	
		System.out.println(sBuilder.insert(5, "---"));	
		
		StringBuilder sb = new StringBuilder("abcdef");
		sb.delete(1, 3); 		// sb = adef
		sb.deleteCharAt(4);		// throws an exception as character is deleted
		
		StringBuilder builder = new StringBuilder("pigeon dirty");
		builder.replace(3, 6, "sty");
		System.out.println(builder); // pigsty dirty
		
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		Tiger t3 = t1;
		System.out.println(t1 == t3); 		// true
		System.out.println(t1 == t2); 		// false
		System.out.println(t1.equals(t2));	// false, class has to implement equals methods to compare two class objects
	}
}


class Tiger {
	String name;
} 
