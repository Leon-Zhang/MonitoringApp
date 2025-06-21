// ==================== CentralMonitoringService.java ====================
package com.monitoring;

import com.monitoring.model.SensorMeasurement;

public class CentralMonitoringService {

    public static void evaluate(SensorMeasurement measurement) {

        if (!measurement.isNormal()) {
            String reason = measurement.getConfig().name+" exceeds " + measurement.getConfig().threshold + "°C";
            System.err.println("[ALARM] " + measurement + " -> " + reason);
        } else {
            System.out.println("[CentralMonitoring] OK: " + measurement);
        }
    }
}