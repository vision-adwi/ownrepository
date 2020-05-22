package com.learning.java5.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

abstract public class Service implements Runnable {

	private String _service;
	private boolean isUp;
	private CountDownLatch _latch;
	
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
			_latch.countDown();
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
