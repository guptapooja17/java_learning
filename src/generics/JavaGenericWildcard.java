package generics;

import java.util.Arrays;
import java.util.List;

/*
 * The question mark (?) is known as the wildcard in generic programming . It represents an unknown type. 
 * The wildcard can be used in a variety of situations such as the type of a parameter, field, or local variable; sometimes as a return type.
 * 
 * Upper Bounded Wildcards: These wildcards can be used when you want to relax the restrictions on a variable. For example, 
 * say you want to write a method that works on List < integer >, List < double >, and List < number > , you can do this 
 * using an upper bounded wildcard.
 * 
 * Lower Bounded Wildcards: It is expressed using the wildcard character (‘?’), followed by the super keyword, 
 * followed by its lower bound: <? super A>.
 * 
 * Unbounded Wildcard: This wildcard type is specified using the wildcard character (?), for example, List. 
 * This is called a list of unknown type. These are useful in the following cases
 * 		When writing a method which can be employed using functionality provided in Object class.
 * 		When the code is using methods in the generic class that don’t depend on the type parameter
 */

public class JavaGenericWildcard {
	
	private static double sum(List<? extends Number> list) 
    {
        double sum=0.0;
        for (Number i: list)
        {
            sum+=i.doubleValue();
        }
  
        return sum;
    }
	
	public static void printOnlyIntegerClassorSuperClass(List<? super Integer> list) 
	{
        System.out.println(list);
    }
	
	private static void printlist(List<?> list) 
    {
  
        System.out.println(list);
    }
	
	public static void main(String[] args) {
		
		//Upper Bounded Integer List
        List<Integer> list1= Arrays.asList(4,5,6,7);
        List<Double> list2=Arrays.asList(4.1,5.1,6.1);
        
        //Lower Bounded Integer List
        List<Integer> list3= Arrays.asList(4,5,6,7);
        List<Number> list4= Arrays.asList(4,5,6,7);
        
        //Unbounded
        List<Integer> list5= Arrays.asList(1,2,3);
        List<Double> list6=Arrays.asList(1.1,2.2,3.3);

	}
}
