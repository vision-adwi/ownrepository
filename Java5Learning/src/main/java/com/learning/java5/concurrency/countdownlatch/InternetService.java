package com.learning.java5.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class InternetService extends Service {

	public InternetService(CountDownLatch latch) {
		super("Internet Service", latch);
	}
	@Override
	void bringUpService() throws InterruptedException {
		System.out.println(this.getService() + " is bringing up.");
		Thread.sleep(1000 * 15);
	}

}
