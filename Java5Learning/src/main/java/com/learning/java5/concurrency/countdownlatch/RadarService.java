package com.learning.java5.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class RadarService extends Service {

	public RadarService(CountDownLatch latch) {
		super("Radar Service", latch);
	}
	@Override
	void bringUpService() throws InterruptedException {
		System.out.println(this.getService() + " is bringing up.");
		Thread.sleep(1000 * 22);
	}

}
