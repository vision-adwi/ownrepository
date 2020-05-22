package com.pattern.behavioral.chainofresponsibility;

public abstract class DollarDispenser {
	protected final DollarDispenser nextDispenser;
	
	protected DollarDispenser(DollarDispenser dispenser) {
		nextDispenser = dispenser;
	}
	
	abstract public void dispense(Currency currency); 
}
