
Solution of  Problems While Coding a Vehicle Rental System

1. Managing Different Types of Data with Classes
Problem: The system needs to handle multiple real-world objects like Vehicles, Customers, Rentals, and Payments.
Solution:
We use object-oriented programming (OOP) to define each real-world item as a separate class. For example:

* A `Vehicle` class will have attributes like `vehicleID`, `category`, `availability`, and methods like `markAsRented()`.
* A `Customer` class will store customer details like `name` and `licenseNumber`.
* A `Rental` class will link vehicles and customers for a specific rental duration.
* A `Payment` class handles the payment status and calculation.

---

2. Handling Relationships Between Classes
Problem: Customers rent vehicles, rentals are linked to payments, and vehicles are tracked with GPS. These relationships must be handled carefully in the code.
Solution:
We create relationships using object references between classes:

java
class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private Payment payment;
}

We can also use `ArrayList` to represent one-to-many relationships like a customer who rents multiple vehicles.

3. Booking and Availability Check
Problem:When a customer tries to rent a vehicle, we need to check if it’s available.
Solution:
We use a boolean or status field in the `Vehicle` class like `isAvailable`.

java
if (vehicle.isAvailable()) {
    // allow booking
}

After the booking, we update the status to avoid duplicate bookings.

4. Payment Calculation and Tracking
Problem:*Calculating total rental cost and managing payment status.
Solution:
 We define a `Payment` class with fields like `amount`, `paymentMethod`, and `status`.
* Inside the `Rental` class, we create a method like `calculateTotalCost()` that multiplies rental days by daily rate.
* We mark the payment as "paid" or "unpaid" depending on the status.

5. Tracking Vehicles in Real-Time (GPS)
Problem: The system must show vehicle location using GPS.
Solution:

* We simulate GPS data using a `GPS` class with attributes like `latitude` and `longitude`.
* Each `Vehicle` has a reference to its GPS object.
* When needed, we use something like `vehicle.getGPS().generateLocation()`.

6. Date and Time Handling
Problem: Managing rental dates, return dates, and service expiry.
Solution:
We use Java’s `LocalDate` class to handle dates.

ava
LocalDate today = LocalDate.now();
if (vehicle.getServiceExpiryDate().isBefore(today)) {
    // show warning for maintenance
}

7. Managing Unique IDs
Problem: Each customer, vehicle, and rental should have a unique ID.
Solution:
We use static counters or UUIDs. Example:
java
private static int vehicleCounter = 0;
this.vehicleID = "VEH" + (++vehicleCounter);

8. Search and Filtering
Problem: Allowing users to search for vehicles by type, model, etc.
Solution:
We loop through a list of vehicles and check conditions:
java
for (Vehicle v : vehicles) {
    if (v.isAvailable() && v.getCategory().equals("SUV")) {
        // show this vehicle
    }
}

9. Canceling Bookings and Updating Status
Problem:If a customer cancels or returns the car early, we need to update the status.
Solution:
We use a method like `cancelRental()` to change the rental status and make the vehicle available again.

10. Error Handling and Input Validation
Problem: The system may crash if the user enters wrong data.
Solution:
We use try-catch blocks and check for null or invalid values:

java
if (name.isEmpty()) {
    throw new IllegalArgumentException("Customer name cannot be empty.");
}

