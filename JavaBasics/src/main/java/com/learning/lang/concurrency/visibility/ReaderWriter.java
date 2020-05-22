package com.learning.lang.concurrency.visibility;

public class ReaderWriter {
	private boolean flag = false;
	
	public void write() {
		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		flag = true;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void read() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The value is: " + flag);
	}

}
