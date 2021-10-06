package collectionconcepts;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList1 {

	public static void main(String[] args) {

		LinkedList<String> linkList = new LinkedList<>();
		linkList.add("C++");
		linkList.add("Python");
		linkList.add("RUby");
		linkList.add("RUby");

		linkList.add(1, "Java");
		//linkList.add(5, "SQL");			//IndexOutOFBoundException if index is not sequential
		linkList.addFirst("Golang");
		linkList.add(2, "MangoDB");
		linkList.add(4, "MangoDB");
		linkList.add("MangoDB");
		linkList.add("MangoDB");	
		linkList.add("MangoDB");	
		linkList.add("MangoDB");	
		
		System.out.println("Original LinkedList : ");
		Iterator<String> iterator = linkList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		linkList.remove("MangoDB"); 
		linkList.remove();			// First element of list
		linkList.remove(1);
		linkList.removeFirst();
		linkList.removeLast();
		
		System.out.println("Updated LinkedList : " + linkList);
		
		linkList.removeFirstOccurrence("MangoDB");
		linkList.removeLastOccurrence("RUby");
		
		System.out.println("Updated LinkedList : " + linkList);
		
		System.out.println("Reversed LinkedList : ");
		Iterator iterator1 = linkList.descendingIterator();
		while (iterator1.hasNext()) {
			System.out.println(iterator1.next());			
		}
	}
}
