package com.pattern.behavioral.command;

public abstract class Command {

	protected Tax taxCategory;

	public Command(Tax theCategory) {
		taxCategory = theCategory;
	}

	public abstract void execute();
}
