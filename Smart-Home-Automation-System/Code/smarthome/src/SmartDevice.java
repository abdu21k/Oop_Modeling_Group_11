public class SmartDevice {
    protected String deviceName;
    protected boolean isOn;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
        this.isOn = false;
    }

    public String getDeviceName() {
        return deviceName;
    }

    // other shared methods...
}
