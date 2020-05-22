package com.learning.java5.concurrency.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
	public static void main(String[] s) throws InterruptedException, ExecutionException {
		List<Task> taskList = new ArrayList<>();

		taskList.add(new Task("Task 1", 5));
		taskList.add(new Task("Task 2", 6));
		taskList.add(new Task("Task 3", 7));
		taskList.add(new Task("Task 4", 8));
		taskList.add(new Task("Task 5", 9));
		
		//singleThreadedExecutorTest(taskList);
		//scheduledPoolExecutorTest();
		futureCall();
	}
	
	private static void scheduledPoolExecutorTest() {
		ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(3);
		
		scheduledExecutor.schedule(() -> System.out.println("After 10 seconds..."), 10, TimeUnit.SECONDS);
		scheduledExecutor.scheduleAtFixedRate(() -> System.out.println("Start after 30 seconds and run every 10 seonds"), 
				30, 10, TimeUnit.SECONDS);
	}
	
	private static void singleThreadedExecutorTest(List<? extends Runnable> tasks) {
		ExecutorService singleThreaded = Executors.newSingleThreadExecutor();
		
		for(Runnable runnable : tasks) {
			singleThreaded.execute(runnable);
		}
		
		try {
			singleThreaded.shutdown();
			singleThreaded.awaitTermination(2, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All tasks executed by a single thread is completed by now.");
		
	}
	
	private static void futureCall() throws InterruptedException, ExecutionException {
		Callable<Integer> callable = new Callable<Integer>() {
			public Integer call() {
				System.out.println("ThreadId(" + Thread.currentThread().getId()
						+ ")");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				return new Random().nextInt();
			}
		};

		List<Future<Integer>> allFutures = new ArrayList<>();

		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 15; i++) {
			Future<Integer> future = fixedThreadPool.submit(callable);
			allFutures.add(future);
		}
		
		for (Future<Integer> future : allFutures) {
			System.out.println(future.get());
		}
	}

}
