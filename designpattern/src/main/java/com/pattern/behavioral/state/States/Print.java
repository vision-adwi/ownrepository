package com.pattern.behavioral.state.States;

public class Print extends State {
	private static State INSTANCE;

	private Print() {
	}
	
	public static State getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Print();
		}
		return INSTANCE;
	}
	@Override
	public String stateMessge() {
		return "File is being printed.";
	}
}
