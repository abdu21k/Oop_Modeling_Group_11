import java.util.List;
import java.util.ArrayList;

public class User {
    private String name;
    private List<SmartDevice> devices;

    public User(String name) {
        this.name = name;
        this.devices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
        System.out.println(device.getDeviceName() + " added to " + name + "'s devices.");
    }

    public void controlDevice(SmartDevice device) {
        System.out.println(name + " is controlling " + device.getDeviceName());
        device.controlDevice();
    }

    public List<SmartDevice> getDevices() {
        return devices;
    }
}
