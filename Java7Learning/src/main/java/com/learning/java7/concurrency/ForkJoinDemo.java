package com.learning.java7.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
/*
A ForkJoinPool provides the entry point for submissions from non-ForkJoinTask clients, as well as management and monitoring operations.
A ForkJoinPool differs from other kinds of ExecutorService mainly by virtue of employing work-stealing: all threads in the pool attempt 
to find and execute tasks submitted to the pool
*/
public class ForkJoinDemo {

	public static void main(String[] args) {
		//System.out.println("Available processor - " + Runtime.getRuntime().availableProcessors());
		ForkJoinPool pool = new ForkJoinPool(4);
		taskDemo(pool);
		//actionDemo(pool);
	}
	
	private static void actionDemo(ForkJoinPool pool) {
		RecursiveAction action = new CustomAction(122);
		//Way-1
		pool.invoke(action);
		//Way-2
		//pool.execute(action);
		//action.join();
	}
	
	private static void taskDemo(ForkJoinPool pool) {
		CustomTask task = new CustomTask(16);
		//Way-1
		//System.out.println(pool.invoke(task));
		//Way-2
		pool.execute(task);
		System.out.println(task.join());
		
	}

}
