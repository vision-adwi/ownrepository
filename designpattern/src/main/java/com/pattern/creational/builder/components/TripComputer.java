package com.pattern.creational.builder.components;

import com.pattern.creational.builder.Car;

/**
 * Just another feature of a car.
 */
public class TripComputer {
	Car car;
	
	public void setCar(Car theCar) {
		car = theCar;
	}
	
	public void showFuelLevel() {
		System.out.println("Fuel level : " + car.getFuel());
	}
	
	public void showStatus() {
        if (this.car.getEngine().isStarted()) {
            System.out.println("Car is started");
        } else {
            System.out.println("Car isn't started");
        }
	}

}
