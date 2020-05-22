package com.pattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;
/*
Mediator enables decoupling of objects by introducing a layer in between so that the interaction between objects happen via the layer.
*/
public class AirportManager {
	public static void main(String[] s) {
		ATController controller = new ATController(2);

		new Runway("Landing point 1", controller);
		new Runway("Landing point 2", controller);
		
		List<Thread> planes = new ArrayList<>();
		planes.add(new Thread(new Plane("Lufthansa", "L378", 60, controller)));
		planes.add(new Thread(new Plane("Dragon Air", "DA44", 75, controller)));
		planes.add(new Thread(new Plane("Sky Air", "Sky404", 90, controller)));
		planes.add(new Thread(new Plane("Etihaad", "EL55", 200, controller)));
		planes.add(new Thread(new Plane("SriLankan Air", "SL1011", 150, controller)));
		
		for(Thread plane:planes) {
			plane.start();
		}
	}

}
