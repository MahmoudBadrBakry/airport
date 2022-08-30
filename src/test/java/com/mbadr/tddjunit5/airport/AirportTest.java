package com.mbadr.tddjunit5.airport;

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
                        () -> assertEquals("ali", economyFlight.getPassengersSet().stream().findFirst().get().getName()),
                        () -> assertTrue(economyFlight.removePassenger(passenger)),
                        () -> assertEquals(0, economyFlight.getPassengersSet().size()),
                        () -> assertEquals("1", economyFlight.getId())
                );
            }

            @DisplayName("then you can't add him to the flight more than once")
            @RepeatedTest(5)
            public void testAddingVipPassengerToPremiumFlightMoreThanOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(passenger);
                }
                assertAll("verify a vip passenger added only once to premium flight",
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(passenger)),
                        () -> assertEquals("ali", economyFlight.getPassengersSet().stream().findFirst().get().getName())
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
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals("Mahmoud Badr", vipPassenger.getName())
                );
            }

            @DisplayName("then you can't add him to the flight more than once")
            @RepeatedTest(5)
            public void testAddingVipPassengerToPremiumFlightMoreThanOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(vipPassenger);
                }
                assertAll("verify a vip passenger added only once to premium flight",
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(vipPassenger)),
                        () -> assertEquals("Mahmoud Badr", economyFlight.getPassengersSet().stream().findFirst().get().getName())
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
                        () -> assertEquals(0, businessFlight.getPassengersSet().size()),
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
                        () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                        () -> assertEquals("1", businessFlight.getId()),
                        () -> assertEquals("Mahmoud Badr", businessFlight.getPassengersSet()
                                .stream()
                                .findFirst()
                                .get().getName())
                );
            }

            @DisplayName("then you can't add him to the flight more than once")
            @RepeatedTest(5)
            public void testAddingVipPassengerToBusinessFlightMoreThanOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    businessFlight.addPassenger(vipPassenger);
                }
                assertAll("verify a vip passenger added only once to premium flight",
                        () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                        () -> assertTrue(businessFlight.getPassengersSet().contains(vipPassenger)),
                        () -> assertEquals("Mahmoud Badr", businessFlight.getPassengersSet().stream()
                                .findFirst().get().getName())
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
            premiumFlight = new PremiumFlight("1");
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
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size()),
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
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size()),
                        () -> assertEquals("1", premiumFlight.getId())
                );
            }

            @DisplayName("then you can't add him to the flight more than once")
            @RepeatedTest(5)
            public void testAddingVipPassengerToPremiumFlightMoreThanOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    premiumFlight.addPassenger(vipPassenger);
                }
                assertAll("verify a vip passenger added only once to premium flight",
                        () -> assertEquals(1, premiumFlight.getPassengersSet().size()),
                        () -> assertTrue(premiumFlight.getPassengersSet().contains(vipPassenger)),
                        () -> assertEquals("Mahmoud Badr", premiumFlight.getPassengersSet().stream().findFirst()
                                .get().getName())
                );
            }

        }

    }
}