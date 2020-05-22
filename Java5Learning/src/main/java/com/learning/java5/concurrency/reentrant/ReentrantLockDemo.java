package com.learning.java5.concurrency.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	
	public static void main(String[] s) {
		ReentrantLock reentrantLock = new ReentrantLock();
		
		Runnable marker = new GarbageCollector("Marker", reentrantLock);
		Runnable sweeper = new GarbageCollector("Sweeper", reentrantLock);
		Runnable compacter = new GarbageCollector("Compacter", reentrantLock);
		
		Thread t1 = new Thread(marker);
		Thread t2 = new Thread(sweeper);
		Thread t3 = new Thread(compacter);
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
