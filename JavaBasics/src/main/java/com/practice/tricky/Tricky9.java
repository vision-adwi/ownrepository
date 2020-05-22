package com.practice.tricky;

public class Tricky9 {

	public static void main(String[] args) {
		BaseIncrement d = new DerivedIncrement();
		System.out.println(d.i);

	}

}

class BaseIncrement {
	static int i = 100;
	//1
	static {
		i = i-- - --i; //100 - 98 = 2
		System.out.println("BaseIncrement - static : " + i);
	}
	//3
	{
		i = i++ + ++i; //0 + 2 = 2
		System.out.println("BaseIncrement : " + i);
	}
	
}

class DerivedIncrement extends BaseIncrement{
	//2
	static {
		i = --i - i--; //1 - 1 = 0
		System.out.println("DerivedIncrement - static : " + i);
	}
	//4
	{
		i = ++i + i++; //3 + 3 = 6
		System.out.println("DerivedIncrement : " + i);
	}
}
