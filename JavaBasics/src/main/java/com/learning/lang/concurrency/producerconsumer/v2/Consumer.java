package com.learning.lang.concurrency.producerconsumer.v2;

public class Consumer implements Runnable {
	ConcurrentQueue queue;

	public Consumer(ConcurrentQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName() + " Thread : ";
		while (true) {
			try {
				Thread.sleep(2000);
				System.out.println(threadName + queue.dequeue());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}

	}
}
