package lamdaPrograms;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class TypeInference {

	public static void main(String[] args) {

		// *** Part 1: identify the FI	
		Consumer<String> tConsumer = msg -> System.out.println(msg.length());

		//Compile-time error
		//Object x1 = msg -> System.out.println(msg.length());
		//Object x2 = (String msg) -> System.out.println(msg.length());

		Object x3 = (Consumer<String>) msg -> System.out.println(msg.length());

		// *** Part 2: identify parameter types

		
		//Consumer<?> c2 = msg -> System.out.println(msg.length());
		// OK: but inferred parameter type is Object
		Consumer<?> c3 = msg -> System.out.println(msg);			
		// OK: added manifest type to parameter
		Consumer<?>	c4 = (String msg) -> System.out.println(msg.length());

	}
	
	public static <T extends Employee> T testWithNull(UnaryOperator<T> operation) {
		return operation.apply(null);
	}
	
	public static void method2() {
		// Doubles the bonus of a Manager
		UnaryOperator<Manager> doubleBonusOperator = manager -> {
			return new Manager("Pooja", 4000000, 200*4);
		};
		
		Manager test1 = testWithNull(doubleBonusOperator);
		
		Manager test2 = testWithNull(manager  -> new Manager("Pooja", 5000000, 100*400));
	}

}
