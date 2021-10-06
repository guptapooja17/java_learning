package com.programOfJava;

import java.util.HashMap;

public class AppleHashcode {
	
	public static void main(String[] args) {
		Apple a1 = new Apple("Red");
		Apple a2 = new Apple("Red");
		
		System.out.println(a1.equals(a2));
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
	}
}

class Apple {
	
	String colorString;
	
	public Apple(String colorString) {
		super();
		this.colorString = colorString;
	}

	public String getColorString() {
		return colorString;
	}

	public void setColorString(String colorString) {
		this.colorString = colorString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colorString == null) ? 0 : colorString.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apple other = (Apple) obj;
		if (colorString == null) {
			if (other.colorString != null)
				return false;
		} else if (!colorString.equals(other.colorString))
			return false;
		return true;
	}
	
}