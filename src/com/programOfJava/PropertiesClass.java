package com.programOfJava;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesClass {

	public static void main(String[] args) throws IOException {
		
		Properties properties = new Properties();
		FileReader fileReader = new FileReader("src/db.properties");
		properties.load(fileReader);
		
		System.out.println("All Property name : " + properties.stringPropertyNames() + "\nFetch one Property name" + properties.getProperty("ip"));
		
		Set set = properties.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		
	}
}
