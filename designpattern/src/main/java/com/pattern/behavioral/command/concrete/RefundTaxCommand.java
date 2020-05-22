package com.pattern.behavioral.command.concrete;

import com.pattern.behavioral.command.Command;
import com.pattern.behavioral.command.Tax;

public class RefundTaxCommand extends Command {
	
	public RefundTaxCommand(Tax theCategory) {
		super(theCategory);
	}

	@Override
	public void execute() {
		taxCategory.refund();
	}

}
