public class SmartSensor extends SmartDevice {
    private String sensorType;

    public SmartSensor(String name, String type) {
        super(name);
        this.sensorType = type;
    }

    public void detectMotion() {
        System.out.println(sensorType + " motion detected by " + deviceName);
    }
}
