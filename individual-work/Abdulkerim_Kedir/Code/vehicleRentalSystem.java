import java.util.ArrayList;
import java.util.Scanner;

// Abstract Class: Person
abstract class Person {
    private String name, phoneNumber;

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }

    public abstract void displayDetails();
}

// Interface for Rental Services
interface RentalService {
    void processRental();
}

// Interface for Billing System
interface BillingSystem {
    void generateInvoice();
}

// Customer Class (Inherits Person)
class Customer extends Person {
    private String customerId;

    public Customer(String customerId, String name, String phoneNumber) {
        super(name, phoneNumber);
        this.customerId = customerId;
    }

    public String getCustomerId() { return customerId; }

    @Override
    public void displayDetails() {
        System.out.println("Customer ID: " + customerId + " | Name: " + getName() + " | Phone: " + getPhoneNumber());
    }
}

// Vehicle Class
class Vehicle {
    private String vehicleId, model;
    private boolean isAvailable;

    public Vehicle(String vehicleId, String model) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.isAvailable = true;
    }

    public String getVehicleId() { return vehicleId; }
    public String getModel() { return model; }
    public boolean isAvailable() { return isAvailable; }
    public void toggleAvailability() { isAvailable = !isAvailable; }

    public void displayInfo() {
        System.out.println("Vehicle ID: " + vehicleId + " | Model: " + model + " | Available: " + isAvailable);
    }
}

// Rental Class (Implements RentalService & BillingSystem)
class Rental implements RentalService, BillingSystem {
    private String rentalId;
    private Vehicle vehicle;
    private Customer customer;
    private int days;
    private double ratePerDay = 50.0;

    public Rental(String rentalId, Vehicle vehicle, Customer customer, int days) {
        this.rentalId = rentalId;
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.vehicle.toggleAvailability();
    }

    @Override
    public void processRental() {
        System.out.println("\nProcessing rental for customer: " + customer.getName());
    }

    @Override
    public void generateInvoice() {
        System.out.println("\n----- Rental Invoice -----");
        System.out.println("Rental ID: " + rentalId);
        customer.displayDetails();
        vehicle.displayInfo();
        System.out.println("Days Rented: " + days);
        System.out.println("Total Cost: $" + calculateCost());
    }

    private double calculateCost() { return days * ratePerDay; }
}

// Main System
public class VehicleRentalSystem {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Rental> rentals = new ArrayList<>();

    public static void main(String[] args) {
        // Sample Data
        vehicles.add(new Vehicle("V001", "Toyota Corolla"));
        vehicles.add(new Vehicle("V002", "Honda Civic"));
        customers.add(new Customer("C001", "Ali", "0912345678"));

        int choice;
        do {
            System.out.println("\n=== Vehicle Rental System ===");
            System.out.println("1. View Vehicles");
            System.out.println("2. View Customers");
            System.out.println("3. Register Customer");
            System.out.println("4. Rent a Vehicle");
            System.out.println("5. View Rentals");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> viewVehicles();
                case 2 -> viewCustomers();
                case 3 -> registerCustomer();
                case 4 -> rentVehicle();
                case 5 -> viewRentals();
                case 0 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice, try again.");
            }
        } while (choice != 0);
    }

    static void viewVehicles() {
        System.out.println("\n--- Available Vehicles ---");
        for (Vehicle v : vehicles) v.displayInfo();
    }

    static void viewCustomers() {
        System.out.println("\n--- Registered Customers ---");
        for (Customer c : customers) c.displayDetails();
    }

    static void registerCustomer() {
        System.out.print("Enter Customer ID: ");
        String id = input.next();
        System.out.print("Enter Name: ");
        String name = input.next();
        System.out.print("Enter Phone: ");
        String phone = input.next();
        customers.add(new Customer(id, name, phone));
        System.out.println("Customer registered successfully!");
    }

    static void rentVehicle() {
        System.out.print("Enter Customer ID: ");
        String custId = input.next();
        Customer foundCustomer = null;
        for (Customer c : customers) if (c.getCustomerId().equalsIgnoreCase(custId)) foundCustomer = c;
        if (foundCustomer == null) { System.out.println("Customer not found."); return; }

        System.out.print("Enter Vehicle ID: ");
        String vehId = input.next();
        Vehicle foundVehicle = null;
        for (Vehicle v : vehicles) if (v.getVehicleId().equalsIgnoreCase(vehId) && v.isAvailable()) foundVehicle = v;
        if (foundVehicle == null) { System.out.println("Vehicle not found or unavailable."); return; }

        System.out.print("Enter number of rental days: ");
        int days = input.nextInt();
        String rentalId = "R" + (rentals.size() + 1);

        Rental rental = new Rental(rentalId, foundVehicle, foundCustomer, days);
        rentals.add(rental);
        rental.processRental();
        rental.generateInvoice();
    }

    static void viewRentals() {
        if (rentals.isEmpty()) { System.out.println("\nNo rentals yet."); return; }
        System.out.println("\n--- Rental History ---");
        for (Rental r : rentals) r.generateInvoice();
    }
}
