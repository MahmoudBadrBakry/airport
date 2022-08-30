package com.mbadr.tddjunit5.milage;


import com.mbadr.tddjunit5.airport.Passenger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Milage {
    private static final int VIP_FACTOR = 10;
    private static final int USUAL_FACTOR = 20;

    private Map<Passenger, Long> passengersMilageMap = new HashMap<>();
    private Map<Passenger, Long> passengersBonusPointsMap = new HashMap<>();

    public void addMilage(Passenger passenger, long miles) {
        if (passengersMilageMap.containsKey(passenger)) {
            passengersMilageMap.put(passenger, passengersMilageMap.get(passenger) + miles);
        } else {
            passengersMilageMap.put(passenger, miles);
        }
    }

    public void calculateGivenPoints() {
        for (Passenger passenger : passengersMilageMap.keySet()) {
            passengersBonusPointsMap.put(passenger,
                    passengersMilageMap.get(passenger) / getFactor(passenger));
        }
    }

    private long getFactor(Passenger passenger) {
        return passenger.isVip() ? VIP_FACTOR : USUAL_FACTOR;
    }

    public Map<Passenger, Long> getPassengersBonusPointsMap() {
        return Collections.unmodifiableMap(passengersBonusPointsMap);
    }

    @Override
    public String toString() {
        return "Milage{" +
                "passengersMilageMap=" + passengersMilageMap +
                ", passengersBonusPointsMap=" + passengersBonusPointsMap +
                '}';
    }
}
