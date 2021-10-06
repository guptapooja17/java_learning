package lamdaPrograms;

import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* https://www.oracle.com/technical-resources/articles/java/java8-optional.html
	empty ( Optional.empty() )
    of  ( Optional.of( value ) )
 	get ( o.get() )
    isPresent ( o.isPresent() )
    ofNullable ( Optional.ofNullable( o ) )
    ifPresent  ( o.ifPresent( consumer ) )
    orElse ( o.orElse( T t) )
    orElseGet ( o.orElseGet( supplier ) )
    orElseThrow ( o.orElseThrow() -> throws NoSuchElementException )
    orElseThrow ( o.orEleseThrow( Supplier ) )
 */

public class OptionalExample {

	public static Optional<Double> getAverage( Double... dargs ) {

		if( dargs.length == 0 ) return Optional.empty();

		double res = 0;
		for( var d : dargs ) res += (double)d;
		res = res/dargs.length;

		return Optional.of( (Double) res );

	}

	public static void main(String[] args) throws ClassNotFoundException{  

		String[] words = new String[10];  
		Optional<String> checkNull = 
				Optional.ofNullable(words[5]);  
		if (checkNull.isPresent()) {  
			String word = words[5].toLowerCase();  
			System.out.print(word);  
		} else  
			System.out.println("word is null");              

		Optional<Double> emptyOptional = getAverage();
		Optional<Double> notEmpOptional = getAverage(2.0, 4.5, 3.5, 6.5);

		if (notEmpOptional.isPresent()) {
			System.out.println(notEmpOptional.get());
		}

		System.out.println(Optional.ofNullable(emptyOptional.get()));
		System.out.println(Optional.ofNullable(notEmpOptional.get()));
		System.out.println(emptyOptional.orElse(2.2));
		System.out.println(emptyOptional.orElseGet(	() -> Double.NaN ));

		emptyOptional.orElseThrow(ClassNotFoundException::new);

		var strm = Stream.of("lion", "tiger", "zebra");
		String j = strm.collect(Collectors.joining("/"));
		System.out.println(j); // lion/tiger/zebra

		// Stream to TreeSet
		strm = Stream.of("lion", "tiger", "zebra", "timberfox");
		TreeSet<String> set = strm
				.filter( s -> s.startsWith("t"))
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set);

		// Stream to Map 1
		Stream<String> mapStrm1 = Stream.of("lion", "tiger", "zebra", "timberfox");
		Map<String, Integer> map1 = mapStrm1
				.collect(Collectors.toMap(s -> s, String::length));
		System.out.println(map1);

	}  
}
