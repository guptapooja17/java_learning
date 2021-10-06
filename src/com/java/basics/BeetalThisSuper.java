package com.java.basics;

//this can be used to access parent and subclass variable whereas super is used for parent only.

class Insect {
	
	protected int numberOfLegs = 4; 
	String label = "buggy";
}

public class BeetalThisSuper extends Insect{

	protected int numberOfLegs = 6;
	short age = 3;
	
	public void printData() {
		System.out.println(this.label);
		System.out.println(super.label);
		System.out.println(this.age);
		//System.out.print(super.age);
		System.out.println(numberOfLegs);
	}
	
	public static void main(String []n) {
		new BeetalThisSuper().printData();
	}

}


