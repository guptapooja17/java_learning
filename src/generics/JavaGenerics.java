package generics;

import java.util.ArrayList;
import java.util.List;

public class JavaGenerics {

	public static void main(String[] args) {

		List<Integer> lst = new ArrayList<>();
		lst.add(1);
		lst.add(null); 
		//int num = lst.get(1);  NullPointerException  null can't be unboxed 

		List lis1 = new ArrayList<String>();
		//List<String> lis1 = new ArrayList<>();
		lis1.add(3);
		lis1.add(new StringBuilder("Cannot be cast from StringBuilder to String"));
		Printnames(lis1);	

		// - Upper bound wildcard
		List<? extends Exception> lstc = new ArrayList<RuntimeException>();

		// - Lower bound wildcard
		List<? super RuntimeException> lstd = new ArrayList<Exception>();

		// Type mismatch: cannot convert from ArrayList<Integer> to List<Number>
		//List<Number> lstf = new ArrayList<Integer>();
		List<? extends Number> lstg = new ArrayList<Integer>();
		
		// Wildcard are not allowed on right side of the statement
		// Cannot instantiate the type ArrayList<? super Object>)
        // List<Object> objects1 = new ArrayList<? extends Object>();
		
		// COMPILER ERROR
        // (Cannot instantiate the type ArrayList<? super Object>)
		//	List<Object> objects2 = new ArrayList<? super Object>();

        // COMPILER ERROR
        // (Cannot instantiate the type ArrayList<? extends Object>)
        //	List<? extends Object> objects3 = new ArrayList<? extends Object>();
		
		// COMPILER ERROR
        // (Type mismatch: cannot convert from ArrayList<Number> to List<? super Object>)
        // List<? super Object> objects6 = new ArrayList<Number>();
		
		List<? extends Object> objects4 = new ArrayList<Number>();

        List<? extends Object> objects5 = new ArrayList<Object>();
        
        List<? super Object> objects7 = new ArrayList<Object>();

        List<? super Number> objects8 = new ArrayList<Object>();

	}

	static <T> void Printnames(List<?> t) {
		String nameString = (String) t.get(1);
	}
}
