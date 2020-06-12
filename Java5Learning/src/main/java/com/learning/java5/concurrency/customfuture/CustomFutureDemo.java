package com.learning.java5.concurrency.customfuture;

import java.util.Random;

public class CustomFutureDemo {
	public static void main(String[] s) throws InterruptedException {
		FutureWork<String> work = new FutureWork<>(new MyReceivable());
		
		Thread t = new Thread(work);
		t.start();

		System.out.println(work.returnObject());
		System.out.println("Value obtained...!!!!");
	}
	
	private static class MyReceivable implements Receivable<String> {

		@Override
		public String receive() {
			int i = new Random().nextInt();
			System.out.println("Print : " + i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Done";
		}
		
	}

}
