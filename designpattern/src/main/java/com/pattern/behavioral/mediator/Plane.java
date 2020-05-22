package com.pattern.behavioral.mediator;

public class Plane implements Runnable {
	String airlines;
	String number;
	int landingTime;
	ATController atcontroller;

	public Plane(String theAirlines, String theNumber, int theLandingTime,
			ATController theAtcontroller) {
		airlines = theAirlines;
		number = theNumber;
		landingTime = theLandingTime;
		atcontroller = theAtcontroller;
	}

	public String getAirlines() {
		return airlines;
	}

	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return number + "(" + airlines + " airlines)";
	}

	@Override
	public void run() {
		System.out.println(this + " trying to get the runway.");
		Runway runway = atcontroller.getRunway();
		System.out.println(this + " got the " + runway);
		System.out.println("Landing of " + this + " started. It will take " + landingTime + " seconds.");
		try {
			Thread.sleep(1000 * landingTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		atcontroller.releaseRunway();
	}

}
