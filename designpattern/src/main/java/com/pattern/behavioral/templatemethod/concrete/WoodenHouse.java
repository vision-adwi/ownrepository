package com.pattern.behavioral.templatemethod.concrete;

import com.pattern.behavioral.templatemethod.HouseTemplate;

public class WoodenHouse extends HouseTemplate {

	@Override
	protected void buildPillars() {
		System.out.println("Pillar of wooden logs are built.");

	}

	@Override
	protected void buildWalls() {
		System.out.println("Walls of wood plates are made.");

	}

}
