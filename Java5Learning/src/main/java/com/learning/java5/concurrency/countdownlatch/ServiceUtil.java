package com.learning.java5.concurrency.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;

public class ServiceUtil {
	public static void startServices() {
		List<Thread> services = new ArrayList<>();
		ThreadFactory factory = new CustomThreadFactory();

		CountDownLatch latch = new CountDownLatch(3);
		services.add(factory.newThread(new TelecomService(latch)));
		services.add(factory.newThread(new RadarService(latch)));
		services.add(factory.newThread(new InternetService(latch)));
		
		for(Thread service:services) {
			service.start();
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All services are up by now.");
	}

}
