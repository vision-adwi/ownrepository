package com.pattern.behavioral.templatemethod.concrete;

import com.pattern.behavioral.templatemethod.HouseTemplate;

public class GlassHouse extends HouseTemplate {

	@Override
	protected void buildPillars() {
		System.out.println("Pillars made of glass coating.");

	}

	@Override
	protected void buildWalls() {
		System.out.println("Glass walls built.");

	}

}
