package com.pattern.behavioral.command.concrete;

import com.pattern.behavioral.command.Command;
import com.pattern.behavioral.command.Tax;

public class CalculateTaxCommand extends Command {
	
	public CalculateTaxCommand(Tax theCategory) {
		super(theCategory);
	}

	@Override
	public void execute() {
		taxCategory.calculate();
	}

}
