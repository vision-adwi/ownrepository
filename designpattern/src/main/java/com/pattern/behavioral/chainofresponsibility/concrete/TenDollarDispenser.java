package com.pattern.behavioral.chainofresponsibility.concrete;

import com.pattern.behavioral.chainofresponsibility.Currency;
import com.pattern.behavioral.chainofresponsibility.DollarDispenser;

public class TenDollarDispenser extends DollarDispenser {

	public TenDollarDispenser() {
		super(new FiveDollarDispenser());
	}

	@Override
	public void dispense(Currency currency) {
		int denominators = currency.getAmount() / 10;
		if (denominators > 0) {
			System.out.println(denominators + " notes of 10$ currency.");
			
			int remainder = currency.getAmount() % 10;
			if (remainder > 0) {
				nextDispenser.dispense(new Currency(remainder));
			}
		} else {
			nextDispenser.dispense(currency);
		}

	}

}
