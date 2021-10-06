package com.java.basics;

/*
 * An interface is an abstract data type are that declares a list of abstract methods that any class implementing the interface must provide.
 * An interface can also include constant variables. 
 * Both abstract methods and constant variables included with an interface are implicitly assumed to be public.
 * by default variables are public static final and methods are public abstract
 * interface can have public or default package-private access modifiers.
 * Since java 8 can have static and default methods.
 */

/* An interface can be inherited in one of three ways.
	■ An interface can extend another interface.									interface1 extends interface2, interface3, ...
	■ A class can implement an interface.											class1 implements interface2, interface3, ...
	■ A class can extend another class whose ancestor implements an interface.		class1 extends class2
 */
public class ProgramofInterface {
	public static void main(String[] args) {
		Canine refCanine = new Wolf();	
		
		/* Because of polymorphism, Java cannot be sure which specific class type the canine instance on line 24/25 is. 
		 * Therefore, it allows the invalid cast to the Dog reference type, eventhough Dog and Wolf are not related. 
		 * The code compiles but throws a ClassCastException at runtime.
		 */
		//refCanine = (Dog)refCanine;
		if (refCanine instanceof Dog)
			System.out.println("Instance of Canine Interface");	
		else {
			System.out.println("Not the instance of Dog class");
		}
	}
}

//Example 1 : Duplicate methods eatPlants() and method eatPlants() with different arg list assumed like method overloading
interface Herbivore {
	public void eatPlants();
}

interface Omnivore {
	public void eatPlants();
	public void eatPlants(int a);
	public void eatMeat();
}

class ImplementInterface implements Herbivore, Omnivore {
	public void eatPlants() {
		System.out.println("Problem resolved of duplicate methods in interface");
	}
	public void eatPlants(int a) {
		System.out.println("Considered as Method overloading");
	}	
	public void eatMeat() {
		System.out.println("eatMeal() implementation");
	}
}

//Example 2 Methods have same signature but different return type, no comes under the rule of overloading, exception will thrown
interface LongEars {
	int softSkin();
}

interface LongNose {
	void softSkin();
}
//The return types are incompatible for the inherited methods LongEars.softSkin(), LongNose.softSkin()
//interface Donkey extends LongEars, LongNose {} 
//abstract class Aardvark implements LongEars, LongNose {}

//Example 3 : casting Interface
interface Canine {}
class Dog implements Canine {}
class Wolf implements Canine {}
