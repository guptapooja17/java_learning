package com.java.basics;

public class ZooInnerClass {

	private interface Paper {
		public String getId();
	}

	public class Ticket implements Paper {
		private String serialNumber;
		public String getId() { return serialNumber; }
	}

	public Ticket sellTicket(String serialNumber) {

		var t = new Ticket();
		t.serialNumber = serialNumber;
		return t;
	}

	public static void main(String[] args) {
		ZooInnerClass zClass = new ZooInnerClass();
		Ticket ticket = zClass.sellTicket("123456678");
		System.out.println("Ticket Sold : " + ticket.getId());
	}
}
