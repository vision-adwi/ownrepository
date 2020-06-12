package com.learning.java5.concurrency.callableandfuture;

public class FutureWork<T> implements Runnable {
	private T obj;
	private Receivable<T> receivable;
	boolean valueSet = false;

	public FutureWork(Receivable<T> receivable) {
		this.receivable = receivable;
	}

	@Override
	public void run() {
		obj = receivable.receive();
		valueSet = true;
		synchronized (this) {
			notifyAll();
		}
	}

	public T returnObject() throws InterruptedException {
		while (!valueSet) {
			synchronized (this) {
				wait();
			}
		}
		return obj;
	}

}
