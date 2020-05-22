package com.pattern.behavioral.command;

public class Invoker {

	Command command;

	public Invoker(Command theCommand) {
		command = theCommand;
	}

	public void execute() {
		command.execute();
	}

}
