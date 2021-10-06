package lamdaPrograms;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/*
 * In Java 8, BiFunction is a functional interface; it takes two arguments and returns an object.
 * 	BiFunction.java
	@FunctionalInterface
		public interface BiFunction&lt;T, U, R&gt; {
			R apply(T t, U u);
		}
 T – Type of the first argument to the function.
 U – Type of the second argument to the function.
 R – Type of the result of the function.
 */

public class BiFunctionExample {
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> function = (a1, a2) -> a1 + a2;
		Integer result = function.apply(2, 3);
		
		BiFunction<Integer, Integer, Double> function2 = (a1, a2) -> Math.pow(a1, a2);
		Double reDouble = function2.apply(3, 4);
		
		BiFunction<Integer, Integer, List<Integer>> function3 = (a1, a2) -> Arrays.asList((a1+a2), (a2+a2));
		List<Integer> reIntegers = function3.apply(3, 4);
	}
}
