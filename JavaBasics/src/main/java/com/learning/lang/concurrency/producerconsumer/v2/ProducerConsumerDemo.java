package com.learning.lang.concurrency.producerconsumer.v2;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		ConcurrentQueue resource = new ConcurrentQueue(5);
		
		Runnable producer = new Producer(resource);
		Runnable consumer = new Consumer(resource);
		
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);

		t1.setName("Producer");
		t2.setName("Consumer");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
