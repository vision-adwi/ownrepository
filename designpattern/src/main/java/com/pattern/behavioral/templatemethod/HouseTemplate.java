package com.pattern.behavioral.templatemethod;

public abstract class HouseTemplate {
	
	//Template method. Should not be overridden by sub classes. 
	public final void buildHouse() {
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built..!!");
		
	}

	//Default implementation
	protected void buildWindows() {
		System.out.println("Building framed window.");
		
	}

	protected abstract void buildPillars(); 
	protected abstract void buildWalls();

	//Invariant(or standard) step.
	private final void buildFoundation() {
		System.out.println("Building Foundation with cement, iron rods and sand.");
	}

}
