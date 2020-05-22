package com.learning.java5.concurrency.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class GarbageCollector implements Runnable{
	private String phase;
	private ReentrantLock reentrantLock;
	
	public GarbageCollector(String phase, ReentrantLock lock) {
		this.phase = phase;
		this.reentrantLock = lock;
	}

	@Override
	public void run() {
		reentrantLock.lock();
		try {
			System.out.println(phase + " started" + " Lock count : " + reentrantLock.getHoldCount());
			Thread.sleep(2500);
			System.out.println(phase + " completed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			reentrantLock.unlock();
		}

	}

}
