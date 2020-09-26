package com.pattern.behavioral.observer;

public abstract class Observer {
	protected Subject subject;
	
	protected Observer(Subject theSubject) {
		subject = theSubject;
		selfReistry();
	}
	
	private void selfReistry() {
		subject.addObserver(this);
	}
	
	public abstract void update();

}
