package com.pattern.behavioral.chainofresponsibility.concrete;

import com.pattern.behavioral.chainofresponsibility.Currency;
import com.pattern.behavioral.chainofresponsibility.DollarDispenser;

public class FiveDollarDispenser extends DollarDispenser {

	public FiveDollarDispenser() {
		super(new TwoDollarDispenser());
	}

	@Override
	public void dispense(Currency currency) {
		int denominators = currency.getAmount() / 5;
		if (denominators > 0) {
			System.out.println(denominators + " notes of 5$ currency.");
			
			int remainder = currency.getAmount() % 5;
			if (remainder > 0) {
				nextDispenser.dispense(new Currency(remainder));
			}
		} else {
			nextDispenser.dispense(currency);
		}

	}

}
