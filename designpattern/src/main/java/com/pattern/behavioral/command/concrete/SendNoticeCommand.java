package com.pattern.behavioral.command.concrete;

import com.pattern.behavioral.command.Command;
import com.pattern.behavioral.command.Tax;

public class SendNoticeCommand extends Command {
	
	public SendNoticeCommand(Tax theCategory) {
		super(theCategory);
	}

	@Override
	public void execute() {
		taxCategory.sendNotice();
	}

}
