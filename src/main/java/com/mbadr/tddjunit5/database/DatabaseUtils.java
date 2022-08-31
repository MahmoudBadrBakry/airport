package com.mbadr.tddjunit5.database;

import com.mbadr.tddjunit5.airport.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
    private DatabaseUtils() {
    }

    public static List<Flight> buildFlightsList(List<List<String>> queriedData) {
        List<Flight> flights = new ArrayList<>();
        for (List<String> row : queriedData) {
            Flight flight = null;
            switch (row.get(1).toLowerCase().trim()) {
                case "b":
                    flight = new BusinessFlight(row.get(0));
                    break;
                case "p":
                    flight = new PremiumFlight(row.get(0));
                    break;
                case "e":
                    flight = new EconomyFlight(row.get(0));
                    break;
            }
            flight.addPassenger(new Passenger(row.get(2).trim(), Boolean.valueOf(row.get(3))));
            flight.setDistance(Long.valueOf(row.get(4)));
            flights.add(flight);
        }
        return flights;
    }
}
