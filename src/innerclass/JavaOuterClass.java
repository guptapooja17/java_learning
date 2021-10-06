package innerclass;

public class JavaOuterClass {

	private int JavaOuterClassVariable = 1;

	public JavaOuterClass() {
		JavaOuterClassVariable = 2;
	}

	public void outerMethod() {}

	//Inner class can be private,protected,public, default,final, abstract, static
	//Can extend any other inner class or outer classes, even its own class when it is present

	private class PrivateInnerClass {}
	protected class ProtectedInnerClass {}
	class DefaultInnerClass {}
	public class PublicInnerClass {}
	abstract class AbstractInnerClass {}
	final class FinalInnerClass {}
	static class StaticInnerClass {}
	class ChildInnerClass1 extends AbstractInnerClass {}
	class ChildInnerClass2 extends JavaOuterClass {}

	class FieldInJavaInnerClass {
		//Inner class cann't have the static fields/methods, can't have static final methods but can have static final field
		public static final String field2 ="Field 2";

		//Can have same field/method name as outer class
		protected int JavaOuterClassVariable = 4;
		protected void outerMethod() {}

		public FieldInJavaInnerClass() {
			System.out.println(JavaOuterClassVariable);
		}

		//Can't have static initializer but can have instance initializer
		{
			System.out.println("Inner class initilizer block");
		}
	}

	private int x = 0;
	class A {
		private int x = 10;
		
		class B {
			private int x = 20;
			
			class C {
				private int x = 30;
				
				void printAllx() {
					System.out.println(x);
					System.out.println(this.x);
					System.out.println(B.this.x);
					System.out.println(A.this.x);
					
					B.this.x = 50;
					System.out.println(B.this.x);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		//Inner class can be initialized using outer class
		JavaOuterClass javaOuterClass = new JavaOuterClass();
		PrivateInnerClass privateInnerClass = javaOuterClass.new PrivateInnerClass();
		
		A a = javaOuterClass.new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.printAllx();

	}
	
	public void someMethod() {
        //Inner classes object can be created inside instance methods
        new PrivateInnerClass();
    }

    public static void someStaticMethod() {
        //]Inner classes objects can't be created inside class methods ( static ) 
        //new PrivateInnerClass();
    }


}
