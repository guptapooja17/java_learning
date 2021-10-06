package lamdaPrograms;

import java.util.Comparator;

public class ComparatorExampleWithLamda {
	
	private String classnameString;
	
	public static void main(String[] args) {
		Comparator<Employee> byname1 = (Employee e1, Employee e2) -> { return e1.getName().compareTo(e2.getName()); };
		//You cannot remove braces and leave 'return'
		Comparator<Employee> byname2 = (e1, e2) -> { return e1.getName().compareTo(e2.getName()); };
		Comparator<Employee> byname3 = (e1, e2) -> e1.getName().compareTo(e2.getName());
		
		Runnable run1 = () -> System.out.println("running run method ");
		Thread thread = new Thread(run1);
		thread.start();
		
		 new Thread( () -> System.out.println("running run method") ).start();
	}
}
