
Initial Object Identification Table


+-------------------+--------------------------------------------------+------------------------------------------------------------+-------------------------------------------------------------+
| Object Name       | What it is                                       | Important Data (Attributes)                                | What it Does (Methods)                                      |
+-------------------+--------------------------------------------------+------------------------------------------------------------+-------------------------------------------------------------+
| Vehicle           | A car or other vehicle that can be rented        | vehicleID, brand, model, category, isAvailable,            | showInfo(), isAvailable(), checkServiceExpiry(),           |
|                   |                                                  | serviceExpiryDate                                          | setAvailability()                                           |
+-------------------+--------------------------------------------------+------------------------------------------------------------+-------------------------------------------------------------+
| Customer          | A person who rents vehicles                      | customerID, name, licenseNumber, phoneNumber               | registerCustomer(), viewCustomerInfo()                     |
+-------------------+--------------------------------------------------+------------------------------------------------------------+-------------------------------------------------------------+
| Rental            | A booking made by a customer                     | rentalID, vehicle, customer, startDate, endDate, isPaid    | createRental(), returnVehicle(), isPaid(), showRentalInfo()|
+-------------------+--------------------------------------------------+------------------------------------------------------------+-------------------------------------------------------------+
| Payment           | Simulates the payment system                     | paymentID, amount, isSuccessful, rentalID                  | processPayment(), markAsPaid(), showPaymentStatus()        |
+-------------------+--------------------------------------------------+------------------------------------------------------------+-------------------------------------------------------------+
| ServiceChecker    | Checks if a vehicle's service is expired         | (uses serviceExpiryDate from Vehicle)                      | isServiceExpired(vehicle), checkTodayDate()                |
+-------------------+--------------------------------------------------+------------------------------------------------------------+-------------------------------------------------------------+
| GPS               | Simulates GPS tracking of vehicles               | vehicleID, latitude, longitude                             | generateLocation(), showLocation()                         |
+-------------------+--------------------------------------------------+------------------------------------------------------------+-------------------------------------------------------------+
| VehicleManager    | Manages the list of all vehicles                 | vehicleList (ArrayList<Vehicle>)                           | addVehicle(), findByCategory(), updateAvailability()       |
+-------------------+--------------------------------------------------+------------------------------------------------------------+-------------------------------------------------------------+
| CustomerManager   | Manages the list of all customers                | customerList (ArrayList<Customer>)                         | addCustomer(), searchCustomerByID()                        |
+-------------------+--------------------------------------------------+------------------------------------------------------------+-------------------------------------------------------------+
| RentalManager     | Manages rental operations                        | rentalList (ArrayList<Rental>)                             | bookVehicle(), endRental(), listRentals()                  |
+-------------------+--------------------------------------------------+------------------------------------------------------------+-------------------------------------------------------------+
| MainSystem        | The main controller of the program               | (no attributes)                                            | showMenu(), handleUserInput(), callOtherModules()          |
+-------------------+--------------------------------------------------+------------------------------------------------------------+-------------------------------------------------------------+
