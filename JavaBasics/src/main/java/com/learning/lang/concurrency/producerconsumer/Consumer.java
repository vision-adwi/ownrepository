package com.learning.lang.concurrency.producerconsumer;

public class Consumer implements Runnable{
	Queue queue;
	
	public Consumer(Queue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName() + " Thread : ";
		while(true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			synchronized(queue) {
				if(queue.isEmpty()) {
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
