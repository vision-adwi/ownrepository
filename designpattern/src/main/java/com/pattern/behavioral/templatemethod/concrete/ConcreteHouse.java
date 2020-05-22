package com.pattern.behavioral.templatemethod.concrete;

import com.pattern.behavioral.templatemethod.HouseTemplate;

public class ConcreteHouse extends HouseTemplate {

	@Override
	public void buildPillars() {
		System.out.println("Pillars are made of concrete and iron rod.");

	}

	@Override
	public void buildWalls() {
		System.out.println("Walls of bricks are made.");

	}

}
