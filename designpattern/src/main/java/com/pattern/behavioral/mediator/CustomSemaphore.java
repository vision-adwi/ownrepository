package com.pattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class CustomSemaphore {
	private List<Object> objects;
	private final int SIZE;
	
	public CustomSemaphore(int count) {
		SIZE = count;
		objects = new ArrayList<>(SIZE);
		for(int i = 0; i<count ; i++) {
			objects.add(new Object());
		}
	}
	
	public void acquire() throws InterruptedException {
		synchronized (objects) {
			if (objects.isEmpty()) {
				objects.wait();
				acquire();
			} else {
				objects.remove(objects.size()-1);
			}
		}
	}
	
	public void release() {
		synchronized(objects) {
			if(objects.size() != SIZE) {
				objects.add(new Object());
				objects.notifyAll();
			}
		}
	}
	
	public int size() {
		return SIZE;
	}

}
