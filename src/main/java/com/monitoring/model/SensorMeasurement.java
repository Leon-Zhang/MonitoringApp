// ==================== SensorMeasurement.java ====================
package com.monitoring.model;

import java.util.Objects;

public class SensorMeasurement {
    private String sensorId;
    private SensorConfig sensorCfg;
    private double value;

    public SensorMeasurement(String sensorId, SensorConfig cfg, double value) {
        this.sensorId = Objects.requireNonNull(sensorId, "sensorId must not be null");
        this.sensorCfg = Objects.requireNonNull(cfg, "config must not be null");
        this.value = value;
    }

    public String getSensorId() { return sensorId; }
    public SensorConfig getConfig() { return sensorCfg; }
    public double getValue() { return value; }

    public boolean isNormal() {
        return sensorCfg.isNormal(this.value);
    }

    @Override
    public String toString() {
        return String.format("SensorMeasurement{sensorId='%s', type='%s', value=%.1f%s}",
                sensorId, sensorCfg.name, value, sensorCfg.unitSign);
    }
}
