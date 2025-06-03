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

    public void turnOn() { status = true; System.out.println(deviceName + " is ON."); }
    public void turnOff() { status = false; System.out.println(deviceName + " is OFF."); }
    public String getStatus() { return deviceName + " Status: " + (status ? "ON" : "OFF"); }
}

// SmartLight Class
class SmartLight extends SmartDevice {
    private int brightness;
    private String colorMode;

    public SmartLight(int deviceId, String name, String location) {
        super(deviceId, name, location);
        this.brightness = 50;
        this.colorMode = "Warm";
    }

    public void setBrightness(int level) { this.brightness = level; }
    public void setColorMode(String mode) { this.colorMode = mode; }
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

    public void setTargetTemperature(double temp) { this.targetTemperature = temp; }
    public void setMode(String mode) { this.mode = mode; }
}

// SmartDoor Class
class SmartDoor extends SmartDevice {
    private boolean isLocked;
    private List<String> accessLogs;

    public SmartDoor(int deviceId, String name, String location) {
        super(deviceId, name, location);
        this.isLocked = true;
        this.accessLogs = new ArrayList<>();
    }

    public void lockDoor() { isLocked = true; }
    public void unlockDoor() { isLocked = false; accessLogs.add("Unlocked at " + System.currentTimeMillis()); }
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

    public void detectValue(double value) { this.detectedValue = value; this.alertStatus = value > 50; }
}

// AutomationRule Class
class AutomationRule {
    private int ruleId;
    private String triggerEvent;
    private String action;
    private String scheduleTime;

    public AutomationRule(int ruleId, String triggerEvent, String action, String scheduleTime) {
        this.ruleId = ruleId;
        this.triggerEvent = triggerEvent;
        this.action = action;
        this.scheduleTime = scheduleTime;
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

    public void addDevice(SmartDevice device) { registeredDevices.add(device); }
    public void listDevices() {
        System.out.println("Devices Controlled by " + name + ":");
        for (SmartDevice device : registeredDevices) {
            System.out.println("- " + device.getStatus());
        }
    }
}

// System Settings Class
class SmartHomeSettings {
    private String wifiSSID;
    private String securityMode;
    private boolean energySaver;

    public SmartHomeSettings(String wifiSSID, String securityMode, boolean energySaver) {
        this.wifiSSID = wifiSSID;
        this.securityMode = securityMode;
        this.energySaver = energySaver;
    }
}

// Main Class to Simulate the System
public class SmartHomeSystem {
    public static void main(String[] args) {
        HomeOwner user = new HomeOwner(1, "Alex", "alex@email.com", "123 Smart St");

        SmartLight light = new SmartLight(101, "Living Room Light", "Living Room");
        SmartThermostat thermostat = new SmartThermostat(102, "Bedroom Thermostat", "Bedroom");
        SmartDoor door = new SmartDoor(103, "Front Door", "Entrance");
        SmartSensor sensor = new SmartSensor(104, "Motion Sensor", "Hallway", "Motion");

        user.addDevice(light);
        user.addDevice(thermostat);
        user.addDevice(door);
        user.addDevice(sensor);

        user.listDevices();
        light.turnOn();
        thermostat.setTargetTemperature(24.5);
        door.unlockDoor();
        sensor.detectValue(60.0);

        user.listDevices();
    }
}
