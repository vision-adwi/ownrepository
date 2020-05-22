package com.pattern.behavioral.observer;

public abstract class Observer {
	protected Subject subject;
	
	protected Observer(Subject theSubject) {
		subject = theSubject;
		subject.addObserver(this);
	}
	
	public abstract void update();

}
