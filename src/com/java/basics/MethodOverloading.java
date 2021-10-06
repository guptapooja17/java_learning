package com.java.basics;

/*
 * Method overloading occurs when methods have the same name but different method signatures, which means they differ by method parameters and their order.
 */

/*
 * Rule 								Example of what will be chosen for glide(1,2)
 * Exact match by type 					String glide(int i, int j)
 * Larger primitive type 				String glide(long i, long j)
 * Autoboxed type 						String glide(Integer i, Integer j)
 * Varargs 								String glide(int... nums)
 */

/*
 * 1. Functionality reused 
 * 2. Occurs in the single class, may occur in the child classes
 * 3. Must have different no. arguments and thier types and different order of arguments 
 * 4. May have different return types, access modifiers, exceptions
 * 5. Known as compile-time or static POLYMORPHISM. 
 * 6. Applied on static or non-static methods.
 */

public class MethodOverloading {
	
	
	// Duplicate method overloading
	//public void fly( int[] members ) {}
    //public void fly( int... members ) {}
	
	// no respect to generics
    // public void fly( List<Integer> lst) {}	compiles  as public void fly(List strings) {}
    // public void fly( List<String> lst) {}	compiles  as public void fly(List integers) {}

	public void fly() {}
    public void fly( int numOfMiles) {}
    public boolean fly( boolean fly ) { return false; } 
    public void fly( int numMiles, short numFeet){}
    public void fly(short numMiles, int numFeet ) throws Exception {}
    
    
    public void called( int arg ) {
        System.out.println("Called primitive parameter method");
    }
    public void called( Integer arg ) {
        System.out.println("Called wrapper class parameter method");
    }
    
    
    
    public void referenceType( String arg ) {
        System.out.println("String");
    }
    public void referenceType( Object arg ) {
        System.out.println("Object");
    }
    
    
    
    public void primitiveType( short arg ) {
        System.out.println("Short");
    }
    public void primitiveType( int arg ) {
        System.out.println("int");
    }
    public void primitiveType( long arg ) {
        System.out.println("long");
    }
    public void primitiveType( Integer arg ) {
        System.out.println("Integer");
    }
    
    
	/*
	 * public void diffPrimitive( Long[] arg) { System.out.println("long"); }
	 */

    public void diffPrimitive( Long arg) { 
    	System.out.println("Long"); 
    }
    public void diffPrimitive( Long... arg ) {
        System.out.println("Long varargs");
    }
    
    
    public static void main(String[] args) {
		
    	MethodOverloading objMethodOverloading  = new MethodOverloading();
    	objMethodOverloading.called(2);
    	objMethodOverloading.called(Integer.valueOf(20));
    	
    	new MethodOverloading().referenceType("arg");
        new MethodOverloading().referenceType(3);
        
        
        new MethodOverloading().primitiveType(1); 
        new MethodOverloading().primitiveType(400); 
        new MethodOverloading().primitiveType(1L); 
        new MethodOverloading().primitiveType(4444444444444444444L); 
        new MethodOverloading().primitiveType(Integer.valueOf(1)); 
        
        new MethodOverloading().diffPrimitive(new Long[] {3L, 2L, 6L, 4L});
        new MethodOverloading().diffPrimitive(10L);
        //new MethodOverloading().diffPrimitive(new Long[] {2, 3, 4});
	}
    
}
