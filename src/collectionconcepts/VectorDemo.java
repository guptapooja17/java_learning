package collectionconcepts;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
	
	public static void main(String[] args) {
		Vector<String> vector1 = new Vector<>();
		vector1.add("C++");
		vector1.add("Python");
		vector1.add("RUby");
		vector1.add("RUby");

		System.out.println("Vector Capacity : " + vector1.capacity());
		System.out.println("does vector has RUby : " + vector1.contains("RUby") );
		System.out.println("Index of Python : " + vector1.indexOf("Python"));
		System.out.println("get element at index : " + vector1.get(1));
		System.out.println("set Go at index 2 : " + vector1.set(2, "GO"));
		
		//In iterator you can traverse the collection as well as modify it. Whereas, in enumeration you can only traverse over collections.
		//getting enumeration object over collection
		Enumeration<String> enumeration = Collections.enumeration(vector1);
		System.out.println("Print elements using enumeration : ");
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
			
		}
	}	
}
