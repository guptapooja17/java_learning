package com.programOfJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Price {
	private String itemString;
	private int price;

	public Price(String itemString, int price) {
		this.itemString = itemString;
		this.price = price;
	}

	@Override
	public int hashCode() {
		int hashcode = 0;
		hashcode = price * 20;
		hashcode += itemString.hashCode();
		return hashcode;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Price) {
			Price priceHashMap = (Price) obj;
			return (priceHashMap.itemString == this.itemString && priceHashMap.price == this.price);
		} else {
			return false;
		}
	}

	public String getItemString() {
		return itemString;
	}

	public void setItemString(String itemString) {
		this.itemString = itemString;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}

public class PriceHashMap {
	public static void main(String[] args) {
		Map<Price, String> map = new HashMap<>();
		
		map.put(new Price("Apple", 20), "Apple");
		map.put(new Price("Banana", 30), "Banana");
		map.put(new Price("Chiku", 40), "Chiku");

		Price keyPrice = new Price("Chiku", 40);
		System.out.println("Is chiku available : " + map.containsKey(keyPrice));
		
		printMap(map);
	}
	
	public static void printMap(Map<Price, String> map) {
		Set<Price> keyPrices = map.keySet();
		for (Price price : keyPrices) 
			System.out.println(price + " ====> " + map.get(keyPrices));
	}
}