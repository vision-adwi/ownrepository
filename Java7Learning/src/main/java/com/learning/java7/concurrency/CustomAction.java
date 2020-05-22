package com.learning.java7.concurrency;

import java.util.concurrent.RecursiveAction;

public class CustomAction extends RecursiveAction{
	int tasks;
	String threadName;
	public CustomAction(int howMany) {
		tasks = howMany;
		threadName = tasks + "_task";
	}

	@Override
	protected void compute() {
		if(tasks > 16) {//Threshold
			//Break in to tasks
			RecursiveAction action_left = new CustomAction(tasks/2);
			RecursiveAction action_right = new CustomAction(tasks/2);
			
			//Way-1
			action_left.invoke();
			action_right.invoke();
			
			//Way-2
			//action_left.fork();
			//action_right.fork();
			//action_left.join();
			//action_right.join();
		}
		else {//do by yourself
			System.out.println(Thread.currentThread().getId() + ": I am doing " + tasks + " tasks");
		}
		
	}

}
