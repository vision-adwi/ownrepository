package com.pattern.behavioral.chainofresponsibility.concrete;

import com.pattern.behavioral.chainofresponsibility.Currency;
import com.pattern.behavioral.chainofresponsibility.DollarDispenser;

public class TwentyDollarDispenser extends DollarDispenser {

	public TwentyDollarDispenser() {
		super(new TenDollarDispenser());
	}

	@Override
	public void dispense(Currency currency) {
		int denominators = currency.getAmount() / 20;
		if (denominators > 0) {
			System.out.println(denominators + " notes of 20$ currency.");
			
			int remainder = currency.getAmount() % 20;
			if (remainder > 0) {
				nextDispenser.dispense(new Currency(remainder));
			}
		} else {
			nextDispenser.dispense(currency);
		}

	}

}
