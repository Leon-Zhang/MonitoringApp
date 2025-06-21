package com.monitoring.test;

import org.junit.jupiter.api.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static com.monitoring.model.SensorConfig.*;

public class TestWarehouseServiceUDP {

    private void sendUdpPacket(String message, int port) throws Exception {
        sendUdpPacket(message, port, "127.0.0.1");
    }

    private void sendUdpPacket(String message, int port, String host) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(
                buffer,
                buffer.length,
                InetAddress.getByName(host),
                port);

        socket.send(packet);
        socket.close();
    }

    @Test
    public void testSendTemperatureSensorData() throws Exception {
        String testMessage = "sensor_id=t1; value=35";
        sendUdpPacket(testMessage, TEMPERATURE_PORT); // Temperature port
        Thread.sleep(200); // Give time for the server to process (if running)
    }

    @Test
    public void testSendAbnormalTemperatureSensorData() throws Exception {
        String testMessage = "sensor_id=t1; value=37";
        sendUdpPacket(testMessage, TEMPERATURE_PORT); // Temperature port
        Thread.sleep(200); // Give time for the server to process (if running)
    }

    @Test
    public void testSendAbnormalHumiditySensorData() throws Exception {
        String testMessage = "sensor_id=h1; value=60";
        sendUdpPacket(testMessage, HUMIDITY_PORT); // Humidity port
        Thread.sleep(200); // Give time for the server to process (if running)
    }
}
