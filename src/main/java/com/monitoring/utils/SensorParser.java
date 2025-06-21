
// ==================== SensorParser.java ====================
package com.monitoring.utils;

import com.monitoring.model.SensorMeasurement;
import com.monitoring.model.SensorConfig;

public class SensorParser {
    public static SensorMeasurement parse(String input, int port) throws IllegalArgumentException {
        String[] parts = input.split(";\\s*");
        String sensorId = parts[0].split("=")[1];
        double value = Double.parseDouble(parts[1].split("=")[1]);
        SensorConfig sCfg=SensorConfig.getConfigFromPort(port);
        //String type = (port == 3344) ? "temperature" : "humidity";
        return new SensorMeasurement(sensorId, sCfg, value);
    }
}