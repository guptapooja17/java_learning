package collectionconcepts;

import java.util.HashMap;
import java.util.Map;

/*
 * key - key with which the computed value is to be associated 
 * remappingFunction - function that computes the new value for the specified key
 */

public class JavaMapComputeFunction {
	public static void main(String[] args) {

		Map<String, Integer> prices = new HashMap<>();
		prices.put("Shoes", 200);
		prices.put("Bag", 300);
		prices.put("Pant", 150);

		prices.compute("Shoes", (key, value) -> value * 100);
		prices.computeIfAbsent("Skirt", Key -> 100 * 100);
		prices.computeIfPresent("shoes", (key, value) -> value * 100);
		System.out.println(prices);
	}
}
