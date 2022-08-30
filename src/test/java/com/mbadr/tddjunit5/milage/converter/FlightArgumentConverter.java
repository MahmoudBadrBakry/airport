package com.mbadr.tddjunit5.milage.converter;

import com.mbadr.tddjunit5.airport.*;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightArgumentConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        assertEquals(String.class, source.getClass(), "Can only convert from String");
        assertEquals(Flight.class, targetType, "Can only convert to Flight");

        String[] flightArguments = ((String) source).split(";");

        Flight flight = null;

        switch (flightArguments[1].toLowerCase().trim()) {
            case "b":
                flight = new BusinessFlight(flightArguments[0]);
                break;
            case "p":
                flight = new PremiumFlight(flightArguments[0]);
                break;
            case "e":
                flight = new EconomyFlight(flightArguments[0]);
                break;
        }

        flight.addPassenger(new Passenger(flightArguments[2].trim(), Boolean.parseBoolean(flightArguments[3])));
        flight.setDistance(Long.parseLong(flightArguments[4]));
        return flight;
    }
}
