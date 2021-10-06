package com.java.basics;

public class PrimitiveDataTypes {
	
	public static void main (String[] args) {

	/*
	 * Identifiers: must begin with a-z/A-Z or $ or _
	 * can have numbers but can't begin with them since 
	 * Java9, underscore (_) is not a valid identifier
	 * can't have keywords valid identifiers
	 */
	
	// int _ = 1; '_' is a keyword from source level 9 onwards, cannot be used as identifier
	
	int $ = 3;
	int $_ = 4;
	boolean _okBoolean = true;
	System.out.println("$ = " + $ + "$_ = " + $_ + "okBoolean = " + _okBoolean);
	
    // Java adoesn't allow declaring two different types in same statement
	// int i3 = 4, short sh2 = 3; not valid
	// int i4=4, int i5=5;
	
	double d1 = 1, d2 = 2;
	System.out.println("d1 = " + d1 + "d2 = " + d2);

    // valid short 
    
    short sh1 = 'a';
    System.out.println(sh1);
    
    // valid char
    char ch1 = (short)85;
    System.out.println(ch1);
    
    /* You can add underscare anywhere except:
     * beginning of the literal / the end of literal / right before the decimal Point /  after the decimal point	
     */

     //double notAtStart = _1000.00;	Not valid	
     //double notAtEnd = 1000.00_;		Not valid
     //double notBeforeDec = 1000_.00;	Not valid
     //double notAfterDec = 1000._00;	Not valid
    
    int i1 = 100_00;
    short sh2 = 10_0;
    char ch2 = 1_0_0;
    long l1 = 2_00_000_000_000L;
    double ugly = 1___________________0; // prints 10.0
    
    System.out.println(i1);
    System.out.println(sh2);
    System.out.println(ch2);
    System.out.println(l1);
    System.out.println(ugly);
    
    // Invalid to assign null to primitive types
    // int i2 =null;
    
    // You can assign decimal (nor 0 nor x), octal by leading 0 (0-07), hexadecimal by leading 0 and x (0x or 0X) values to the integer 
    int octLit = 0400;
    int hexLit = 0x100;
    int decLit = 256;
    int binLit = 0b1111;
    
    System.out.println(octLit);
    System.out.println(hexLit);
    System.out.println(decLit);
    System.out.println(binLit);
    
	}
}
