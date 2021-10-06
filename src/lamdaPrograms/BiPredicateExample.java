package lamdaPrograms;

import java.util.function.BiPredicate;
import java.util.function.Function;

public class BiPredicateExample {
	
	static <R> R playOneArgument(String s1, Function<String, R> func) {
		return func.apply(s1);
	}
	
	static Boolean playTwoArgument(String s1, String s2, BiPredicate<String, String> func){
		return func.test(s1, s2);
	}
	
	public static void main(String[] args) {
		
		System.out.println(	playOneArgument("GeeksForGeeks", String::toLowerCase)	);	
		System.out.println(	playTwoArgument("Pooja", "Pooja", String::equals));	
	}

}
