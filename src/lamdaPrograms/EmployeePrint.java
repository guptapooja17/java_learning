package lamdaPrograms;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class EmployeePrint {

	public static Employee createEmployee(Supplier<? extends Employee> factory) {
		return factory.get();
	}

	public static <E extends Employee> boolean testEmployee(Predicate<E> theTest) {
		return theTest.test(null);
	}

	public static boolean testEmployee2(Predicate<? extends Employee> theTest) {
		return theTest.test(null);
	}
	
	public static void main(String[] args) {

		Employee[] employees = Employee.randomlyGenerate(8);
		for (Employee emp : employees) {
			System.out.println(emp);
		}
		System.out.println("________________________________________");
		employees = Employee.SOME;
		Arrays.stream(employees).filter(emp -> emp.getSalary() >= 2500).forEach(System.out::println);
		System.out.println("________________________________________");
		Arrays.stream(employees).filter(emp -> emp.getSalary() >= 2500).map(Employee::getName).forEach(System.out::println);
		System.out.println("________________________________________");

		Employee emp1 = new Employee("Pooja", 700000),
				emp2 = new Employee("Kunal", 10000000);
		System.out.println("Comparable = " + emp1.compareTo(emp2));

		System.out.println("________________________________________");

		Predicate<Manager> isGoodPredicate = manager -> true;
		EmployeePrint.createEmployee(() -> new Manager("ABCDEF", 400000, 200000));
		System.out.println(EmployeePrint.testEmployee(isGoodPredicate));
		System.out.println(testEmployee((Manager manager) -> isGoodPredicate.test(manager)) );
		System.out.println(EmployeePrint.testEmployee(Employee -> emp1.getSalary() >= 100000000) );

		System.out.println("__________________Stream To Array______________________");
		//Stream to Array
		Object[] objs = Stream
				.of( Employee.SOME )
				.filter(e -> e.getSalary() < 2000 )
				.toArray();

		Employee[] empObjs = Stream
				.of( Employee.SOME )
				.filter( e -> e.getSalary() < 2000 )
				.toArray(Employee[]::new);
		
		//Stream From Array
		System.out.println("__________________Stream From Array______________________");
		Stream<Employee> streamOfArrayStream = Arrays.stream(Employee.SOME);
		streamOfArrayStream.filter(emp -> emp.getSalary() >=2000).map(Employee::getName).forEach(System.out::println);
		
		Stream<Employee> streamOfArrayStream2 = Arrays.stream(Employee.SOME, 2, 6);
		streamOfArrayStream2.forEach(System.out::println);
		
		Stream<String> strStream = Stream.of( "One", "Two", "Three");
        strStream.forEach(System.out::println);

        Stream<Integer> intStream = Stream.of(1,2,2,3,4,3);
        intStream.distinct().forEach(System.out::println);

	}
}

class Employee implements Comparable<Employee>{

	private String name;
	private int salary;

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String toString() {
		return name + ": " + salary;
	}

	public static final Employee[] SOME = {
			new Employee("Mike", 2500),
			new Employee("Frank", 3000),
			new Employee("Hannah", 2500),
			new Employee("Rajeev", 2000),
			new Employee("Jessica", 1500),
			new Employee("Doug", 2000),
			new Employee("Chen", 3500),
			new Employee("Krish", 2200),
			new Employee("Louie", 800)
	};

	private static Random rand = new Random();

	public static Employee[] randomlyGenerate(int n) {
		return Stream.generate(() -> {
			String name = "Pippo";
			return new Employee(name, rand.nextInt(10000));
		}).limit(n).toArray(Employee[]::new);
	}

	@Override
	public int compareTo(Employee emp) {
		return this.name.compareTo(emp.name);
	}

}

class Manager extends Employee {
	int bonus;

	public Manager(String name, int salary, int bonus) {
		super(name, salary);
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
