package com.mbadr.tddjunit5.milage;

import com.mbadr.tddjunit5.airport.Flight;
import com.mbadr.tddjunit5.airport.Passenger;
import com.mbadr.tddjunit5.milage.converter.FlightArgumentConverter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MilageTest {
    private Milage milage;

    @BeforeAll()
    public void beforeAll() {
        milage = new Milage();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/resource.csv")
    public void checkGivenPointsFromFile(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
        for (Passenger passenger : flight.getPassengersSet()) {
            milage.addMilage(passenger, flight.getDistance());
        }
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {"1;e;Mike;false;349", "2;b;Mahmoud;true;278", "3;p;Madonna;true;340"})
    public void checkGivenPoints(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
        for (Passenger passenger : flight.getPassengersSet()) {
            milage.addMilage(passenger, flight.getDistance());
        }
    }

    @AfterAll
    void afterAll() {
        milage.calculateGivenPoints();
        System.out.println(milage.getPassengersBonusPointsMap());
        assertEquals(17L, (long)milage.getPassengersBonusPointsMap().get(
                new Passenger("Mike", false)));
        assertEquals(27, (long)milage.getPassengersBonusPointsMap().get(
                new Passenger("Mahmoud", true)));
    }
}
