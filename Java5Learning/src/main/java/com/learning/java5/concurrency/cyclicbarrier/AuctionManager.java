package com.learning.java5.concurrency.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AuctionManager {

	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(4);

		List<Runnable> allBidders = new ArrayList<>();
		allBidders.add(new Bidder("BidderA", 12, barrier));
		allBidders.add(new Bidder("BidderB", 8, barrier));
		allBidders.add(new Bidder("BidderC", 28, barrier));
		allBidders.add(new Bidder("BidderD", 15, barrier));

		ExecutorService executor = Executors.newFixedThreadPool(4);
		for (Runnable task : allBidders) {
			executor.execute(task);
		}
		executor.shutdown();
		executor.awaitTermination(2, TimeUnit.MINUTES);

	}

}
