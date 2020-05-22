package com.learning.java5.concurrency.threadlocal;

/*ThreadLocal is there since java 1.2*/
public class ThreadWithId implements Runnable {

	int magicValue = 450;
	private static final ThreadLocal<String> threadValue = new ThreadLocal<String>() {
		@Override
		public String initialValue() {
			return Thread.currentThread().getName() + "_" + Thread.currentThread().getId();
		}
	};

	@Override
	public void run() {
		int counter = 5;
		while (counter-- > 0) {
			System.out.println("Running with thread id - "
					+ Thread.currentThread().getId() + " Magic value "
					+ magicValue + " Thread variable - " + threadValue.get());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
