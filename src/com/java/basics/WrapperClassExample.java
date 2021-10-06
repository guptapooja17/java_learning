package com.java.basics;

import java.util.ArrayList;
import java.util.List;

//The automatic conversion of primitive data types into its equivalent Wrapper type is known as boxing and opposite operation is known as unboxing.

public class WrapperClassExample {
	
	public static void main(String[] args) {
		
		 // parseInt is to get primitive
        // valueOf is to get the wrapper class object
		
		 int primitiveInt = Integer.parseInt("123");
	     Integer wrapperInt = Integer.valueOf("232");
	     System.out.println(primitiveInt);
	     System.out.println(wrapperInt);
	     
	     List<Integer> l = new ArrayList<>();
	     l.add(null);
	     //int a = l.get(0);	compile but give NPE at runtime. Unboxing a null give NPE.
	     
	     //Integer i1=new Integer(a); 		The constructor Integer(int) is deprecated since version 9 instead use ValueOf()  
	     //Float float1 = new Float(3.0f); 	The constructor Float(float) is deprecated since version 9
	     
	     Integer i1 = Integer.valueOf(20);
	     Integer a3 =5;	//Boxing  
	     System.out.println("i1 = " + i1 + "\t" + "a3 = " + a3);

	     int unbox = a3;
	     System.out.println(unbox);
	     
	     if (i1 < 25)
	    	 System.out.println("Unboxing done internally");
	}

}
