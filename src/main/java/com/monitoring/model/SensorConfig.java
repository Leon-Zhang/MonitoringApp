package com.monitoring.model;

public class SensorConfig {
    public int port;
    public String name;
    public double threshold;
    public String unitSign;

    public SensorConfig(int _port, String _name, double _threshold, String _unit) {
        this.name = _name;
        this.port = _port;
        this.threshold = _threshold;
        this.unitSign = _unit;
    }

    public boolean isNormal(double value) {
        return (value <= this.threshold);
    }

    public static final int NUM_ACTIVE_SENESOR = 2;
    public static final int Humidity_Port = 3355;
    public static final int Temperature_Port = 3344;
    public static final SensorConfig Humidity = new SensorConfig( Humidity_Port, "Humidity",50.0,"%");
    public static final SensorConfig Temperature = new SensorConfig( Temperature_Port, "Temperature" , 35.0, "°C");

    public static SensorConfig getConfigFromPort(int port) {
        switch(port){
            case Humidity_Port:
            return Humidity;
            case Temperature_Port:
            return Temperature;
            default:
            return null;
        }
    }
}
