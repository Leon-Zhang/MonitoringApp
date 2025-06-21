// ==================== CentralMonitoringService.java ====================
package com.monitoring;

import com.monitoring.model.SensorMeasurement;

public class CentralMonitoringService {

    public static void evaluate(SensorMeasurement measurement) {

        if (!measurement.isNormal()) {
            String reason = String.format(
                    "%s exceeds %.1f%s",
                    measurement.getConfig().name,
                    measurement.getConfig().threshold,
                    measurement.getConfig().unitSign);
            System.err.println("[ALARM] " + measurement + " -> " + reason);
        } else {
            System.out.println("[CentralMonitoring] OK: " + measurement);
        }
    }
}