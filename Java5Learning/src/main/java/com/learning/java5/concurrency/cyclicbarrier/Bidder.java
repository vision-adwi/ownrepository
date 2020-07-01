package com.learning.java5.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;

public class Bidder implements Runnable {
	private static boolean announced = false;
	private String bidderName;
	private int preProcessTime;
	private CyclicBarrier barrier;
	//private Phaser phaser;

	public Bidder(String name, int time, CyclicBarrier theBarrier) {
		this.bidderName = name;
		this.preProcessTime = time;
		this.barrier = theBarrier;
	}

	public void run() {
		try {
			Thread.sleep(preProcessTime * 1000);
			System.out.println(Thread.currentThread().getId() + ":" + bidderName + " takes some time to be verified.");
			Thread.sleep(preProcessTime * 1000 * 2);
			int waitingFor = barrier.getParties() - barrier.getNumberWaiting() - 1;
			System.out.println(Thread.currentThread().getId() + ":" + bidderName + " is connected. Waiting for " + waitingFor + " to join.");
			barrier.await(); //blocking calls.. thread goes on wait state..
			//phaser.arriveAndAwaitAdvance(); //similar to above statement
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
