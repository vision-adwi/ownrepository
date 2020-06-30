package com.learning.java5.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Phaser;

abstract public class Service implements Runnable {

	private String _service;
	private boolean isUp;
	private CountDownLatch _latch;
	private Phaser _phaser;
	
	Service(String serviceName, CountDownLatch latch) {
		_service = serviceName;
		_latch = latch;
		isUp = false;
	}
	
	@Override
	public void run() {
		try {
			bringUpService();
			isUp = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			_latch.countDown(); //not a blocking call, just decrement counter
			//_phaser.arrive(); //similar to above statement
		}
	}
	
	public String getService() {
		return _service;
	}
	
	public boolean isServiceUp() {
		return isUp;
	}
	
	abstract void bringUpService() throws InterruptedException;
}
