package lamdaPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*
 * Intermediate operations are lazy. This means that they will be invoked only if it is necessary for the terminal operation execution.
 */

/* 
 * Java-8 Stream terminal operations produces a non-stream, result such as primitive value, a collection or no value at all. 
 * Terminal operations are typically preceded by intermediate operations which return another Stream which allows operations 
 * to be connected in a form of a query.
 * 
 * Here is the list of all Stream terminal operations:	toArray()	collect()	
 * count()	reduce()	forEach()	forEachOrdered()	min()	max()	anyMatch()	allMatch()	noneMatch()	findAny()	findFirst()
 */
public class LazyInvocation {

	private static long counter=0;
	private static long counter1=0;


	private static void wasCalled() {
		counter++;
	}
	
	private static void wasCalled1() {
		counter1++;
	}

	public static void main(String[] args) {

		//Example 1

		final Random random = new Random();

		Supplier<Integer> s = () -> {
			Integer result = random.nextInt();
			System.out.println("Random genereated " + result );
			return result;
		};

		Stream<Integer> randomStream1 = Stream.generate(s);

		System.out.println("Test 1");

		randomStream1.filter((a) -> a >= 0 ).limit(3).forEach(System.out::println);

		System.out.println("\n\n\nTest 2");

		Stream<Integer> randomStream2 = Stream.generate(s);
		randomStream2.limit(3).filter((a) -> a >= 3).forEach(System.out::println);

		//Example 2
		List<String> list = Arrays.asList("abc1", "def2", "ghi3");
		Stream<String> stream = list.stream().filter(element -> {
			wasCalled();
			return element.contains("2");
		});
				
		Optional<String> stream1 = list.stream().filter(element -> {
		   System.out.println("filter() was called");
		    return element.contains("2");
		}).map(element -> {
		    System.out.println("map() was called");
		    return element.toUpperCase();
		}).findFirst();
		
		System.out.println("_________________Order Of Execution______________");
		/*
		 * Order of Execution
		 * From the performance point of view, the right order is one of the most important aspects of chaining operations in the stream pipeline.
		 * This brings us to the following rule: intermediate operations which reduce the size of the stream should be placed before operations 
		 * which are applying to each element. So we need to keep methods such as skip(), filter(), and distinct() at the top of our stream pipeline.
		 */
		List<String> list1 = new ArrayList<>();
		list1.add("Poo--ja");
		list1.add("Poo--nam");
		list1.add("Ar--yan");
		long size = list1.stream().map(element -> {
		    wasCalled();
		    return element.substring(0, 3);
		}).skip(2).count();
		System.out.println("Counter if operation placed after map = " + counter);
		
		long size1 = list1.stream().skip(2).map(element -> {
		    wasCalled1();
		    return element.substring(0, 3);
		}).count();
		System.out.println("Counter1 if operation placed before map = " + counter1);
	}

}
