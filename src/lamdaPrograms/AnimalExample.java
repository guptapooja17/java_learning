package lamdaPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
Functional programming is a way of writing code more declaratively. You specify what
you want to do rather than dealing with the state of objects. You focus more on expressions
than loops.
Functional programming uses lambda expressions to write code. A lambda expression
is a block of code that gets passed around. You can think of a lambda expression as an
unnamed method. It has parameters and a body just like full-fledged methods do, but
it doesn’t have a name like a real method. Lambda expressions are often referred to as
lambdas for short.

Lambdas work with interfaces that have only one abstract method. These are called functional interfaces.

a -> a.canHop()	Java doesn’t require you to type return or use a semicolon when no braces are used.
(Animal a) -> { return a.canHop(); }
s -> {} is valid
 */

public class AnimalExample {
	
	private static void print(List<Animal> animals, CheckTrait checker) {
		for (Animal animal : animals) {
			// the general check
			if (checker.test(animal))
				System.out.print(animal + " ");
		}
		System.out.println();
	}
	
	
	//Predicate :	public interface Predicate<T> { boolean test(T t); }
	private static void printUsingPredicate(List<Animal> animals, Predicate<Animal> check) {
		for (Animal animal : animals) {
			if (check.test(animal))
				System.out.print(animal + " ");
		}
		System.out.println();
	}
	
	//Consumer	:	void accept(T t)	you might want to accept values but nor return it
	private static void printUsingConsumer(List<Animal> animals, Consumer<List <Animal> > consumer) {
		consumer.accept(animals);
	}
	
	//Supplier	:	T get()		A good use case for a Supplier is when generating values.
	private static void printUsingSupplier(List<Animal> animals, Supplier<String> supplier) {
		System.out.println(supplier.get());
	}
	
	public static void main(String[] args) {

		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("fish", false, true));
		animals.add(new Animal("kangaroo", true, false));
		animals.add(new Animal("rabbit", true, false));
		animals.add(new Animal("turtle", false, true));

		//traditional way of to check condition and use methods, to check canSwim we need to make another class
		print(animals, new CheckIfHopper());

		//With lamda
		print(animals, a -> a.canHop());
		print(animals, a -> ! a.canHop());
		//no need to write extra class for swim, same method can be used
		//print(animals, null); can't send null  NPE
		print(animals, a -> a.canSwim());
		
		System.out.println("________________Predicate________________");
		
		//Using Predicate
		printUsingPredicate(animals, a -> a.canSwim());
		
		System.out.println("________________Consumer________________");
		
		//Using Consumer
		Consumer<List <Animal> > consumer = a -> System.out.println(a);
		printUsingConsumer(animals, consumer);
		
		System.out.println("________________Supplier________________");

		//Using Supplier
		Supplier<String> supplier = () -> animals.get(0).getSpecies();
		printUsingSupplier(animals, supplier);
		
		System.out.println("________________Comparator________________");

		//Using Comparator to sort
		Collections.sort(animals, (s1, s2) -> animals.get(1).getSpecies().compareTo(animals.get(0).getSpecies()));
		animals.stream().forEach(member -> System.out.println(member));
	}

}

class Animal {
	private String species;
	private boolean canHop;
	private boolean canSwim;
	public Animal() {}
	public Animal(String speciesName, boolean hopper, boolean swimmer){
		species = speciesName;
		canHop = hopper;
		canSwim = swimmer;
	}
	public boolean canHop() { return canHop; }
	public boolean canSwim() { return canSwim; }
	public String toString() { return species; }
	
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	
	
}

interface CheckTrait {
	boolean test(Animal a);
}

class CheckIfHopper implements CheckTrait {
	public boolean test(Animal a) {
		return a.canHop(); 
	} 
}
