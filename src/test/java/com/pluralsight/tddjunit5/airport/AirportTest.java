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
                        () -> assertTrue(economyFlight.addPassenger(passenger)),
                        () -> assertEquals("ali", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertTrue(economyFlight.removePassenger(passenger)),
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
            public void economyFlightTestVipPassenger() {
                assertAll("verify all conditions",
                        () -> assertTrue(economyFlight.addPassenger(vipPassenger)),
                        () -> assertFalse(economyFlight.removePassenger(vipPassenger)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals("Mahmoud Badr", vipPassenger.getName())
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
                        () -> assertFalse(businessFlight.addPassenger(passenger)),
                        () -> assertFalse(businessFlight.removePassenger(passenger)),
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
            public void businessFlightTestVipPassenger() {
                assertAll("verify all conditions",
                        () -> assertTrue(businessFlight.addPassenger(vipPassenger)),
                        () -> assertFalse(businessFlight.removePassenger(vipPassenger)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size()),
                        () -> assertEquals("1", businessFlight.getId()),
                        () -> assertEquals("Mahmoud Badr", vipPassenger.getName())
                );
            }

        }

    }


    @DisplayName("Given there is an premium flight")
    @Nested
    class PremiumClassFlightTest {
        Flight premiumFlight;
        Passenger vipPassenger;
        Passenger passenger;

        @BeforeEach
        public void init() {
            premiumFlight = new PremuimFlight("1");
            vipPassenger = new Passenger("Mahmoud Badr", true);
            passenger = new Passenger("ali", false);
        }

        @Nested
        @DisplayName("when we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("try to add or remove the passenger")
            public void premiumFlightTestUsualPassenger() {
                assertAll("verify all conditions",
                        () -> assertFalse(premiumFlight.addPassenger(passenger)),
                        () -> assertFalse(premiumFlight.removePassenger(passenger)),
                        () -> assertEquals(0, premiumFlight.getPassengersList().size()),
                        () -> assertEquals("1", premiumFlight.getId())
                );
            }
        }

        @Nested
        @DisplayName("when we have a vip passenger")
        class VipPassenger {
            @Test
            @DisplayName("try to add or remove the passenger")
            public void premiumFlightTestVipPassenger() {
                assertAll("verify all conditions",
                        () -> assertTrue(premiumFlight.addPassenger(vipPassenger), "vip passenger should be added"),
                        () -> assertEquals("Mahmoud Badr", vipPassenger.getName()),
                        () -> assertTrue(premiumFlight.removePassenger(vipPassenger)),
                        () -> assertEquals(0, premiumFlight.getPassengersList().size()),
                        () -> assertEquals("1", premiumFlight.getId())
                );
            }

        }

    }
}