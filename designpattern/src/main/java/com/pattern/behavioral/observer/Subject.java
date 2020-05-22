package com.pattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<Observer> observers;
	private int state;
	
	public Subject() {
		observers = new ArrayList<>();
	}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int theState) {
		this.state = theState;
		execute();
	}
	
	private void execute() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

}
