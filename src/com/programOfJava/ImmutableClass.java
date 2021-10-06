package com.programOfJava;

import java.util.HashMap;
import java.util.Map;

/*
 * The class must be declared as final so that child classes can’t be created.
 * Data members in the class must be declared private so that direct access is not allowed.
 * Data members in the class must be declared as final so that we can’t change the value of it after object creation.
 * A parameterised constructor should initialise all the fields performing a deep copy so that data members can’t be modified with an object reference.
 * Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)
 */

public class ImmutableClass {
	public static void main(String[] args) {
		Map<String, String> dataMap = new HashMap<>();
		dataMap.put("1", "Math");
		dataMap.put("2", "Science");
		
		Student1 student1 = new Student1("Pooja", 101, dataMap);
		
		dataMap.put("3", "History");
		System.out.println(student1);
		
		student1.getData().put("4", "Algebra");
		System.out.println(student1);
		System.out.println("Map length : " + dataMap.size());
	}
}

final class Student1 {
	
	private final String nameString;
	private final int rollNo;
	private final Map<String, String> data;
	
	public Student1(String nameString, int rollNo, Map<String, String> data) {
		super();
		this.nameString = nameString;
		this.rollNo = rollNo;
		
		Map<String, String> tempMap = new HashMap<>();
		for (Map.Entry<String, String> entry : data.entrySet() ) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		this.data = tempMap;
	}

	public String getNameString() {
		return nameString;
	}

	public int getRollNo() {
		return rollNo;
	}

	public Map<String, String> getData() {
		Map<String, String> tempMap = new HashMap<>();
		for (Map.Entry<String, String> entry : this.data.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		return tempMap;
	}

	@Override
	public String toString() {
		return "Student1 [nameString=" + nameString + ", rollNo=" + rollNo + ", data=" + data + "]";
	}
}
