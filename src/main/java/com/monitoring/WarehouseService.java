// ==================== WarehouseService.java ====================
package com.monitoring;

import com.monitoring.model.SensorMeasurement;
import com.monitoring.model.SensorConfig;
import com.monitoring.utils.SensorParser;
import com.monitoring.CentralMonitoringService;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WarehouseService {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(SensorConfig.NUM_ACTIVE_SENESOR);

        executor.submit(() -> listenOnPort(SensorConfig.Temperature.port)); // Temperature
        executor.submit(() -> listenOnPort(SensorConfig.Humidity.port)); // Humidity
    }

    private static void listenOnPort(int port) {
        try (DatagramSocket socket = new DatagramSocket(port)) {
            var buffer = new byte[1024];
            System.out.println("[WarehouseService] Listening on port " + port);
            while (true) {
                var packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                SensorMeasurement measurement = SensorParser.parse(msg, port);
                System.out.println("[WarehouseService] Received: " + measurement);
                CentralMonitoringService.evaluate(measurement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}