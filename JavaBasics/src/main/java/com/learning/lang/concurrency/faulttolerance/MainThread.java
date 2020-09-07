package com.learning.lang.concurrency.faulttolerance;

public class MainThread {
	public static void main(String[] s)  {
		Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {		
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Thread - " + t.getName() + " " + e.getMessage());
				
			}
		};
		Thread t = new Thread(new MyRunnable());
		t.setName("Problematic thread");
		t.setUncaughtExceptionHandler(handler);
		t.start();
		
		try {
			Thread.sleep(10 * 1000);
		}
		catch(InterruptedException e) {
			
		}
		System.out.println("Main thread is running");

	}

}

class MyRunnable implements Runnable {
	public void run() {
		throw new RuntimeException(Thread.currentThread().getName() + " throws exception.");
	}
}
