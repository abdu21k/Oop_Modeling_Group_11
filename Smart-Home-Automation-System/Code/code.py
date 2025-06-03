import java.util.ArrayList;
import java.util.List;

// Base Class: SmartDevice
abstract class SmartDevice {
    protected int deviceId;
    protected String deviceName;
    protected boolean status;
    protected String location;
    protected boolean connectionState;

    public SmartDevice(int deviceId, String name, String location) {
        this.deviceId = deviceId;
        this.deviceName = name;
        this.location = location;
        this.status = false;
        this.connectionState = true;
    }

    public void turnOn() {
        status = true;
        System.out.println(deviceName + " is now ON.");
    }

    public void turnOff() {
        status = false;
        System.out.println(deviceName + " is now OFF.");
    }

    public String getStatus() {
        return deviceName + " Status: " + (status ? "ON" : "OFF");
    }

    @Override
    public String toString() {
        return deviceName + " in " + location + " | Status: " + (status ? "ON" : "OFF");
    }
}

// SmartThermostat Class
class SmartThermostat extends SmartDevice {
    private double currentTemperature;
    private double targetTemperature;
    private String mode;

    public SmartThermostat(int deviceId, String name, String location) {
        super(deviceId, name, location);
        this.currentTemperature = 22.0;
        this.targetTemperature = 22.0;
        this.mode = "Auto";
    }

    public void setTargetTemperature(double temp) {
        if (temp < 10 || temp > 35) {
            System.out.println("Invalid temperature! Must be between 10°C and 35°C.");
            return;
        }
        this.targetTemperature = temp;
        if (!status) turnOn();
        System.out.println(deviceName + " target temperature set to " + temp + "°C.");
    }

    public void setMode(String mode) {
        this.mode = mode;
        if (!status) turnOn();
        System.out.println(deviceName + " mode set to " + mode + ".");
    }

    public String getTemperatureStatus() {
        return deviceName + " Current: " + currentTemperature + "°C | Target: " + targetTemperature + "°C | Mode: " + mode;
    }

    @Override
    public String toString() {
        return super.toString() + " | Mode: " + mode + " | Temp: " + targetTemperature + "°C";
    }
}

// SmartSensor Class
class SmartSensor extends SmartDevice {
    private String sensorType;
    private double detectedValue;
    private boolean alertStatus;

    public SmartSensor(int deviceId, String name, String location, String sensorType) {
        super(deviceId, name, location);
        this.sensorType = sensorType;
        this.alertStatus = false;
    }

    public void detectValue(double value) {
        if (value < 0 || value > 1000) {
            System.out.println("Invalid sensor value! Must be between 0 and 1000.");
            return;
        }
        this.detectedValue = value;
        this.alertStatus = value > 50;
        if (!status) turnOn();
        System.out.println(deviceName + " detected value: " + value + " (" + sensorType + ")");
    }

    public String getAlertStatus() {
        return deviceName + " Alert: " + (alertStatus ? "⚠️ Triggered!" : "Normal");
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: " + sensorType + " | Value: " + detectedValue;
    }
}

// HomeOwner Class - Manages Devices
class HomeOwner {
    private int userId;
    private String name;
    private String email;
    private String homeLocation;
    private List<SmartDevice> registeredDevices;

    public HomeOwner(int userId, String name, String email, String homeLocation) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.homeLocation = homeLocation;
        this.registeredDevices = new ArrayList<>();
    }

    public void addDevice(SmartDevice device) {
        registeredDevices.add(device);
        System.out.println("Added device: " + device.deviceName);
    }

    public void listDevices() {
        System.out.println("\n📋 Devices Controlled by " + name + ":");
        for (SmartDevice device : registeredDevices) {
            System.out.println("- " + device);
        }
        System.out.println();
    }
}

// Main Class to Simulate the System
public class SmartHomeSystem {
    public static void main(String[] args) {
        HomeOwner user = new HomeOwner(1, "Alex", "alex@email.com", "123 Smart St");

        SmartThermostat thermostat = new SmartThermostat(102, "Bedroom Thermostat", "Bedroom");
        SmartSensor sensor = new SmartSensor(104, "Motion Sensor", "Hallway", "Motion");

        user.addDevice(thermostat);
        user.addDevice(sensor);

        user.listDevices();

        thermostat.setTargetTemperature(24.5);
        thermostat.setMode("Cooling");

        sensor.detectValue(60.0);

        System.out.println(sensor.getAlertStatus());
        System.out.println(thermostat.getTemperatureStatus());

        user.listDevices();
    }
}
