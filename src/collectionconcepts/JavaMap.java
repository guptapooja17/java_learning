package collectionconcepts;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

public class JavaMap {
	public static void main(String[] args) {

		//forEach accepts a BiConsumer
		Map<Integer, Character> hashMap = new HashMap<>();
        hashMap.put(11, 'c');
        hashMap.put(3, 'b');
        hashMap.put(2, 'a');
        hashMap.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));
        hashMap.keySet().forEach(System.out::println);
        hashMap.values().forEach(System.out::println);
        // entrySet returns a collection of Entry
        hashMap.entrySet().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()) );
        System.out.println( hashMap.get(4) ); // null if key not present
        System.out.println(hashMap.getOrDefault(4, 'N')); 
		System.out.println("______________________________________");
		
		// put adds a key-value pair to the map. if key already exists then replace the value and returns the replaced value
		Map<String, String> treeMap = new TreeMap();
		System.out.println(treeMap.put("koala", "bamboo"));
		System.out.println(treeMap.put("lion", "meat"));
		System.out.println(treeMap.put("giraffe", "leaf"));
		System.out.println(treeMap.put("lion", "Valuereplaced"));
		System.out.println("______________________________________");
		
		//Map has containsKey/containsValue method but doesn't have contains method
		System.out.println(treeMap.containsKey("lion"));
		System.out.println(treeMap.containsValue("sheep"));
		//System.out.println(treeMap.containsKey(null)); //NPE at run-time
		System.out.println("______________________________________");
		
		treeMap.replaceAll((k, v) -> k + " eats " + v);
		treeMap.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));
		System.out.println("______________________________________");
		
		//putIfAbsent, Puts the value in the map, but skips if it is already added. return null if put success else original value
		treeMap.putIfAbsent("cow", "Milk");
		System.out.println(treeMap.putIfAbsent("cow", "already has"));
		System.out.println("______________________________________");
		
	}
}
