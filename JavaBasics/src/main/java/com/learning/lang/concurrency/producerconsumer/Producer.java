package com.learning.lang.concurrency.producerconsumer;

public class Producer implements Runnable{
	Queue queue;
	
	public Producer(Queue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName() + " Thread : ";
		int element = 15;
		while(true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			synchronized(queue) {
				if(queue.isFull()) {
					try {
						System.out.println(threadName + "WAIT" +Thread.currentThread().getState());
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println(threadName + element + " is produced.");
				queue.enqueue(element); element = element + 10;
				queue.notifyAll();
			}
			
		}
		
	}

}
