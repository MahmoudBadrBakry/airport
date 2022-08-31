package com.mbadr.tddjunit5.airconditioning;

public class AirConditioningSystem {
    private Thermometer thermometer;
    private double temperatureThreshold;
    private boolean open;

    public AirConditioningSystem() {
        open = false;
    }

    public void checkAirConditioningSystem() {
        this.open = thermometer.getTemperature() >= temperatureThreshold;
    }

    public void setThermometer(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    public void setThresholdTemperature(double temperatureThreshold) {
        this.temperatureThreshold = temperatureThreshold;
    }

    public boolean isOpen() {
        return open;
    }
}
