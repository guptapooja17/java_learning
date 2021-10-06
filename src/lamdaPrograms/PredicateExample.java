package lamdaPrograms;

import java.util.function.Predicate;

public class PredicateExample {
	public static void main(String[] args) {
		
		Predicate<String> predicate = t -> t.length() > 5;
		
		System.out.println("Is length > 5 " + predicate.test("I'm Here To learn"));
		System.out.println("Is length > 5 " + predicate.test("Ooops"));
		//System.out.println("Is length > 5 " + predicate.test(null));	//NPE
	}
}
