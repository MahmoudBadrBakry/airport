package com.mbadr.tddjunit5.airconditioning;

import com.mbadr.tddjunit5.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AirConditioningSystemTest {

    @InjectMocks
    AirConditioningSystem airConditioningSystem;
    @Mock
    Thermometer thermometer;


    @Test
    void testAirConditioningOpen() {
        airConditioningSystem.setThresholdTemperature(24.0);
        when(thermometer.getTemperature()).thenReturn(25.0);

        airConditioningSystem.checkAirConditioningSystem();

        assertTrue(airConditioningSystem.isOpen());
        verify(thermometer, times(1)).getTemperature();
    }

    @Test
    void testAirConditioningClosed() {
        airConditioningSystem.setThresholdTemperature(26.0);
        when(thermometer.getTemperature()).thenReturn(25.0);

        airConditioningSystem.checkAirConditioningSystem();

        assertFalse(airConditioningSystem.isOpen());
        verify(thermometer, times(1)).getTemperature();
    }
}
