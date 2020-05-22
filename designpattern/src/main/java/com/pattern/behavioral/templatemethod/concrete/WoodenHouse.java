package com.pattern.behavioral.templatemethod.concrete;

import com.pattern.behavioral.templatemethod.HouseTemplate;

public class WoodenHouse extends HouseTemplate {

	@Override
	public void buildPillars() {
		System.out.println("Pillar of wooden logs are built.");

	}

	@Override
	public void buildWalls() {
		System.out.println("Walls of wood plates are made.");

	}

}
