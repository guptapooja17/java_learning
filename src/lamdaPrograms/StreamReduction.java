package lamdaPrograms;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * if a developer needs to customize a Stream's reduction mechanism?
 *  There are two methods which allow us to do this, the reduce() and the collect() methods.
 * 
 * identity – the initial value for an accumulator, or a default value if a stream is empty and there is nothing to accumulate
 * 
 * accumulator – a function which specifies the logic of the aggregation of elements. As the accumulator creates a new value for 
 * 				 every step of reducing, the quantity of new values equals the stream's size and only the last value is useful.
 * 				 This is not very good for the performance.accumulator is the the BinaryOperator. 
 * 				 The type of Idenity and BinraryOperator should be same. The accumulator should also return same data type
 * 
 * combiner – 	a function which aggregates the results of the accumulator. We only call combiner in a parallel mode to reduce 
 * 				the results of accumulators from different threads.
 */

public class StreamReduction {

	public static void main(String[] args) {
		Data data1 = new Data(1);
		Data data2 = new Data(2);

		// COmpilation error!!!!
		// The method reduce(Data, BinaryOperator<Data>) in the type Stream<Data> is not applicable for the arguments (int, (<no type> d1, <no type> d2) -> {})
		// Object result = Stream.of(data1, data2).reduce(1, (d1, d2) -> d1.number + d2.number);

		Data result = Stream.of(data1, data2).reduce(new Data(1), (Data a, Data b) -> new Data(a.number + b.number));
		System.out.println(result.number);
		
		System.out.println("____________________________________________");
		
		int reducedTwoParams =
				  IntStream.range(1, 4).reduce(10, (a, b) -> a + b);	//reducedTwoParams = 16 (10 + 1 + 2 + 3)
		
		/*
		 * the accumulator ran three times by adding every element of the stream to identity. 
		 * These actions are being done in parallel. As a result, they have (10 + 1 = 11; 10 + 2 = 12; 10 + 3 = 13;). 
		 * Now combiner can merge these three results. It needs two iterations for that (12 + 13 = 25; 25 + 11 = 36).
		 */
		int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
			    .reduce(10, (a, b) -> a + b, (a, b) -> {
			       System.out.println("combiner was called");
			       return a + b;
			    });
		System.out.println(reducedParallel);
	}


}

class Data {
	int number;

	Data(int number) {
		this.number = number;
	}
}