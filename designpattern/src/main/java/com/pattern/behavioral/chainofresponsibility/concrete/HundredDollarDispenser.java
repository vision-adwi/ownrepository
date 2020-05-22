package com.pattern.behavioral.chainofresponsibility.concrete;

import com.pattern.behavioral.chainofresponsibility.Currency;
import com.pattern.behavioral.chainofresponsibility.DollarDispenser;

public class HundredDollarDispenser extends DollarDispenser {

	public HundredDollarDispenser() {
		super(new FiftyDollarDispenser());
	}

	@Override
	public void dispense(Currency currency) {
		int denominators = currency.getAmount() / 100;
		if (denominators > 0) {
			System.out.println(denominators + " notes of 100$ currency.");
			
			int remainder = currency.getAmount() % 100;
			if (remainder > 0) {
				nextDispenser.dispense(new Currency(remainder));
			}
		} else {
			nextDispenser.dispense(currency);
		}

	}
}
