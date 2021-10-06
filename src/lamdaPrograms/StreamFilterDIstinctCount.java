package lamdaPrograms;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamFilterDIstinctCount {
	
	public static void main(String[] args) {

		Person p1 = new Person("John");
		Person p2 = new Person("Jane");
		Person p3 = new Person("Jane");
		Person p4 = new Person("Mark");

		Stream<Person> stream = Stream.of(p1, p2, p3, p4);
		long count = stream.filter(p -> p.name.startsWith("J")).distinct().count();
		System.out.println(count);
		
		List<Person> list = Arrays.asList(p1,p1,p3,p4);
		Stream<Person> stream2 = list.stream();
		list.sort((person1,person2) -> person1.getName().compareTo(person2.getName()));
		long count1 = stream2.filter(p -> p.name.startsWith("J")).distinct().count();
		System.out.println(count1);

	}
}

class Person {
	String name;

	Person( String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
}
