package generics;

/*
 * There may be times when you want to restrict the types that can be used as type arguments in a parameterized type.
 *  For example, a method that operates on numbers might only want to accept instances of Number or its subclasses. 
 *  This is what bounded type parameters are for. 
 *  Sometimes we don’t want whole class to be parameterized, in that case we can create java generics method. 
 *  Since constructor is a special kind of method,we can use generics type in constructors too. 
 *  
 *  Suppose we want to restrict the type of objects that can be used in the parameterized type. 
 *  For example in a method that compares two objects and we want to make sure that the accepted objects are Comparables.
 *  
 *  The invocation of these methods is similar to unbounded method except that if we will try to use any class that is not Comparable,
 *  it will throw compile time error.
 */

public class JavaGenericBound {
	public static void main(String[] args) {
		// Creating object of sub class C and 
        // passing it to Bound as a type parameter.
        Bound<C> bec = new Bound<C>(new C());
        bec.doRunTest();
          
        // Creating object of sub class B and 
        // passing it to Bound as a type parameter.
        Bound<B> beb = new Bound<B>(new B());
        beb.doRunTest();
          
        // similarly passing super class A
        Bound<A> bea = new Bound<A>(new A());
        bea.doRunTest();
        
        //Bound<String> bes = new Bound<String>(new String());   can;t instantiate with string 
	}
}

class A {
	public void displayClass()
	{
		System.out.println("Inside super class A");
	}
}

class B extends A {
	public void displayClass()
	{
		System.out.println("Inside sub class B");
	}
}

class C extends A {
	public void displayClass()
	{
		System.out.println("Inside sub class C");
	}
}

//class Bound <T extends A & ABC> multiple bound
class Bound <T extends A> 
{
	
	private T objrefT;
	
	public Bound(T obj) {
		this.objrefT = obj;
	}
	
	public void doRunTest(){
        this.objrefT.displayClass();
    }
}

interface ABC
{
    public void displayClass();
}