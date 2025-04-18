 Vehicle Rental System

Project Details:

The Vehicle Rental System is a structured application aimed at streamlining the operations of a rental business by digitizing the process of renting and returning vehicles. The system allows registration of vehicles and customers, tracks rentals, manages vehicle availability, and automates rental cost calculations. It is designed to reduce manual errors, speed up transactions, and improve overall customer service.

Instructions:

1. Understand the Entities: Begin by identifying the main objects — Vehicle, Customer, and Rental.
2. Plan the Flow: Visualize the flow — registration, rental  return and  record management.

3. Design Classes: Create classes for each entity with relevant attributes and methods.

4. Implement Controller: Develop a controller class to manage data input, validation, and interaction between objects.
5. Test Each Module: Ensure each function (e.g., adding vehicle, renting) works correctly before integrating.
6. Maintain Clean Code: Follow good coding practices — use constructors, encapsulation, and proper naming.
System Structure Explanation:
The system will have an object-oriented approach where each real-world component is modeled as a class:

1. Vehicle Class

Represents individual vehicles available for rent.
Attributes:
vehicleID, type, model, ratePerDay, status
Methods:
markAvailable(), markRented(), displayInfo()


2. Customer Class

Represents the individuals who rent the vehicles.
Attributes:
customerID, name, licenseNumber
Methods:
displayCustomerInfo()


3. Rental Class
Connects a customer to a rented vehicle.
Attributes:
rentalID, vehicle, customer, rentDate, returnDate, totalCost
Methods:
calculateRentalCost(), closeRental(), displayRentalDetails()


4. RentalSystem Class (Main Controller)

Manages the overall system.

Responsibilities:
Store and manage lists of vehicles, customers, and rentals
Handle user interactions
Validate input and prevent duplicate or invalid entries
Process rentals and returns
Provide report views


Problem Overview:

Managing a vehicle rental business manually introduces several challenges:
Vehicle availability isn’t tracked in real-time
Rentals and returns are recorded inconsistently
Customers' records are not maintained properly
Billing is calculated manually and prone to error
No clear history of transactions is available


These problems lead to time loss, inaccurate records, poor service, and financial inconsistencies.

Solution Overview:

The system addresses these issues using a clean object-oriented model:
Vehicles and customers are registered and managed efficiently
Availability is tracked automatically upon rental and return
Rental records are stored with accurate cost and date tracking
A centralized control unit (RentalSystem) manages all actions and data integrity
Reports are generated from stored data for easy reference
