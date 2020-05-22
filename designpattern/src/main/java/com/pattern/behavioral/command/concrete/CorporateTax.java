package com.pattern.behavioral.command.concrete;

import com.pattern.behavioral.command.Tax;

public class CorporateTax implements Tax {

	@Override
	public void calculate() {
		System.out.println("Corporate tax is being calculated as per prescribed categories.\n"
				+ "New startup(under Rs Lacs 25)    	- Exempted for first 3 years\n"
				+ "Small scale industry				   	- 10%\n"
				+ "Medium scale industry(upto 1 Cr)  	- 17%\n"
				+ "Large scale industry 				- 22%");

	}

	@Override
	public void refund() {
		System.out.println("Refund of the firm is adjusted against considering all the GST and Corporate establishments law. Remaining amount "
				+ "is forwarded for the subsequent financial year.");

	}

	@Override
	public void sendNotice() {
		// TODO Auto-generated method stub

	}

}
