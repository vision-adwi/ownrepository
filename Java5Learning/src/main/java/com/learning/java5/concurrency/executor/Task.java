package com.learning.java5.concurrency.executor;

public class Task implements Runnable{
	private String taskName;
	private int waitTime;
	
	public Task(String task, int wait) {
		taskName = task;
		waitTime = wait * 1000;
	}

	@Override
	public void run() {
		System.out.println("ThreadId(" + Thread.currentThread().getId() + "): " + taskName + " is started.");
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ThreadId(" + Thread.currentThread().getId() + "): " +taskName + " is finished.");
	}

}
