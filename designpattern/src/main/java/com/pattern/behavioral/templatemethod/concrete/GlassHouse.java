package com.pattern.behavioral.templatemethod.concrete;

import com.pattern.behavioral.templatemethod.HouseTemplate;

public class GlassHouse extends HouseTemplate {

	@Override
	public void buildPillars() {
		System.out.println("Pillars made of glass coating.");

	}

	@Override
	public void buildWalls() {
		System.out.println("Glass walls built.");

	}

}
