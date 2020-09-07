package com.learning.lang.concurrency.practice;

public class MultipleThreads {
	public static void main(String[] s) {
		Tasks task = new Tasks();
		
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		}
		catch(InterruptedException e) {
			
		}
		
		System.out.println(task.x);
	}

}

class Tasks implements Runnable {
	int x;
	public void run() {
		for(int i = 0; i < 10; i++) {
			x++;
		}
	}
}
