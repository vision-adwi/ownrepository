package com.learning.java5.concurrency.countdownlatch;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		return new Thread(r);
	}

}
