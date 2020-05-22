package com.pattern.behavioral.chainofresponsibility.concrete;

import com.pattern.behavioral.chainofresponsibility.Currency;
import com.pattern.behavioral.chainofresponsibility.DollarDispenser;

public class OneDollarDispenser extends DollarDispenser {

	public OneDollarDispenser() {
		super(null);
	}

	@Override
	public void dispense(Currency currency) {
		System.out.println(currency.getAmount() + " notes of 1$ currency.");

	}

}