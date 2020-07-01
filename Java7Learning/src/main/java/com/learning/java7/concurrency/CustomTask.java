package com.learning.java7.concurrency;

import java.util.concurrent.RecursiveTask;

public class CustomTask extends RecursiveTask<String> {
	int task;
	String msg = "Hare Krishna Hare Ram";
	
	public CustomTask(int task) {
		this.task = task;
	}

	@Override
	protected String compute() {
		String resultant;
		if(task <= 2) {
			resultant = msg + "!!! " + msg + "!!!\n";
		}
		else {
			CustomTask task1 = new CustomTask(task/2);
			CustomTask task2 = new CustomTask(task/2);
			//Way-1
			//resultant = task1.invoke() + task2.invoke();
			//Way-2
			task1.fork();
			task2.fork();
			
			resultant = task1.join() + task2.join();
		}

		return resultant;
	}

}
