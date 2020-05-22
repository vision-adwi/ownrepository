package com.learning.lang.concurrency.producerconsumer.V4;

import java.util.concurrent.ArrayBlockingQueue;

public class Producer implements Runnable {
	ArrayBlockingQueue<Integer> queue;

	public Producer(ArrayBlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName() + " Thread : ";
		int element = 15;
		while (true) {
			try {
				Thread.sleep(2000);
				System.out.println(threadName + element + " is produced.");
				queue.put(element);
				element = element + 10;
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

}
