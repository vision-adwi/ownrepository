package com.pattern.behavioral.templatemethod.concrete;

import com.pattern.behavioral.templatemethod.HouseTemplate;

public class ConcreteHouse extends HouseTemplate {

	@Override
	protected void buildPillars() {
		System.out.println("Pillars are made of concrete and iron rod.");

	}

	@Override
	protected void buildWalls() {
		System.out.println("Walls of bricks are made.");

	}

}
