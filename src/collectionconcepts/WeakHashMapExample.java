package collectionconcepts;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {

	public static void main(String[] args) throws InterruptedException {

		Demo d1Demo = new Demo("Hi 1");
		Demo d2Demo = new Demo("Hi 2");

		HashMap hashMap = new HashMap<>();
		hashMap.put(d1Demo, "A");
		System.out.println(hashMap);
		d1Demo=null;
		System.gc();
		Thread.sleep(3000);
		System.out.println(hashMap);
		
		System.out.println("Using Weak Hash Map");
		WeakHashMap weakHashMap = new WeakHashMap();
		weakHashMap.put(d2Demo, "B");
		System.out.println(weakHashMap);
		d2Demo=null;

		System.gc();
		Thread.sleep(3000);
		System.out.println(weakHashMap);
	}

}

class Demo {

	String nameString;

	public Demo(String nameString) {
		super();
		this.nameString = nameString;
	}

	@Override
	public String toString() {
		return "Demo [nameString=" + nameString + "]";
	}
	
}