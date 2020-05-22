package com.pattern.behavioral.chainofresponsibility.concrete;

import com.pattern.behavioral.chainofresponsibility.Currency;
import com.pattern.behavioral.chainofresponsibility.DollarDispenser;

public class FiftyDollarDispenser extends DollarDispenser {

	public FiftyDollarDispenser() {
		super(new TwentyDollarDispenser());
	}

	@Override
	public void dispense(Currency currency) {
		int denominators = currency.getAmount() / 50;
		if (denominators > 0) {
			System.out.println(denominators + " notes of 50$ currency.");
			
			int remainder = currency.getAmount() % 50;
			if (remainder > 0) {
				nextDispenser.dispense(new Currency(remainder));
			}
		} else {
			nextDispenser.dispense(currency);
		}

	}

}
