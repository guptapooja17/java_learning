package com.programOfJava;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyAbstractCollection extends AbstractCollection<String>{

	List<String> lStrings = new ArrayList<>();

	@Override
	public Iterator<String> iterator() {
		ListIterator<String> iterator = lStrings.listIterator();

		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		while(iterator.hasPrevious()) {
			System.out.println(iterator.previous());
		}
		return null;
	}

	@Override
	public boolean add(String e) {
		lStrings.add(e + "test");
		return true;
	}

	@Override
	public boolean remove(Object e) {
		lStrings.remove(e + "test");
		return true;
	}
	
	@Override
	public int size() {
		return lStrings.size();
	}
	
	public static void main(String[] args) {
		MyAbstractCollection abstractCollection = new MyAbstractCollection();
		abstractCollection.add("A");
		abstractCollection.add("D");
		abstractCollection.add("E");
		abstractCollection.add("B");
		abstractCollection.add("C");
		
		System.out.println(abstractCollection.size());
		
		System.out.println(abstractCollection.remove("D"));
		
		System.out.println(abstractCollection.iterator());
			
	}
}
