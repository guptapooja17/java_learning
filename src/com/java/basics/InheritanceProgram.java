package com.java.basics;

/*
 * Inheritance is the process by which a subclass automatically includes any public or protected members of the class, 
 * including primitives, objects, or methods, defined in the parent class.
 * 
 * In, the first of every constructor is either a call to another constructor within class, using this(), or a call to constructor
 * in parent class, using super().
 * 
 * Disabling inheritance then mark the class final, no class can extends final class
 */

/*
 * Reviewing Constructor Rules
 * 1. The first statement of every constructor is a call to an overloaded constructor via this() , or a direct parent constructor via super().
 * 2. If the first statement of a constructor is not a call to this() or super() , then the compiler will insert a no-argument super() 
 * 	  as the first statement of the constructor.
 * 3. Calling this() and super() after the first statement of a constructor results in a compiler error.
 * 4. If the parent class doesn’t have a no-argument constructor, then every constructor in the child class must start with an explicit this() 
 * 	  or super() constructor call.
 * 5. If the parent class doesn’t have a no-argument constructor and the child doesn’t define any constructors, then the child class will not compile.
 * 6. If a class only defines private constructors, then it cannot be extended by a top-level class.
 * 7. All final instance variables must be assigned a value exactly once by the end of the constructor. Any final instance variables not 
 * 	  assigned a value will be reported as a compiler error on the line the constructor is declared.
 */
class Chimpanzee {
	public Chimpanzee () {
		System.out.println("In Chimpanzee Contructor");
	}
}

class Apt extends Chimpanzee {
	public Apt(int a) {
		System.out.println("In Apt Argument Constructor");
	}
	public Apt() {
		System.out.println("In Apt No-Argument Constructor");
	}
}

public class InheritanceProgram extends Apt {
	public InheritanceProgram() {
		super(2);
		System.out.print("InheritanceProgram--");
	}
	public static void main(String[] args) {
		new InheritanceProgram();
	}
}


//Example 1
class Mammal {	
	public Mammal(int age) {}
}

//Won't compile, no-arg constructor insterted by compiler and super() no-arg constructor isn't defined. 
//class Elephant extends Mammal {}	

//Example 2
class MouseHouse {
	private final int volume;
	private final String type;
	{
		this.volume = 10;
	}
	public MouseHouse(String type) {
		this.type = type;
	}

	/*
	 * Won't compile due to one variable is not getting initialized and one is
	 * getting initialized twice 
	 * 
	 * public MouseHouse() { this.volume = 2; }
	 */
	public MouseHouse() {
		type = "ABC";
	}
}