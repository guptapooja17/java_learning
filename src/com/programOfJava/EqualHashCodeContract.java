package com.programOfJava;

public class EqualHashCodeContract {

	public static void main(String[] args) {
		Student s1 = new Student(1, "Pooja");
		Student s2 = new Student(2, "Poonam");
		Student s3 = new Student(1, "Pooja");
		System.out.println(s1.equals(s3));	
		System.out.println(s1.hashCode());
		System.out.println(s3.hashCode());
	}
}

class Student {

	int id;
	String nameString;

	public Student(int id, String nameString) {
		super();
		this.id = id;
		this.nameString = nameString;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	/* 
	 * If two objects are equal then their hashcode has to be same. This is a contract between hashcode() and equals() method.
	 * For this we have to implement hashcode() and equals() in order to check equality of two objects. 
	 * 
	 * if two objects are equal and their hashcode are not same. Not satisfying the contract.
	 * 
	 * if two objects have the same hashcode, they may or may not be equal.
	 */
	
	public boolean equals(Object s) {
		if (s == null)
			return false;
		if (s instanceof Student) {
			Student s1 = (Student) s;
			if (this.id == s1.id && this.nameString == s1.nameString) 
				return true;
		}
		return false;	
	}
	
	public int hashCode() {
		return this.id;
	}
}