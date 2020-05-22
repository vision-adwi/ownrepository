package com.learning.java5.concurrency.threadlocal;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		Runnable r = new ThreadWithId();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.setName("Thread1");
		t2.setName("Thread2");
		t1.start();
		t2.start();

	}

}
