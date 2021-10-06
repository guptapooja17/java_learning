package com.java.basics;

public class FinalProgram1{

	int value = 1;
	FinalProgram1 link;
	
	public FinalProgram1(int val) { 
		this.value = val; 
	}
	
	public static FinalProgram1 setIt(final FinalProgram1 x, final FinalProgram1 y){
		x.link = y.link;
		return x;
	}

	public static void main(String[] args){
		final var a = new FinalProgram1(5);
		var b = new FinalProgram1(10);
		//a = b; 	can't change the reference now due to final but can change value inside it.
		//a.value = 25; This is allowed 
		a.link = b;
		b.link = setIt(a, b);
		System.out.println(a.value + " " + b.value);
		System.out.println(a.link + " " + b.link);
	}

}