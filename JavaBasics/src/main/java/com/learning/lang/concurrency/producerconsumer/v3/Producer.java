package com.learning.lang.concurrency.producerconsumer.v3;

public class Producer implements Runnable {
	ConcurrentQueue queue;

	public Producer(ConcurrentQueue queue) {
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
				queue.enqueue(element);
				element = element + 10;
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

}
