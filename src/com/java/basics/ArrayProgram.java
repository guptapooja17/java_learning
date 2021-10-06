package com.java.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayProgram {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/* 
		 * Without a dimension or array elements, a compiler error is thrown
		 * Variable must provide either dimension expressions or an array initializer
		 */

		int[] numbers1 = new int[3];
		int[] numbers2 = new int[] {42, 55, 99};
		int[] numbers3 = {42, 55, 99};

		/* All Valid
		 * int[] numAnimals
		 * int [] numAnimals2;
		 * int []numAnimals3;
		 * int numAnimals4[];
		 * int numAnimals5 [];
		 */

		//int[] arr2d[] = new int[][]; 	Invalid has to give dimension or initialize it
		//int[] arr2d[] = new int[][5];
		int[] arr2d[] = new int[5][];

		//We can call equals() because an array is an object. It returns true because of reference equality. The equals() method on arrays does not look at the elements of the array.
		String [] bugs = { "cricket", "beetle", "ladybug" };
		String [] alias = bugs;
		System.out.println(bugs.equals(alias));	//

		// if no type declared with a var refernece will set the arraylist type to Object

		var arrList1 = new ArrayList<>();
		arrList1.add("20");
		//for( String ele: arrList1 )  can't covert from object to string
		for( Object ele: arrList1 ) 
			System.out.println(ele);

		// If no generics are provided in the arraylist, then we can add any type of object into it. Just the primitives are not allowed.

		ArrayList arrlst = new ArrayList<>();
		arrlst.add("Value");
		arrlst.add(Boolean.TRUE);
		System.out.println(arrlst);

		// we can't add to a list far into the index sequence

		List<String> birds = new ArrayList<String>();
		birds.add("hawk");
		birds.add(1, "robin");
		birds.add(1, "blue jay");
		birds.add(3, "cardinal");
		//birds.add(8, "cardinal");	throws runtime error, we can't add to a list far into the index sequence, IndexOutOfBoundsException
		System.out.println(birds);

		// Array to List using Arrays.asList create a fixed size backed list
		// any changes made to array or list will be reflected at both the places
		// If we try to remove/add the element from the array or the List then UnsupportedOperationException will be thrown.
		String[] array = { "hawk", "robin" };
		List<String> lst = Arrays.asList(array);
		lst.set(0, "blue jay");
		System.out.println(lst);
		array[1] = "new";
		System.out.println(lst);
		// lst.remove(1);           UnsupportedOperationException
		//lst.add("Cannot add");	UnsupportedOperationException
		lst.set(1, "Can change apply to array");

		// Creating immutable List using List.of(arr)
		// We cannot change the size or the elements in such a list, unlike Arrays.asList
		List<String> immlst = List.of(array);
		System.out.println("List.of method " + immlst);
		array[0] = "Test";
		System.out.println(Arrays.toString(array));
		// immlst.set(0, "Change"); 	 UnsupportedOperationException
		// immlst.remove(1);  			 UnsupportedOperationException
		// immlst.add("Cannot add");	 UnsupportedOperationException

		//Covert list to array
		List<String> list = new ArrayList<>();
		list.add("hawk");
		list.add("robin");
		Object[] objectArray = list.toArray();

		int[] numbers = {2,4,6,8};
		System.out.println(Arrays.binarySearch(numbers, 2)); // 0
		System.out.println(Arrays.binarySearch(numbers, 4)); // 1
		System.out.println(Arrays.binarySearch(numbers, 1)); // -1
		System.out.println(Arrays.binarySearch(numbers, 3)); // -2
		System.out.println(Arrays.binarySearch(numbers, 9)); // -5

		List<Integer> numbers11 = new ArrayList<>();
		numbers11.add(99);
		numbers11.add(5);
		numbers11.add(81);
		Collections.sort(numbers11);
		System.out.println(numbers11);

		var list1 = new ArrayList<>();
		list.add("a");
		//for (String s: list1) { }  DOES NOT COMPILE by default var is of object type if not defined any type 

		System.out.println("_______________________________________");

		/*
		 * Method 			When arrays are the same 			When arrays are different
		 * equals() 		true 								false
		 * compare() 		0 									Positive or negative number
		 * mismatch() 		-1 									Zero or positive index
		 */

		/*
		 * If both arrays are the same length and have the same values in each spot in the same order, return zero. 
		 * If all the elements are the same but the second array has extra elements at the end, return a negative number. 
		 * If all the elements are the same but the first array has extra elements at the end, return a positive number.
		 * If the first element that differs is smaller in the first array, return a negative number.
		 * If the first element that differs is larger in the first array, return a positive number.
		 */

		//null is smaller than any other value.

		// A null array reference is considered lexicographically less than a non-null array reference.

		System.out.println( java.util.Arrays.compare(new int [] {10}, null) ); // 1

		int[] a1 = null;
		int[] a2 = null;
		int[] a3 = {1};

		//Check how the compare method is implemented into java
		System.out.println("compare() = " + java.util.Arrays.compare(a1, a2) ); 		// 0
		System.out.println("compare() = " + java.util.Arrays.compare(null, a1) );		// 0
		System.out.println("compare() = " + java.util.Arrays.compare(null, a3) ); 		// -1

		/*
		 * System.out.println("mismatch() = " + java.util.Arrays.mismatch(a1, a2) ); 
		 * Can't mismatch on the null array reference, internally checking for null
		 * int length = Math.min(a.length, b.length); // Check null array refs		
		 */

		char [] arr1 = {'A', 'A'};
		char [] arr2 = {'A', 'A', 'A', 'A'};
		char [] arr3 = {};
		System.out.println("compare() = " + Arrays.compare(arr1, arr2)); // -2
		System.out.println("mismatch() = " +Arrays.mismatch(arr1, arr2)); // 2
		System.out.println("mismatch() = " +Arrays.mismatch(arr3, arr1)); // 2

		// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 10
		char [] carr1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'i', 'j', 'k'};
		char [] carr2 = {'f', 'g', 'a', 'i', 'k'};
		System.out.println("mismatch() with start and end index = " + Arrays.mismatch(carr1, 5, 9, carr2, 0, 4));

		String [] str1 = {"A", "AA", "ABCD"};
		String [] str2 = {"A", "AA", "ABCB"};
		System.out.println(Arrays.mismatch(str1, str2)); 	// 2
		System.out.println(Arrays.compare(str1, str2)); 	// 2
		System.out.println(Arrays.compare(str2, str1)); 	// -2
		System.out.println("ABCD".compareTo("ABCB")); 		// 2
		// System.out.println("ABCD".compareTo(null)); // NullPointerException

		int elements = 0;
		Object [] objArr = {"A", "E", "I", new Object(), "O", "U"}; //Line n1
		for(var obj : objArr) { 
			elements++; 
			if(obj instanceof String) {
				continue;
			} else {
				break;
			}
		}
		System.out.println(elements); 
	}  

}
