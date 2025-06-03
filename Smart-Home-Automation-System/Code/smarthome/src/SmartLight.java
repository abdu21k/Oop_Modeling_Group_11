public class SmartLight extends SmartDevice {
    private int brightness;

    public SmartLight(String deviceName,int brightness) {
        super(deviceName); // call the constructor of SmartDevice
        this.brightness = 50; // default brightness
    }

    public void adjustBrightnessLevel(int level) {
        if (level >= 0 && level <= 100) {
            brightness = level;
            System.out.println(getDeviceName() + " brightness set to " + brightness + "%");
        } else {
            System.out.println("Invalid brightness level. Must be between 0 and 100.");
        }
    }


    public void controlDevice() {
        System.out.println(getDeviceName() + " is now " + (isOn ? "ON" : "OFF"));
    }
}
