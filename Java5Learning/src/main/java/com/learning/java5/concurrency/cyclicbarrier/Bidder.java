package com.learning.java5.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Bidder implements Runnable {
	private static boolean announced = false;
	private String bidderName;
	private int preProcessTime;
	private CyclicBarrier barrier;

	public Bidder(String name, int time, CyclicBarrier theBarrier) {
		this.bidderName = name;
		this.preProcessTime = time;
		this.barrier = theBarrier;
	}

	public void run() {
		try {
			Thread.sleep(preProcessTime * 1000);
			System.out.println(bidderName + " takes some time to be verified.");
			Thread.sleep(preProcessTime * 1000 * 2);
			System.out.println(bidderName + " is connected. Waiting for others to join.");
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		synchronized(Bidder.class) {
			if(!announced) {
				announced = true;
				System.out.println("All biddes are joined and setup. Start bidding.");
			}
		}
	}

}
