package com.pattern.creational.singleton;
/*
Bill Pugh was the main force behind Java memory model changes. His principle “Initialization-on-demand holder idiom”
also uses static blocks but in a different way.
*/

public class BillPughSingleton {
	
	private BillPughSingleton() {
		
	}
	
	private static class Holder {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance() {
		return Holder.INSTANCE;
	}

}
