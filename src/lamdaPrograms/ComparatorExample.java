package lamdaPrograms;

import java.util.Comparator;

public class ComparatorExample {
	public static void main(String[] args) {
		Employee emp1 = new Employee("Pooja", 700000),
				emp2 = new Employee("Kunal", 10000000),
				emp4 = new Employee("Poonam", 500000);

		Comparator<Employee> byname = new Comparator<Employee>() {
			@Override
			public int compare(Employee a, Employee b) {
				return a.getName().compareTo(b.getName());
			}
		};

		System.out.println("Byname Comparing Comparator " + byname.compare(emp1, emp2));
		System.out.println("______________________________________________");

		try {
			System.out.println(byname.compare(emp1, null));
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		System.out.println("______________________________________________");

		/*
		 * null to be less than non-null. When both are null, they are considered equal. 
		 * If both are non-null, the specified Comparator is used to determine the order. If the specified comparator is null, 
		 * then the returned comparator considers all non-null values to be equal.
		 */
		Comparator<Employee> bynullComparator1 = Comparator.nullsFirst(byname);
		System.out.println("nullFirst " + bynullComparator1.compare(emp1, emp2));
		System.out.println("nullFirst " + bynullComparator1.compare(null, emp2));
		System.out.println("______________________________________________");

		/*
		 * Returns a null-friendly comparator that considers null to be greater than non-null. When both are null, they are considered equal. 
		 * If both are non-null, the specified Comparator is used to determine the order. If the specified comparator is null, 
		 * then the returned comparator considers all non-null values to be equal.
		 */
		Comparator<Employee> bynullComparator2 = Comparator.nullsLast(byname);
		System.out.println("nullLast " + bynullComparator2.compare(emp1, emp2));
		System.out.println("nullLast " + bynullComparator2.compare(null, emp2));
		System.out.println("______________________________________________");

		Comparator<Employee> bynullComparator3 = Comparator.nullsLast(bynullComparator1);
		System.out.println("nullLast " + bynullComparator3.compare(null, emp2));
		System.out.println("______________________________________________");
		
		/* Returns a comparator that imposes the reverse ordering of this comparator. */
		Comparator<Employee> nullThenDecreasingName = bynullComparator1.reversed();
		System.out.println("nullThenDecreasingName " + nullThenDecreasingName.compare(null,emp4));
	}

}
