package lamdaPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*
 * https://www.baeldung.com/java-8-streams
 * https://www.oracle.com/technical-resources/articles/java/ma14-java-se-8-streams.html
 */
public class StreamBasicFunction {
	public static void main(String[] args) {
		//Empty Stream
		Stream<String> streamEmpty = Stream.empty();

		//Stream of Collection
		Collection<String> collection = Arrays.asList("a", "b", "c");
		Stream<String> streamOfCollection = collection.stream();

		/* Stream.builder()
		 * When builder is used, the desired type should be additionally specified in the right part of the statement, 
		 * otherwise the build() method will create an instance of the Stream<Object>
		 */
		Stream<String> streamBuilder =
				Stream.<String>builder().add("a").add("b").add("c").build();

		/*
		 * The generate() method accepts a Supplier<T> for element generation. As the resulting stream is infinite, 
		 * the developer should specify the desired size, or the generate() method will work until it reaches the memory limit
		 */
		Stream<String> streamGenerated =
				Stream.generate(() -> "element").limit(10);

		//Another way of creating an infinite stream is by using the iterate() method:
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);

		/*
		 * Stream of Primitives
		 * range(int startInclusive, int endExclusive)  end not included 
		 * rangeClosed(int startInclusive, int endInclusive) end is included
		 */
		IntStream intStream = IntStream.range(1, 3);
		LongStream longStream = LongStream.rangeClosed(1, 3);

		Random random = new Random();
		DoubleStream doubleStream = random.doubles(3);

		//Stream of String
		Stream<String> streamOfString =
				Pattern.compile(", ").splitAsStream("a, b, c");
		/*
		 * Referencing a Stream
		 * We can instantiate a stream, and have an accessible reference to it, 
		 * as long as only intermediate operations are called. Executing a terminal operation makes a stream inaccessible.
		 */
		List<String> elements = Stream.of("a", "b", "c").filter(element -> element.contains("b")).collect(Collectors.toList());
		Optional<String> anyElement = elements.stream().findAny();
		Optional<String> firstElement = elements.stream().findFirst();
		
		
	}

}
