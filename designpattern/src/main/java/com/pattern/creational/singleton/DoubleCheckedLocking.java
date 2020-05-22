package com.pattern.creational.singleton;

public class DoubleCheckedLocking {
	private static DoubleCheckedLocking object;
	
	private DoubleCheckedLocking() {
		//Doing long operation1
		//Trying to get connection
	}
	
	public static DoubleCheckedLocking getInstance() {
		if (null == object) {
			synchronized (DoubleCheckedLocking.class) {
				if (null == object) {
					object = new DoubleCheckedLocking();
					//Above statement comprise of 3 instructions
					//1. construct empty doubleCheckedLocking()
					//2. assign to object
					//3. call constructor
					//As per java language specification, JVM is not bound to run the above 3
					//instructions in the same order.
				}
			}
		}

		return object;
	}
}
