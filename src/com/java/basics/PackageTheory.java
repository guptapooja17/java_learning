package com.java.basics;

import java.util.Random;
// import java.util.*; import all classes of the package

/* A java package is a mechanism for providing a namespace to classes. 
 * An area inside of which the names (like class,variable, methods) are unique but oustside of which they might not be.
 */

/*
 * There is another type of import called a static import . Regular imports are for importing classes. Static imports are for importing static members of classes. 
 * Just like regular imports, you can use a wildcard or import a specifi c member. The idea is that you shouldn’t have to specify where each static method or variable comes
 * from each time you use it.
 * eg: import static java.util.Arrays.asList;  
 */

public class PackageTheory {
	public static void main (String[] args) {
		Random random = new Random();
		System.out.println(random.nextFloat());
	}

}
// if you import two same named classes from different packages, compiler confused which one to use. Use fully qualifies names.

// java.lang package is special in that it is automatically imported. There are three redundant imports here. 

//import java.lang.System;
//import java.lang.*;
//import java.util.Random;
//import java.util.*;
//class ImportExample {
//	public static void main(String[] args) {
//		Random r = new Random();
//		System.out.println(r.nextInt(10));
//	}
//}

//import java.nio.file.*;

//import java.nio.file.Files;
//import java.nio.file.Paths;

//class InputImports {
//	public void read(Files files) {
//		Paths.get("name");
//	}
//}

//import java.nio.*; 				 NO GOOD - a * only matches class names, not "file.Files"
//import java.nio.*.*; 				 NO GOOD - you can only have one * and it must be at the end
//import java.nio.file.Paths.*; 	 NO GOOD - you cannot import methods, only class names

