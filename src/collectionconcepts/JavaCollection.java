package collectionconcepts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class JavaCollection {
	
	public static void main(String[] args) {

		Collection<String> list  = new ArrayList<>();
		System.out.println(list.add("First")); // true
		System.out.println(list.add("Second")); // true 
		System.out.println(list.add("First")); // true

		// Set don't allow duplicate values, so if we add them, they will return a false.
		Collection<String> set = new HashSet<>();
		System.out.println(set.add("First")); // true
		System.out.println(set.add("Second")); // true 
		System.out.println(set.add("First")); // false
		System.out.println(set.contains("Second"));

		List<Integer> intlist = new ArrayList<>();
		System.out.println(intlist instanceof List); // true
		System.out.println(intlist instanceof List<?>); // true
		//System.out.println(intlist instanceof List<>);           // Incorrect number of arguments for type List<E>; it cannot be parameterized with arguments <>
		//System.out.println(intlist instanceof List<Integer>);    // Cannot perform instanceof check against parameterized type List<Integer>. 
		// Use the form List<?> instead since further generic type information will be erased at runtime
		// System.out.println(intlist instanceof List<Number>);     // Cannot perform instanceof check against parameterized type List<Number>. 
		// Use the form List<?> instead since further generic type information will be erased at runtime
		// System.out.println(intlist instanceof List<Object>);     // Cannot perform instanceof check against parameterized type List<Object>. 
		// Use the form List<?> instead since further generic type information will be erased at runtime

		// List can't be modified in a stream 
		List<Integer> input = List.of(1);
		List<Integer> list1 = new ArrayList<>(input);
		list1.stream().forEach(i -> list1.add(i + 1));
		System.out.println(list1);

	}
}
