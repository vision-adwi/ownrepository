package com.pattern.creational.singleton;

public class DoubleCheckedLockingV2 {
	//To overcome the ordering issue of instructions make this object volatile.
	private volatile static DoubleCheckedLockingV2 object;
	
	private DoubleCheckedLockingV2() {
		//Doing long operation1
		//Trying to get connection
	}
	
	public static DoubleCheckedLockingV2 getInstance() {
		if (null == object) {
			synchronized (DoubleCheckedLockingV2.class) {
				if (null == object) {
					object = new DoubleCheckedLockingV2();
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
