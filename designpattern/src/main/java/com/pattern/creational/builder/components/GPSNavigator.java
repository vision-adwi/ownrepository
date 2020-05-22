package com.pattern.creational.builder.components;

/**
 * Just another feature of a car.
 */
public class GPSNavigator {
	private String route;
	
	public GPSNavigator() {
		route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
	}
	
	public GPSNavigator(String theRoute) {
		route = theRoute;
	}
	
	public String getRoute() {
		return route;
	}

}
