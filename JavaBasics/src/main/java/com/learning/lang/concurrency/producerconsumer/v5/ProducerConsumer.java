package com.learning.lang.concurrency.producerconsumer.v5;

public class ProducerConsumer {
	Queue queue = new Queue(5);

	public ProducerConsumer() {
	}

	public void produce() {
		String threadName = Thread.currentThread().getName() + " Thread : ";
		int element = 15;
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			synchronized (queue) {
				if (queue.isFull()) {
					try {
						System.out.println(threadName + "WAIT"
								+ Thread.currentThread().getState());
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.println(threadName + element + " is produced.");
				queue.enqueue(element);
				element = element + 10;
				queue.notifyAll();
			}
		}
	}

	public void consume() {
		String threadName = Thread.currentThread().getName() + " Thread : ";
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			synchronized (queue) {
				if (queue.isEmpty()) {
					try {
						System.out.println(threadName + "WAIT");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(threadName + queue.dequeue());
				queue.notifyAll();
			}
		}
	}

}
