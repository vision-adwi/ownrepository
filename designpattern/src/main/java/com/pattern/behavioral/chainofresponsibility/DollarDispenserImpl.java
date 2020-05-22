package com.pattern.behavioral.chainofresponsibility;

import com.pattern.behavioral.chainofresponsibility.concrete.HundredDollarDispenser;

public class DollarDispenserImpl extends DollarDispenser {
	
	public DollarDispenserImpl() {
		super(new HundredDollarDispenser());
	}

	@Override
	public void dispense(Currency currency) {
		nextDispenser.dispense(currency);

	}

}
