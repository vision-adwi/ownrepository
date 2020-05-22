package com.learning.lang.concurrency.producerconsumer.v5;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		ProducerConsumer prodCons = new ProducerConsumer();

		Thread t1 = new Thread(() -> prodCons.produce());
		Thread t2 = new Thread(() -> prodCons.consume());

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
