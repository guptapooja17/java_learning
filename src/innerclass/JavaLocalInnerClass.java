package innerclass;

public class JavaLocalInnerClass {

	private int enclosingClassVariable = 100;

	public String anotherMethod() {
		return "YES";
	}

	{
		// Local inner class can be present inside the normal initializer
		class LocalInnerClassInNormalInitialiser {}
	}

	static {
		// Local inner class can be present inside the static initializer
		abstract class LocalInnerClassInStaticInitialiser {}
	}

	public JavaLocalInnerClass () {
		//Local inner class can be present inside the constructor as well
		final class LocalInnerClassInConstructor {}
	}

	void someMethod() {								//Local Inner Class example
		long innerClassVariable = 20L;
		long effectivelyFinalVariable = 10L;
		final long finalVariable = 30L;

		// Local inner class can't be public, protected, private. But can be default, abstract, final, static
		class DefaultLocalInnerClass {}
		abstract class AbstractLocalInnerClass {}
		final class FinalLocalInnerClass {}
		
        innerClassVariable = 20 * innerClassVariable;	// not effectively final, changed the value

		class FieldsInLocalInnerClassInMethod {

			//Inner class cann't have the static fields/methods, can't have static final methods but can have static final field
			private static final String field1 = "Static Final";

			//Can have normal methods with public, private, protected or default
			protected void normalMethod() {}
			
			private void localInnerClassMethod() {
				
				System.out.println(enclosingClassVariable);
				System.out.println(anotherMethod());
				
				//Can also access local variables of the enclosing method given that they are either final or effectively final
				System.out.println(finalVariable);
				//System.out.println(innerClassVariable);		 no more final. Comment line 36 
				System.out.println(effectivelyFinalVariable);
			}
		}
	}

}
