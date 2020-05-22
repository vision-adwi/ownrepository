package com.pattern.structural.bridge;

import com.pattern.structural.bridge.devices.Ipad;
import com.pattern.structural.bridge.devices.Laptop;
import com.pattern.structural.bridge.devices.Mobile;
import com.pattern.structural.bridge.devices.Television;
import com.pattern.structural.bridge.tv.AmazonPrime;
import com.pattern.structural.bridge.tv.HotStar;
import com.pattern.structural.bridge.tv.SonyLIV;
import com.pattern.structural.bridge.tv.Voot;
/*
It lets you split a large class or a set of closely related classes into two separate hierarchies
abstraction and implementation which can be developed independently of each other.
- Abstraction
- Refined Abstraction
- Implementer
- Concrete Implementation
*/
import com.pattern.structural.bridge.tv.ZeePlus;

public class Program {

	public static void main(String[] args) {
		Device device = new Ipad(new HotStar());
		System.out.println(device.playOn());
		
		device = new Laptop(new ZeePlus());
		System.out.println(device.playOn());
		
		device = new Television(new Voot());
		System.out.println(device.playOn());
		
		device = new Mobile(new AmazonPrime());
		System.out.println(device.playOn());
		
		device = new Television(new SonyLIV());
		System.out.println(device.playOn());
	}

}
