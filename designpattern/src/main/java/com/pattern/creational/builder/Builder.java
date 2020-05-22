package com.pattern.creational.builder;

import com.pattern.creational.builder.components.Engine;
import com.pattern.creational.builder.components.GPSNavigator;
import com.pattern.creational.builder.components.Transmission;
import com.pattern.creational.builder.components.TripComputer;
/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setType(Type type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);

}
