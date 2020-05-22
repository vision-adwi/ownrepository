package com.pattern.behavioral.chainofresponsibility.concrete;

import com.pattern.behavioral.chainofresponsibility.Currency;
import com.pattern.behavioral.chainofresponsibility.DollarDispenser;

public class TwoDollarDispenser extends DollarDispenser {

	public TwoDollarDispenser() {
		super(new OneDollarDispenser());
	}

	@Override
	public void dispense(Currency currency) {
		int denominators = currency.getAmount() / 2;
		if (denominators > 0) {
			System.out.println(denominators + " notes of 2$ currency.");
			
			int remainder = currency.getAmount() % 2;
			if (remainder > 0) {
				nextDispenser.dispense(new Currency(remainder));
			}
		} else {
			nextDispenser.dispense(currency);
		}

	}

}
