package com.java.basics;
/*
 * Since static methods can only be hidden, not overridden, Java uses the reference type to determine which version of sneeze() should be called.
 * Likewise, the hasFur variable is hidden, not overridden, so the reference type is used to determine which value to output.
 */

public class MethodOverridingStatic {
	
	public static void main(String[] args) {
		
		Bear objBear = new Bear();
		objBear.sneeze();
		Bear.sneeze();
		Panda.sneeze();
		System.out.println(objBear.hasFur);
		System.out.println("___________1___________");
		
		Panda objPanda = new Panda();
		objPanda.sneeze();
		Bear.sneeze();
		Panda.sneeze();
		System.out.println(objPanda.hasFur);
		System.out.println("___________2___________");
		
		Bear objBear2 = objPanda;
		objBear2.sneeze();
		System.out.println(objBear2.hasFur);
		System.out.println("___________3___________");
		
		objBear.hibernate();
		objPanda.hibernate();
		objBear2.hibernate();
		System.out.println("___________4___________");

		Panda objPanda2 = (Panda) objBear2;
		objPanda2.sneeze();
		objPanda2.hibernate();
		//Object refer
		System.out.println(objPanda2.hasFur);
		System.out.println("___________5___________");

		Panda joey = new Panda();
		Bear moey = joey;
		joey.laugh();
		moey.laugh();
		System.out.println(joey.hasFur);
		System.out.println(moey.hasFur);
		
		//For instance methods object created is used to determine which method to call. 
		joey.hibernate();
		moey.hibernate();
	}

}

//Example 6 Method Hiding : Static Methods
/*
* it is method hiding if the two methods are marked static, and method over-
* riding if they are not marked static. This means static methods cannot be
* override but still follow the same rules of overriding.
*/

class Bear {
	
	protected boolean hasFur = false;
	
	public static void sneeze() {
		System.out.println("Bear is sneezing");
	}
	public void hibernate() {
		System.out.println("Bear is hibernating");
	}
	public static void laugh() {
		System.out.println("Bear is laughing");
	}
}

class Panda extends Bear {
	
	protected boolean hasFur = true;
	
	//public void sneeze() {} 
	public static void sneeze() { 
		System.out.println("Panda sneezes quietly");
	}
	//public static void hibernate() {}
	public void hibernate() { 
		System.out.println("Panda is going to sleep");
	}
	//protected static void laugh() {}
	public static void laugh() { 
		System.out.println("Panda is laughing");
	}
}