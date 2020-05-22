package com.pattern.behavioral.observer.concrete;

import com.pattern.behavioral.observer.Observer;
import com.pattern.behavioral.observer.Subject;

public class HexObserver extends Observer {
	
	public HexObserver(Subject subject) {
		super(subject);
	}

	@Override
	public void update() {
		System.out.println("Hex: " + Integer.toHexString(subject.getState()));

	}

}
