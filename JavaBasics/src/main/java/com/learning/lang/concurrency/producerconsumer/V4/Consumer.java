package com.learning.lang.concurrency.producerconsumer.V4;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer implements Runnable {
	ArrayBlockingQueue<Integer> queue;

	public Consumer(ArrayBlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName() + " Thread : ";
		while (true) {
			try {
				Thread.sleep(2000);
				System.out.println(threadName + queue.take());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}

	}
}
