import java.util.ArrayList;
import java.util.Scanner;

// Vehicle class
class Vehicle {
    private String vehicleID, brand, model, category;
    private boolean isAvailable;
    private String serviceExpiryDate;

    public Vehicle(String vehicleID, String brand, String model, String category, String serviceExpiryDate) {
        this.vehicleID = vehicleID;
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.isAvailable = true;
        this.serviceExpiryDate = serviceExpiryDate;
    }

    public void showInfo() {
        System.out.println("Vehicle ID: " + vehicleID + ", Brand: " + brand + ", Model: " + model + ", Category: " + category + ", Available: " + isAvailable);
    }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailability(boolean status) { isAvailable = status; }
    public String getCategory() { return category; }
    public String getServiceExpiryDate() { return serviceExpiryDate; }
}

// Customer class
class Customer {
    private String customerID, name, licenseNumber, phoneNumber;

    public Customer(String customerID, String name, String licenseNumber, String phoneNumber) {
        this.customerID = customerID;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.phoneNumber = phoneNumber;
    }

    public void viewCustomerInfo() {
        System.out.println("Customer ID: " + customerID + ", Name: " + name + ", License: " + licenseNumber + ", Phone: " + phoneNumber);
    }
}

// Rental class
class Rental {
    private String rentalID;
    private Vehicle vehicle;
    private Customer customer;
    private String startDate, endDate;
    private boolean isPaid;

    public Rental(String rentalID, Vehicle vehicle, Customer customer, String startDate, String endDate) {
        this.rentalID = rentalID;
        this.vehicle = vehicle;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isPaid = false;
    }

    public void showRentalInfo() {
        System.out.println("Rental ID: " + rentalID + ", Vehicle: " + vehicle.getCategory() + ", Customer: " + customer + ", Start: " + startDate + ", End: " + endDate + ", Paid: " + isPaid);
    }

    public void markAsPaid() { isPaid = true; }
}

// Payment class
class Payment {
    private String paymentID;
    private double amount;
    private boolean isSuccessful;

    public Payment(String paymentID, double amount) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.isSuccessful = false;
    }

    public void processPayment() {
        System.out.println("Processing payment of $" + amount);
        isSuccessful = true;
    }

    public void showPaymentStatus() {
        System.out.println("Payment ID: " + paymentID + ", Amount: $" + amount + ", Successful: " + isSuccessful);
    }
}

// ServiceChecker class
class ServiceChecker {
    public static boolean isServiceExpired(Vehicle vehicle) {
        return vehicle.getServiceExpiryDate().compareTo("2025-06-01") < 0;
    }
}

// GPS class
class GPS {
    private String vehicleID;
    private double latitude, longitude;

    public GPS(String vehicleID, double latitude, double longitude) {
        this.vehicleID = vehicleID;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void showLocation() {
        System.out.println("Vehicle ID: " + vehicleID + ", Location: (" + latitude + ", " + longitude + ")");
    }
}

// VehicleManager class
class VehicleManager {
    private ArrayList<Vehicle> vehicleList = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) { vehicleList.add(vehicle); }
    
    public Vehicle findByCategory(String category) {
        for (Vehicle v : vehicleList) {
            if (v.getCategory().equals(category) && v.isAvailable()) {
                return v;
            }
        }
        return null;
    }
}

// CustomerManager class
class CustomerManager {
    private ArrayList<Customer> customerList = new ArrayList<>();

    public void addCustomer(Customer customer) { customerList.add(customer); }
}

// RentalManager class
class RentalManager {
    private ArrayList<Rental> rentalList = new ArrayList<>();

    public void bookVehicle(String rentalID, Vehicle vehicle, Customer customer, String startDate, String endDate) {
        Rental rental = new Rental(rentalID, vehicle, customer, startDate, endDate);
        rentalList.add(rental);
        vehicle.setAvailability(false);
    }

    public void listRentals() {
        for (Rental rental : rentalList) {
            rental.showRentalInfo();
        }
    }
}

// MainSystem class
public class MainSystem {
    public static void main(String[] args) {
        VehicleManager vehicleManager = new VehicleManager();
        CustomerManager customerManager = new CustomerManager();
        RentalManager rentalManager = new RentalManager();

        vehicleManager.addVehicle(new Vehicle("V001", "Toyota", "Corolla", "Sedan", "2025-06-30"));
        Customer customer = new Customer("C001", "Abdulkerim", "DL12345", "0987654321");

        System.out.println("Welcome to Ride-Sharing Service!");
        rentalManager.bookVehicle("R001", vehicleManager.findByCategory("Sedan"), customer, "2025-06-02", "2025-06-05");
        rentalManager.listRentals();
    }
}
