package com.pluralsight.tddjunit5.airport;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

    @Nested
    @DisplayName("Given there a EconomyFlight")
    class EconomyFlightTest {
        Flight economyFlight;
        Passenger vipPassenger;
        Passenger passenger;

        @BeforeEach
        public void init() {
            economyFlight = new EconomyFlight("1");
            vipPassenger = new Passenger("Mahmoud Badr", true);
            passenger = new Passenger("ali", false);
        }

        @Nested
        @DisplayName("when we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("try to add or remove the passenger")
            public void economyFlightTestUsualPassenger() {
                assertAll("verify all conditions",
                        () -> assertEquals(true, economyFlight.addPassenger(passenger)),
                        () -> assertEquals("ali", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(passenger)),
                        () -> assertEquals(0, economyFlight.getPassengersList().size()),
                        () -> assertEquals("1", economyFlight.getId())
                );
            }
        }

        @Nested
        @DisplayName("when we have a vip passenger")
        class VipPassenger {
            @Test
            @DisplayName("try to add or remove the passenger")
            public void economyFlightTestUsualPassenger() {
                assertAll("verify all conditions",
                        () -> assertEquals(true, economyFlight.addPassenger(vipPassenger)),
                        () -> assertEquals(false, economyFlight.removePassenger(vipPassenger)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, vipPassenger.getName().equals("Mahmoud Badr"))
                );
            }

        }
    }

    @DisplayName("Given there is an business flight")
    @Nested
    class BusinessClassFlightTest {
        Flight businessFlight;
        Passenger vipPassenger;
        Passenger passenger;

        @BeforeEach
        public void init() {
            businessFlight = new BusinessFlight("1");
            vipPassenger = new Passenger("Mahmoud Badr", true);
            passenger = new Passenger("ali", false);
        }

        @Nested
        @DisplayName("when we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("try to add or remove the passenger")
            public void businessFlightTestUsualPassenger() {
                assertAll("verify all conditions",
                        () -> assertEquals(false, businessFlight.addPassenger(passenger)),
                        () -> assertEquals(false, businessFlight.removePassenger(passenger)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size()),
                        () -> assertEquals("1", businessFlight.getId())
                );
            }
        }

        @Nested
        @DisplayName("when we have a vip passenger")
        class VipPassenger {
            @Test
            @DisplayName("try to add or remove the passenger")
            public void businessFlightTestUsualPassenger() {
                assertAll("verify all conditions",
                        () -> assertEquals(true, businessFlight.addPassenger(vipPassenger)),
                        () -> assertEquals(false, businessFlight.removePassenger(vipPassenger)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size()),
                        () -> assertEquals("1", businessFlight.getId()),
                        () -> assertEquals(true, vipPassenger.getName().equals("Mahmoud Badr"))
                );
            }

        }

    }
}