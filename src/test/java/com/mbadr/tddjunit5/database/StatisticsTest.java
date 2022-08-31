package com.mbadr.tddjunit5.database;

import com.mbadr.tddjunit5.MockitoExtension;
import com.mbadr.tddjunit5.airport.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class StatisticsTest {
    @Spy
    private Database database;

    private List<Flight> flights;
    private List<List<String>> queriedData;

    @BeforeEach
    public void init() {
        queriedData = new ArrayList<>();
        List<String> row1 = Arrays.asList("1", "e", "Mike", "false", "349");
        List<String> row2 = Arrays.asList("2", "b", "John", "true", "278");
        List<String> row3 = Arrays.asList("3", "e", "Mike", "false", "319");
        List<String> row4 = Arrays.asList("4", "p", "John", "true", "817");
        List<String> row5 = Arrays.asList("5", "e", "Mike", "false", "623");
        List<String> row6 = Arrays.asList("6", "e", "John", "true", "978");
        queriedData.add(row1);
        queriedData.add(row2);
        queriedData.add(row3);
        queriedData.add(row4);
        queriedData.add(row5);
        queriedData.add(row6);
    }

    @Test
    public void testQueriedData() {
        when(database.queryFlightDatabase()).thenReturn(queriedData);
        flights = DatabaseUtils.buildFlightsList(queriedData);
        assertEquals(6, database.queryFlightDatabase().size());
        assertEquals(6, flights.size());
        assertEquals(560.666, database.averageDistance(flights), .001);
        assertEquals(278, database.minDistance(flights));
        assertEquals(978, database.maxDistance(flights));
    }

}
