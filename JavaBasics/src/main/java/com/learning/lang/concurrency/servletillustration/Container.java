package com.learning.lang.concurrency.servletillustration;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Container {
	private ExecutorService threadPool = Executors.newFixedThreadPool(4);
	private static Container INSTANCE = new Container();
	
	public static Container getInstance() {
		return INSTANCE;
	}
	
	public ExecutorService getThreadPool() {
		return threadPool;
	}

	public static void main(String[] args) {
		// Get the threadpool of container
		ExecutorService threadPool = Container.getInstance().getThreadPool();
					
		Scanner scanner = new Scanner(System.in);
		while(true) {
			// Incoming request to be wrapped in an object
			String r = scanner.nextLine();
			Request req = new Request(r);
		
			// submit the task to the thread pool
			threadPool.execute(() -> initiateProcess(req));
			
		}

	}
	
	public static void initiateProcess(Request request) {
		Processor.getInstance().service(request);
	}

}
