// ==================== SensorMeasurement.java ====================
package com.monitoring.model;

public class SensorMeasurement {
    private String sensorId;
    private SensorConfig sensorCfg;
    private double value;

    public SensorMeasurement(String sensorId, SensorConfig cfg, double value) {
        this.sensorId = sensorId;
        this.sensorCfg = cfg;
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
        return "SensorMeasurement{" +
                "sensorId='" + sensorId + '\'' +
                ", type='" + sensorCfg.name + '\'' +
                ", value=" + value +
                '}';
    }
}
