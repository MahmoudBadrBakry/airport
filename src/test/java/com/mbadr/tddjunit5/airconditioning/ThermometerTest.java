package com.mbadr.tddjunit5.airconditioning;

import com.mbadr.tddjunit5.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ThermometerTest {

    @InjectMocks
    private Thermometer thermometer;

    @Mock
    private Sensor sensor;

    @Test
    public void testWorkingSensor() {
        thermometer.setTemperature(25);
        when(sensor.isBlocked()).thenReturn(false);

        assertEquals(sensor, thermometer.getSensor());
        assertEquals(25.0, thermometer.getTemperature(), .01);
        verify(sensor, times(1)).isBlocked();
    }

    @Test
    public void testBlockedSensor() {
        thermometer.setTemperature(25);
        when(sensor.isBlocked()).thenReturn(true);

        assertEquals(sensor, thermometer.getSensor());
        assertThrows(RuntimeException.class, () -> thermometer.getTemperature());
        verify(sensor, times(1)).isBlocked();
    }
}
