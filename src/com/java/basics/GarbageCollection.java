package com.java.basics;

/*
 * Garbage collection refers to the process of automatically freeing memory on the heap by
 * deleting objects that are no longer reachable in your program.As a programmer, the most important thing you can do to limit out-of-memory problems 
 * is to make sure objects are eligible for garbage collection once they are no longer needed. It is the JVM’s responsibility to actually perform the garbage collection.
 */

/*
 * Java includes a built-in method to help support garbage collection that can be called at any time. 
 * It merely suggests that the JVM kick off garbage collection. The JVM may perform garbage collection 
 * at that moment, or it might be busy and choose not to. The JVM is free to ignore the request.
 * JVM will likely run it over time as available memory decreases, it is not guaranteed to ever actually run. 
 * In fact, shortly before a program runs out of memory and throws an OutOfMemoryError, the JVM will try to perform garbage collection, but it’s not guaranteed to succeed.
 */

// The object no longer has any references pointing to it.
// All references to the object have gone out of scope.

public class GarbageCollection {
	
	private GarbageCollection pandaBear;
	
	protected void finalize() {}
	
	private void roar(GarbageCollection b) {
		System.out.println("Roar!");
		pandaBear = b;
	}
	
	public static void main(String[] args) {
		GarbageCollection brownBear = new GarbageCollection();
		GarbageCollection polarBear = new GarbageCollection();
		brownBear.roar(polarBear);
		polarBear = null;
		brownBear = null;
		System.gc();
		} 
}

/* Java allows objects to implement a method called finalize(). it is deprecated in Object as of Java 9, with the 
 * official documentation stating, “The finalization mechanism is inherently problematic.”
 */
 