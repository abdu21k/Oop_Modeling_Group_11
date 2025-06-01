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
        System.out.println("\033[34m[Vehicle] ID: " + id + " | Brand: " + brand + " | Model: " + model + " | Available: " + available + "\033[0m");
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
        System.out.println("\033[32m[Customer] ID: " + id + " | Name: " + name + " | License: " + license + " | Phone: " + phone + "\033[0m");
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
        System.out.println("\033[36m[Rental] ID: " + id + " | Vehicle: " + vehicle.getId() + " | Customer: " + customer.getId() +
                " | Start Date: " + startDate + " | End Date: " + endDate + "\033[0m");
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
            System.out.println("\n\033[35mVEHICLE RENTAL SYSTEM\033[0m");
            System.out.println("\033[33m1. View Vehicles | 2. Register Customer | 3. Rent a Vehicle | 4. Exit\033[0m");
            System.out.print("Select Option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewVehicles();
                case 2 -> registerCustomer(scanner);
                case 3 -> rentVehicle(scanner);
                case 4 -> {
                    System.out.println("\033[31mExiting the system... Goodbye!\033[0m");
                    running = false;
                }
                default -> System.out.println("\033[31mInvalid choice, please try again!\033[0m");
            }
        }
        scanner.close();
    }

    private static void viewVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("\033[31mNo vehicles available in the system.\033[0m");
        } else {
            System.out.println("\033[34mAvailable Vehicles:\033[0m");
            for (Vehicle v : vehicles) v.showInfo();
        }
    }

    private static void registerCustomer(Scanner scanner) {
        System.out.print("\033[32mEnter ID: \033[0m"); int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\033[32mName: \033[0m"); String name = scanner.nextLine();
        System.out.print("\033[32mLicense: \033[0m"); String license = scanner.nextLine();
        System.out.print("\033[32mPhone: \033[0m"); String phone = scanner.nextLine();

        customers.add(new Customer(id, name, license, phone));
        System.out.println("\033[32mCustomer successfully registered!\033[0m");
    }

    private static void rentVehicle(Scanner scanner) {
        System.out.print("\033[36mEnter Rental ID: \033[0m"); int rentalID = scanner.nextInt();
        System.out.print("\033[36mEnter Vehicle ID: \033[0m"); int vehicleID = scanner.nextInt();
        System.out.print("\033[36mEnter Customer ID: \033[0m"); int customerID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\033[36mStart Date: \033[0m"); String startDate = scanner.nextLine();
        System.out.print("\033[36mEnd Date: \033[0m"); String endDate = scanner.nextLine();

        Vehicle vehicle = vehicles.stream().filter(v -> v.getId() == vehicleID).findFirst().orElse(null);
        Customer customer = customers.stream().filter(c -> c.getId() == customerID).findFirst().orElse(null);

        if (vehicle != null && customer != null && vehicle.isAvailable()) {
            rentals.add(new Rental(rentalID, vehicle, customer, startDate, endDate));
            vehicle.setAvailability(false);
            System.out.println("\033[36mVehicle successfully rented!\033[0m");
        } else {
            System.out.println("\033[31mRental request failed! Check details and try again.\033[0m");
        }
    }
}
