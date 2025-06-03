import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create devices
        SmartLight light = new SmartLight("Living Room Light",  50);
        SmartThermostat thermostat = new SmartThermostat("Main Thermostat",  22.5);
        SmartSensor sensor = new SmartSensor("Front Door Sensor", "Motion");

        // Create a user
        User user = new User("Alice");

        while (true) {
            System.out.println("\n--- Smart Home System ---");
            System.out.println("1. Toggle Light");
            System.out.println("2. Adjust Light Brightness");
            System.out.println("3. Toggle Thermostat");
            System.out.println("4. Lock/Unlock Thermostat");
            System.out.println("5. Toggle Sensor");
            System.out.println("6. Detect Motion");
            System.out.println("7. Exit");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    user.controlDevice(light);
                    break;
                case 2:
                    System.out.print("Enter brightness level (0-100): ");
                    int level = scanner.nextInt();
                    light.adjustBrightnessLevel(level);
                    break;
                case 3:
                    user.controlDevice(thermostat);
                    break;
                case 4:
                    System.out.print("1. Lock  2. Unlock: ");
                    int lockChoice = scanner.nextInt();
                    if (lockChoice == 1) thermostat.lock();
                    else if (lockChoice == 2) thermostat.unlock();
                    else System.out.println("Invalid input.");
                    break;
                case 5:
                    user.controlDevice(sensor);
                    break;
                case 6:
                    sensor.detectMotion();
                    break;
                case 7:
                    System.out.println("Exiting Smart Home System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
