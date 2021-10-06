package lamdaPrograms;

import java.util.function.Consumer;

/*
 * Method parameters and local variables are allowed to be referenced if they are effectively final. 
 * This means that the value of a variable doesn’t change after it is set, regardless of whether it is explicitly marked as final.
 */

/*
 * Instance variable 	Allowed
 * Static variable 		Allowed
 * Local variable 		Allowed if effectively final
 * Method parameter 	Allowed if effectively final
 * Lambda parameter 	Allowed
 */
public class EffectivelyFinal {

	private String color;

	public void caw(String name) {
		String volume = "loudly";
		color = "Black";
		color = "Pink";
		Consumer<String> consumer = s -> System.out.println(name + " says " + volume + " that she is " + color);
		consumer.accept(name);
	}

	public void cawCannotChangeValue(String name) {
		String volume = "loudly";
		//name = "Caty";	the compiler error occurs on line 22.
		color = "black";
		Consumer<String> consumer = s -> System.out.println(name + " says "+ volume + " that she is " + color);
		consumer.accept(name);
		//volume = "softly";
	}
	
	public static void main(String[] args) {
		EffectivelyFinal effectivelyFinal = new EffectivelyFinal();
		effectivelyFinal.caw("Baffalo");
		effectivelyFinal.cawCannotChangeValue("Han");
		

		int limit = 10;
		new Thread( () ->  {
				//limit = 5; 					effectively final
				for (int i=0; i<limit ; i++)
					System.out.println(i);
				}
		);
	}
}
