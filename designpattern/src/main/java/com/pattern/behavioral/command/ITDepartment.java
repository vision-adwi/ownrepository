package com.pattern.behavioral.command;

import com.pattern.behavioral.command.concrete.CalculateTaxCommand;
import com.pattern.behavioral.command.concrete.IndividualTax;
import com.pattern.behavioral.command.concrete.NGOTax;
import com.pattern.behavioral.command.concrete.SendNoticeCommand;

/*Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. */
public class ITDepartment {

	public static void main(String[] args) {
		Command command = new CalculateTaxCommand(new IndividualTax());
		Invoker invoker = new Invoker(command);

		invoker.execute();
		
		command = new SendNoticeCommand(new NGOTax());
		invoker = new Invoker(command);

		invoker.execute();

	}

}
