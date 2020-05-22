package com.pattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class ATController {
	List<Runway> runways = new ArrayList<>();
	Map<Long, Runway> flightMap = new HashMap<>();
	//Semaphore semaphore;
	CustomSemaphore semaphore;
	final int RUNWAYS_COUNT;
	
	public ATController(int runwayCount) {
		RUNWAYS_COUNT = runwayCount;
		semaphore = new CustomSemaphore(RUNWAYS_COUNT);
		//semaphore = new Semaphore(RUNWAYS_COUNT);
	}
	

	public void registerRunway(Runway runway) {
		if (runways.size() == RUNWAYS_COUNT) {
			System.out.println("Now new runway can be added. Registration of runway " + runway + " discarded.");
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
