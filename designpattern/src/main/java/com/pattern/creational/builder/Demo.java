package com.pattern.creational.builder;

/*Builder is a creational design pattern, which allows constructing complex objects step by step.
Unlike other creational patterns, Builder doesn’t require products to have a common interface. 
That makes it possible to produce different products using the same construction process.*/
public class Demo {

	public static void main(String[] args) {
		Director theDirector = new Director();
		
		CarBuilder carBuilder = new CarBuilder();
		theDirector.constructSportCar(carBuilder);
		
		Car theCar = carBuilder.getResult();
		System.out.println("Car built: " + theCar.getType());
		
		CarManualBuilder manualBuilder = new CarManualBuilder();
		theDirector.constructSportCar(manualBuilder);
		
		Manual carManual = manualBuilder.getResult();
		System.out.println("Car manual built:\n" + carManual.print());

	}

}
