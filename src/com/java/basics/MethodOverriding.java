package com.java.basics;

import java.util.ArrayList;
import java.util.List;

/*
 * What if there is a method defined in both the parent and child classes with the same signature? For example, 
 * you may want to define a new version of the method and have it behave differently for that subclass. 
 * The solution is to override the method in the child class. In Java, overriding a method occurs when a subclass 
 * declares a new implementation for an inherited method with the same signature and compatible return type.
 * 
 * Works when the methods are public/protected. 
 * 
 * If we mark any method with final keyword it cannot be override in child classes. Will give compile error.
 */

/*
 * 1. Implement different behaviour in different classes
 * 2. Occurs in the two or more classes.
 * 3. Must have same argument list, same or more relaxed access modifiers, no exception or same exception/subclass exception, same or covariant return type
 * 4. Known as run-time or dynamic POLYMORPHISM. 
 * 5. Applied on only instance methods only. (no static no final)
 */

public class MethodOverriding {
	public static void main(String[] args) {

		//Example 2
		Camel c = new BactrianCamel();
		System.out.print("getNumberOfHumps() = " + c.getNumberOfHumps());
		
	}
}

// Example 1
class Bird {
	public void fly() {
		System.out.println("Bird is flying");
	}
	public void eat(int food) {
		System.out.println("Bird is eating "+food+" units of food");
	}
}
class Eagle extends Bird {
	public int fly(int height) {
		System.out.println("Bird is flying at "+height+" meters");
		return height;
	}
	public void  eat(int foods) { //replace void with int the code won't compile
		System.out.println("Bird is eating "+ foods +" units of food");
	}
}

//Example 2
class Camel {
	public int getNumberOfHumps() {
		return 1;
	}
}
class BactrianCamel extends Camel {
	//private int getNumberOfHumps() { public in parent and private in subclass won't compile
	public int getNumberOfHumps() { 
		return 2;
	}
}

//Example 3
class Rhino {
	protected CharSequence getName() {
		return "rhino";
	}
	protected String getColor() {
		return "grey, black, or white";
	}
}
class JavanRhino extends Rhino {
	public String getName() {
		return "javan rhino";
	}
	//public CharSequence getColor() 
	public String getColor() {
		return "grey";
	}
}

//Example 4 : Both of these examples fail to compile because of type erasure.You can't override generic methods
class LongTailAnimal {
	protected void chew(List<Object> input) {}
}
class Anteater extends LongTailAnimal {
	//protected void chew(List<Double> input) {} 
	protected void chew(List<Object> input) {} 
}

//Example 5
/*
 * The Monkey class compiles because ArrayList is a subtype of List. The play()
 * method in the Goat class does not compile, though. For the return types to be
 * covariant, the generic type parameter must match. Even though String is a
 * subtype of CharSequence, it does not exactly match the generic type defined
 * in the Mammal1 class. Therefore, this is considered an invalid override.
 */

class Mammal1 {
	public List<CharSequence> play() {
		return new ArrayList<CharSequence>();
	}
	public CharSequence sleep() {
		return "abcdefgh";	
	}
}

class Monkey extends Mammal1 {
	public ArrayList<CharSequence> play() {
		return new ArrayList<>();
	}
}

class Goat extends Mammal1 {
	//public List<String> play() {}
	public List<CharSequence> play() {
		return new ArrayList<>();
	}
	public String sleep() {
		return "xyz";
	}
}

//Example 5
/*
 * you can’t override private methods since they are not inherited. Just because
 * a child class doesn’t have access to the parent method doesn’t mean the child
 * class can’t define its own version of the method.
 */
class Camel1 {
	private String getNumberOfHumps() {
		return "Undefined";
	}
}
class DromedaryCamel extends Camel1 {
	private int getNumberOfHumps() {
		return 1;
	}
}
