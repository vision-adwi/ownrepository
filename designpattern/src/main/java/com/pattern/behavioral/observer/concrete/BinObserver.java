package com.pattern.behavioral.observer.concrete;

import com.pattern.behavioral.observer.Observer;
import com.pattern.behavioral.observer.Subject;

public class BinObserver extends Observer {

	public BinObserver(Subject subject) {
		super(subject);
	}

	@Override
	public void update() {
		System.out.println("Bin: " + Integer.toBinaryString(subject.getState()));

	}

}
