package com.learning.java5.concurrency.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ControlRoom {

	public static void upAllServices() {
		List<Service> services = new ArrayList<>();

		CountDownLatch latch = new CountDownLatch(3);
		services.add(new TelecomService(latch));
		services.add(new RadarService(latch));
		services.add(new InternetService(latch));
		
		Executor executor = Executors.newFixedThreadPool(services.size());
		
		for(Service service:services) {
			executor.execute(service);
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (Service service : services) {
			System.out.println(service.getService() + " is "
					+ (service.isServiceUp() ? "Up" : "Down"));
		}
		
	}

}
