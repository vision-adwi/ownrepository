package com.pattern.behavioral.command.concrete;

import com.pattern.behavioral.command.Tax;

public class NGOTax implements Tax {

	@Override
	public void calculate() {
		System.out.println("There is no tax levied on NGO firms!!!");

	}

	@Override
	public void refund() {
		System.out
				.println("There is no refund calculated as there was no tax collected from the NGO firms.");

	}

	@Override
	public void sendNotice() {
		System.out.println("Though there is no tax was collected from any NGO firms but still there is mandate\n"
				+ "to file the IT returns. This notice is being sent under section 149A(4)of IT act\n"
				+ "to furnish the IT returns.");

	}

}
