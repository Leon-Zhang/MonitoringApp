# 📦 Warehouse Monitoring System

This is a reactive Java application that simulates and monitors environmental conditions (temperature and humidity) from sensors deployed in a warehouse. The system receives sensor data over UDP, processes the information, and triggers alarms if thresholds are exceeded.

## 🚀 Features

- ✅ Supports Temperature and Humidity sensors
- ✅ Receives sensor data over UDP
- ✅ Configurable thresholds for alarm triggering
- ✅ Logs alarm messages to the console
- ✅ Simple test coverage included

## 📄 Project Structure

- `WarehouseService`: Listens to UDP ports and processes incoming sensor messages
- `CentralMonitoringService`: Evaluates sensor readings and logs alarms if thresholds are breached
- `SensorParser`: Parses sensor message strings
- `SensorConfig`: Sensor configuration, flexible for change, add and remove sensros
- `SensorMeasurement`: Data model for sensor messages
- `TestSensorParser`: Unit tests for message parsing
- `TestWarehouseServiceUDP`: Integration tests that send dummy sensor data over UDP

## 🛠️ Build & Run Instructions

### 🔹 1. Compile the code

```bash
mvn compile
```

### 🔹 2. Run unit & integration tests

```bash
mvn test
```

### 🔹 3. Package the application as a `.jar`

```bash
mvn package
```

### 🔹 4. Run the application

```bash
java -jar ./target/warehouse-monitoring-1.0-SNAPSHOT.jar
```

> The application will begin listening on:
> - Port `3344` for temperature sensor data
> - Port `3355` for humidity sensor data

## 🧪 Simulating Sensors

Use any UDP client (e.g., `netcat`) to send test messages:

```bash
# Simulate temperature sensor
echo -n "sensor_id=t1; value=36" | nc -u 127.0.0.1 3344

# Simulate humidity sensor
echo -n "sensor_id=h1; value=60" | nc -u 127.0.0.1 3355
```
Or execute maven test cases:
```bash
mvn test
```

## ⚙️ Requirements

- Java 8 or later
- Maven 3.x

## 📦 Packaging Info

Generated JAR: `target/warehouse-monitoring-1.0-SNAPSHOT.jar`

## 📜 License

MIT License
