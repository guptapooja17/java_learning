package com.java.basics;

// this() and this used to access constructors and instance/static variables within the same class.
// super() and super is used to call parent class constructor and instance/static variables. 
// this() and super() should be the first statement in the constructor.

//Parent - static initializer / static variables then Subclass - static initializer / static variables
//parent - Instance initializer / instance variables 
//subclass -Instance initializer / instance variables

class ParentStaticInitialization {

	static {
		System.out.println( "A. Parent Static Initialization Block");		
	}

	{
		System.out.println( "B. Parent Normal Initialization Block" );		
	}

	public ParentStaticInitialization (String name) {						
		this(1);										
		System.out.println( "C. Parent String Argument Constructor");		
	}

	public ParentStaticInitialization() {
		System.out.println( "D. Parent No Argument Constructor");
	}

	public ParentStaticInitialization( int n ) {							
		System.out.println( "E. Parent Int Argument Constructor");
	}

}

public class StaticInitializer extends ParentStaticInitialization {

	static {					
		System.out.println( "F. Child Static Initialization Block");	
	}

	public StaticInitializer(int n) {									
		super("sugar");				
		System.out.println( "G. Child int Argument Constructor");		
	}

	public static void main(String[] args) {
		new StaticInitializer(1);
		System.out.println();
		new StaticInitializer(2);
	}

	{
		System.out.println( "H. Child Normal Initialization Block");	
	}
}