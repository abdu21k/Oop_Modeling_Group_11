import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    private int id;
    private String brand, model;
    private boolean available;

    public Vehicle(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.available = true;
    }

    public void showInfo() {
        System.out.println("\033[34mID: " + id + "\033[0m, Brand: " + brand + ", Model: " + model + ", Available: " + available);
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailability(boolean available) {
        this.available = available;
    }

    public int getId() {
        return id;
    }
}

class Customer {
    private int id;
    private String name, license, phone;

    public Customer(int id, String name, String license, String phone) {
        this.id = id;
        this.name = name;
        this.license = license;
        this.phone = phone;
    }

    public void showInfo() {
        System.out.println("\033[32mID: " + id + "\033[0m, Name: " + name + ", License: " + license + ", Phone: " + phone);
    }

    public int getId() {
        return id;
    }
}

class Rental {
    private int id;
    private Vehicle vehicle;
    private Customer customer;
    private String startDate, endDate;

    public Rental(int id, Vehicle vehicle, Customer customer, String startDate, String endDate) {
        this.id = id;
        this.vehicle = vehicle;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void showInfo() {
        System.out.println("\033[36mRental ID: " + id + "\033[0m, Vehicle: " + vehicle.getId() + ", Customer: " + customer.getId() +
                ", Start Date: " + startDate + ", End Date: " + endDate);
    }
}

public class MainSystem {
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Rental> rentals = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n\033[35mVehicle Rental System\033[0m");
            System.out.println("1. View Vehicles\n2. Register Customer\n3. Rent a Vehicle\n4. Exit");
            System.out.print("Select: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewVehicles();
                case 2 -> registerCustomer(scanner);
                case 3 -> rentVehicle(scanner);
                case 4 -> running = false;
                default -> System.out.println("\033[31mInvalid choice, try again.\033[0m");
            }
        }
        scanner.close();
    }

    private static void viewVehicles() {
        if (vehicles.isEmpty()) System.out.println("\033[31mNo vehicles available.\033[0m");
        for (Vehicle v : vehicles) v.showInfo();
    }

    private static void registerCustomer(Scanner scanner) {
        System.out.print("ID: "); int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("License: "); String license = scanner.nextLine();
        System.out.print("Phone: "); String phone = scanner.nextLine();

        customers.add(new Customer(id, name, license, phone));
        System.out.println("\033[32mCustomer Registered.\033[0m");
    }

    private static void rentVehicle(Scanner scanner) {
        System.out.print("Rental ID: "); int rentalID = scanner.nextInt();
        System.out.print("Vehicle ID: "); int vehicleID = scanner.nextInt();
        System.out.print("Customer ID: "); int customerID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Start Date: "); String startDate = scanner.nextLine();
        System.out.print("End Date: "); String endDate = scanner.nextLine();

        Vehicle vehicle = vehicles.stream().filter(v -> v.getId() == vehicleID).findFirst().orElse(null);
        Customer customer = customers.stream().filter(c -> c.getId() == customerID).findFirst().orElse(null);

        if (vehicle != null && customer != null && vehicle.isAvailable()) {
            rentals.add(new Rental(rentalID, vehicle, customer, startDate, endDate));
            vehicle.setAvailability(false);
            System.out.println("\033[36mVehicle Rented!\033[0m");
        } else {
            System.out.println("\033[31mInvalid rental request.\033[0m");
        }
    }
}