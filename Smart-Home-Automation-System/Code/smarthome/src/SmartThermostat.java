public class SmartThermostat extends SmartDevice {
    private double temperature;

    public SmartThermostat(String name, double temperature) {
        super(name);
        this.temperature = temperature;
    }

    public void lock() {
        System.out.println(deviceName + " is now locked.");
    }

    public void unlock() {
        System.out.println(deviceName + " is now unlocked.");
    }
}
