package com.pattern.behavioral.chainofresponsibility;

/*
- An object-oriented linked list with recursive traversal.
- Launch-and-leave requests with a single processing pipeline that contains many possible handlers.
- Chain the receiving objects and pass the request along the chain until an object handles it.

*/

public class ATMDispenser {

	public static void main(String[] args) {
		DollarDispenser mainDispenser = new DollarDispenserImpl();
		mainDispenser.dispense(new Currency(534));

	}

}
