package com.learning.java5.concurrency.customfuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> task = new FutureTask<>(new Callable<String>() {
			public String call() {
				return "Hello Future";
			}
		});

		Thread t = new Thread(task);
		t.start();

		System.out.println(task.get());
	}

}
