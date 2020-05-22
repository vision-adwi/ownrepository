package com.pattern.creational.builder.components;

/**
 * Just another feature of a car.
 */
public class Engine {
	private final double volume;
	private double mileage;
	private boolean started;
	
	public Engine(double theVolume, double theMileage) {
		volume = theVolume;
		mileage = theMileage;
	}
	
	public void on() {
		started = true;
	}
	
	public void off() {
		started = false;
	}
	
	public void go(double mileage) {
        if (started) {
            this.mileage += mileage;
        } else {
            System.err.println("Cannot go(), you must start engine first!");
        }
    }
	
	public boolean isStarted() {
		return started;
	}
	
	public double getVolume() {
		return volume;
	}
	
	public double getMileage() {
		return mileage;
	}

}
