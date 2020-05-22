package com.learning.java5.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class TelecomService extends Service {

	public TelecomService(CountDownLatch latch) {
		super("Telecom Service", latch);
	}
	@Override
	void bringUpService() throws InterruptedException {
		System.out.println(this.getService() + " is bringing up.");
		Thread.sleep(1000 * 10);
	}

}
