package com.pattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class ATController {
	List<Runway> runways = new ArrayList<>();
	Map<Long, Runway> flightMap = new HashMap<>();

	CustomSemaphore semaphore;

	public ATController(int runwayCount) {
		semaphore = new CustomSemaphore(runwayCount);
	}
	

	public void registerRunway(Runway runway) {
		if (runways.size() >= semaphore.size()) {
			System.out.println("No new runway can be added. Registration of runway " + runway + " discarded.");
		} else {
			runways.add(runway);
		}
	}

	public Runway getRunway() {
		long planeThread = Thread.currentThread().getId();
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Runway theRunway = null;
		synchronized (this) {
			theRunway = runways.remove(runways.size() - 1);
			flightMap.put(planeThread, theRunway);
		}

		return theRunway;
	}

	public synchronized void releaseRunway() {
		long planeThread = Thread.currentThread().getId();
		Runway theRunway = flightMap.remove(planeThread);
		runways.add(theRunway);
		System.out.println(theRunway + " is freed.");
		semaphore.release();
	}

}
