package lamdaPrograms;

import java.util.stream.Stream;

public class StreamTraversal {

	public static void main(String[] args) {

		Stream<Integer> intStream = Stream.of(1,2,3,4);

		intStream.forEach(System.out::println);

		//trying to traverse the stream again causes Exception in thread "main" java.lang.IllegalStateException:stream has already been operated upon or closed
		intStream.forEach(System.out::println);		// exception


		Stream<Integer> newIntStream = Stream.of(1,2,3,4); 
		newIntStream.limit(2);
		newIntStream.forEach(System.out::println);	// exception
	}
}
