package com.pattern.behavioral.observer.concrete;

import com.pattern.behavioral.observer.Observer;
import com.pattern.behavioral.observer.Subject;

public class OctObserver extends Observer {

	public OctObserver(Subject subject) {
		super(subject);
	}

	@Override
	public void update() {
		System.out.println("Oct: " + Integer.toOctalString(subject.getState()));

	}

}
