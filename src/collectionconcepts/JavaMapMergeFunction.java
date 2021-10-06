package collectionconcepts;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/*
 * The Java HashMap merge() method inserts the specified key/value mapping to the hashmap if the specified key is already not present. 
 * If the specified key is already associated with a value, the method replaces the old value with the result of the specified function.
 * 
 * returns the new value associated with the key
 * returns null if no value associated with key
 * Note: If remappingFunction results null, then the mapping for the specified key is removed.
 */

/*
 * We can also use the putAll() method to merge two hashmaps.However, if a key is present in both hashmaps,the old value is replaced by the new value.
 * Unlike the merge(), putAll() method does not provide the remapping function. Hence, we cannot decide what value to store for duplicate keys.
 */

public class JavaMapMergeFunction {
	
	public static void main(String[] args) {
		
		Map<String, Integer> price = new HashMap<>();
		price.put("shoes", 200);
		price.put("Bag", 300);
		price.put("Pant", 150);
				
		//HashMap merge() to Insert New Entry
		price.merge("Shirt", 500, (Key, Value) -> Value * 100);
		System.out.println(price);
		
		//HashMap merge() to Insert Entry with Duplicate Key
		Map<String, String> countriesMap = new HashMap<>();
		countriesMap.put("Washington", "America");
	    countriesMap.put("Canberra", "Australia");
	    countriesMap.put("Madrid", "Spain");
	    
	    BiFunction<String, String, String> mapperBiFunction = (oldValue, newValue) -> oldValue + "/" + newValue;
	    countriesMap.merge("Washington", "USA", mapperBiFunction);
	    countriesMap.merge("India", "Delhi", mapperBiFunction);
	    System.out.println(countriesMap);
	    
	    //HashMap merge() to Merge two HashMaps
	    Map<String, Integer> prices1 = new HashMap<>();
	    prices1.put("Pant", 230);
	    prices1.put("Shoes", 350);
	    prices1.put("Kurti", 400);
	    prices1.put("Joggers", 3000);
	    //prices1.put("Jeans", null);
	    
	    Map<String, Integer> prices2 = new HashMap<>();
	    prices2.put("Shirt", 150);
	    prices2.put("Shoes", 320);
	    prices2.put("Joggers", 3000);
	    
	    prices1.forEach((k,v) -> prices2.merge(k, v, (oldValue, newValue) -> oldValue > newValue ? oldValue : newValue));
	    System.out.println(prices2);
	    }	
}
