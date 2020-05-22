package com.pattern.creational.builder;

import com.pattern.creational.builder.components.Engine;
import com.pattern.creational.builder.components.GPSNavigator;
import com.pattern.creational.builder.components.Transmission;
import com.pattern.creational.builder.components.TripComputer;

/**
 * Director defines the order of building steps. It works with a builder object
 * through common Builder interface. Therefore it may not know what product is
 * being built.
 */
public class Director {
	public void constructSportCar(Builder builder) {
		builder.setType(Type.SPORT);
		builder.setSeats(2);
		builder.setEngine(new Engine(3.0, 0));
		builder.setTransmission(Transmission.SEMI_AUTOMATIC);
		builder.setGPSNavigator(new GPSNavigator());
		builder.setTripComputer(new TripComputer());
		
	}

}
