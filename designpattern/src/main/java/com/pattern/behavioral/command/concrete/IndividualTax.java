package com.pattern.behavioral.command.concrete;

import com.pattern.behavioral.command.Tax;

public class IndividualTax implements Tax {

	@Override
	public void calculate() {
		System.out.println("Tax is being calculated as per below tax slabs.\n"
				+ "0 - 250000        - Nil\n"
				+ "250000 - 500000   - 5%\n"
				+ "500000 - 1000000  - 20%\n"
				+ "1000000 and above - 30%");

	}

	@Override
	public void refund() {
		System.out.println("Your refund is settled in the category of individual income tax under the section of 139(1).");

	}

	@Override
	public void sendNotice() {
		System.out.println("There is tax descrepancies shown in the form 26(b) and the returns submitted by you.\n"
				+ "This notice is being sent under section 143(1)of IT act to take appropriate action.");

	}

}
