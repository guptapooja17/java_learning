package com.java.basics;
/*
  An abstract class is a class that cannot be instantiated and may contain abstract methods. 
  An abstract method is a method that does not define an implementation when it is declared. 
  Both abstract classes and abstract methods are denoted with the abstract modifier.
  An abstract class is most commonly used when you want another class to inherit properties of a particular class, 
  but you want the subclass to fill in some of the implementation details.

  an abstract class can include all of the same members as a nonabstract class, including variables, static and instance methods, and inner classes.
  Abstract classes can also include constructors.

  Like the final modifier, the abstract modifier can be placed before or after the access modifier in class and method declarations.

  abstract public class Tiger /  public abstract class Tiger : both valid
  
  1. Abstract classes may include zero or more abstract and nonabstract methods.
  2. If you mark something abstract, you are intending for someone else to extend or implement it. But, if you mark something final ,
  	 you are preventing anyone from extending or implementing it. These concepts are in direct conflict with each other.
  3. All top-level types, including abstract classes, cannot be marked protected or private.
  4. A method cannot be marked as both abstract and private or final.
  5. A method cannot be marked as static as it can't be override in subclass.it follows that it also cannot be marked abstract 
  	 since it can never be implemented. 
 */

//public class ProgramOfAbstract extends Bird {} won't compile as has to provide implementation of abstract methods.
public class ProgramOfAbstract extends Bird1 {
	{
		System.out.println("ProgramOfAbstract Instance Initializer");
	}
	public String getName() { 
		return "Stork!"; 
	}

	public static void main(String[] args) {
		new ProgramOfAbstract().printName();
	}

}

abstract class Bird1 {
	protected abstract String getName();
	{
		System.out.println("Bird1 Instance Initializer");
	}

	public Bird1() {
		this(1);
		System.out.println("Abstract class constructor");
	}

	public Bird1(int a) {
		System.out.println("Argumented Abstract class constructor");
	}

	public void printName() {
		System.out.print(getName());
	}
}

/* 	Invalid declaration of methods
	public abstract long eat() // DOES NOT COMPILE
	public abstract void swim() {}; // DOES NOT COMPILE
	public abstract int getAge() { // DOES NOT COMPILE
		return 10;
	}
	public void sleep; // DOES NOT COMPILE
	public void goInShell();
 */