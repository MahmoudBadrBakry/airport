package com.pluralsight.tddjunit5.airport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {
    @Test
    public void testAirport() {
        Flight economyFlight = new Flight("1", "Economy");
        Flight businessFlight = new Flight("1", "Business");

        Passenger john = new Passenger("John", true);
        Passenger mike = new Passenger("mike", false);

        assertEquals(true, economyFlight.addPassenger(john));
        assertEquals(false, economyFlight.removePassenger(john));
        assertEquals(true, economyFlight.addPassenger(mike));
        assertEquals(true, economyFlight.removePassenger(mike));

        assertEquals(true, businessFlight.addPassenger(john));
        assertEquals(false, businessFlight.removePassenger(john));
        assertEquals(false, businessFlight.addPassenger(mike));
        assertEquals(false, businessFlight.removePassenger(mike));
    }
}
