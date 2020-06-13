package com.learning.lang.concurrency.servletillustration;

public class Processor {
	private static Processor INSTANCE = new Processor();
	
	private Processor() {
	}
	
	public static Processor getInstance() {
		return INSTANCE;
	}
	
	public void service(Request request) {
		System.out.println("Process started for - " + request.getRequester());
		try {
			Thread.sleep(45000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Process done for - " + request.getRequester());
	}

}
