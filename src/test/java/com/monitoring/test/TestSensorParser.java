// ==================== TestSensorParser.java ====================
package com.monitoring.test;

import com.monitoring.model.SensorMeasurement;
import com.monitoring.utils.SensorParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSensorParser {
    @Test
    public void testTemperatureParsing() {
        String input = "sensor_id=t1; value=36";
        SensorMeasurement m = SensorParser.parse(input, 3344);
        assertEquals("t1", m.getSensorId());
        assertTrue(m.getConfig().name.equalsIgnoreCase("temperature"));
        assertEquals(36.0, m.getValue());
    }

    @Test
    public void testHumidityParsing() {
        String input = "sensor_id=h1; value=60";
        SensorMeasurement m = SensorParser.parse(input, 3355);
        assertEquals("h1", m.getSensorId());
        //assertEquals("humidity", m.getConfig().name);
        assertTrue(m.getConfig().name.equalsIgnoreCase("humidity"));
        assertEquals(60.0, m.getValue());
    }
}