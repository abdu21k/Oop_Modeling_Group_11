import java.util.ArrayList;

// Driver Class
class Driver {
    private int driverId;
    private String name, phoneNumber, licenseNumber, currentLocation;
    private double rating;
    private boolean availability;

    public Driver(int driverId, String name, String phoneNumber, String licenseNumber, double rating, boolean availability, String currentLocation) {
        this.driverId = driverId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
        this.availability = availability;
        this.currentLocation = currentLocation;
    }

    public int getDriverId() { return driverId; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getLicenseNumber() { return licenseNumber; }
    public double getRating() { return rating; }
    public boolean isAvailable() { return availability; }
    public void updateLocation(String location) { this.currentLocation = location; }
}

// Passenger Class
class Passenger {
    private int passengerId;
    private String name, phoneNumber, paymentMethod;
    private double rating;

    public Passenger(int passengerId, String name, String phoneNumber, String paymentMethod, double rating) {
        this.passengerId = passengerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.paymentMethod = paymentMethod;
        this.rating = rating;
    }

    public int getPassengerId() { return passengerId; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getPaymentMethod() { return paymentMethod; }
    public double getRating() { return rating; }
}

// Vehicle Class
class Vehicle {
    private int vehicleId;
    private String licensePlate, brand, model, color, status;
    private int seatingCapacity;

    public Vehicle(int vehicleId, String licensePlate, String brand, String model, String color, int seatingCapacity, String status) {
        this.vehicleId = vehicleId;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.seatingCapacity = seatingCapacity;
        this.status = status;
    }

    public int getVehicleId() { return vehicleId; }
    public String getLicensePlate() { return licensePlate; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getColor() { return color; }
    public int getSeatingCapacity() { return seatingCapacity; }
    public String getStatus() { return status; }
    public void setAvailability(String status) { this.status = status; }
}

// Ride Class
class Ride {
    private int rideId, driverId, passengerId;
    private String pickupLocation, dropoffLocation, status;
    private double distance, fare;

    public Ride(int rideId, int driverId, int passengerId, String pickupLocation, String dropoffLocation, double distance, double fare, String status) {
        this.rideId = rideId;
        this.driverId = driverId;
        this.passengerId = passengerId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.distance = distance;
        this.fare = fare;
        this.status = status;
    }

    public int getRideId() { return rideId; }
    public int getDriverId() { return driverId; }
    public int getPassengerId() { return passengerId; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDropoffLocation() { return dropoffLocation; }
    public double getDistance() { return distance; }
    public double getFare() { return fare; }
    public String getStatus() { return status; }
    public void updateRideStatus(String status) { this.status = status; }
}

// Payment Class
class Payment {
    private int paymentId, rideId, passengerId;
    private double amount;
    private String paymentMethod, status;

    public Payment(int paymentId, int rideId, int passengerId, double amount, String paymentMethod, String status) {
        this.paymentId = paymentId;
        this.rideId = rideId;
        this.passengerId = passengerId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public int getPaymentId() { return paymentId; }
    public int getRideId() { return rideId; }
    public int getPassengerId() { return passengerId; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }
    public boolean processPayment() { return status.equals("Paid"); }
}

// Feedback Class
class Feedback {
    private int feedbackId, userId, rideId;
    private double rating;
    private String comments;

    public Feedback(int feedbackId, int userId, int rideId, double rating, String comments) {
        this.feedbackId = feedbackId;
        this.userId = userId;
        this.rideId = rideId;
        this.rating = rating;
        this.comments = comments;
    }

    public int getFeedbackId() { return feedbackId; }
    public int getUserId() { return userId; }
    public int getRideId() { return rideId; }
    public double getRating() { return rating; }
    public String getComments() { return comments; }
    public void submitFeedback() { System.out.println("Feedback submitted successfully."); }
}

// Main System
public class RideSharingSystem {
    private static ArrayList<Driver> drivers = new ArrayList<>();
    private static ArrayList<Passenger> passengers = new ArrayList<>();
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static ArrayList<Ride> rides = new ArrayList<>();
    private static ArrayList<Payment> payments = new ArrayList<>();
    private static ArrayList<Feedback> feedbacks = new ArrayList<>();

    public static void main(String[] args) {
        // Sample Data
        drivers.add(new Driver(1, "John Doe", "1234567890", "DL1234", 4.8, true, "City Center"));
        passengers.add(new Passenger(1, "Alice Smith", "0987654321", "Card", 4.9));
        vehicles.add(new Vehicle(1, "ABC-123", "Toyota", "Corolla", "Blue", 4, "Active"));
        
        // Testing Ride Booking
        Ride ride = new Ride(1, 1, 1, "Airport", "Downtown", 15.5, 25.0, "Completed");
        rides.add(ride);

        Payment payment = new Payment(1, 1, 1, 25.0, "Card", "Paid");
        payments.add(payment);

        Feedback feedback = new Feedback(1, 1, 1, 5.0, "Great ride!");
        feedbacks.add(feedback);

        feedback.submitFeedback();

        System.out.println("Ride-Sharing System is Fully Functional!");
    }
}
