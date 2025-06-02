## Ride-Sharing Service Methods

### Driver Class
| Method                         | Return Type  | Description |
|--------------------------------|-------------|-------------|
| getDriverId()                  | int         | Returns the unique ID of the driver |
| getName()                      | String      | Retrieves the driver’s name |
| getPhoneNumber()               | String      | Returns the driver’s contact number |
| getLicenseNumber()             | String      | Fetches the driver’s license number |
| getRating()                    | double      | Returns the driver’s average rating |
| isAvailable()                  | boolean     | Checks if the driver is available |
| updateLocation(String location) | void       | Updates the driver’s GPS location |

### Passenger Class
| Method                         | Return Type  | Description |
|--------------------------------|-------------|-------------|
| getPassengerId()               | int         | Returns the unique ID of the passenger |
| getName()                      | String      | Retrieves the passenger’s name |
| getPhoneNumber()               | String      | Returns the passenger’s contact number |
| getPaymentMethod()             | String      | Retrieves the preferred payment method |
| getRating()                    | double      | Returns the passenger’s rating given by drivers |

### Vehicle Class
| Method                         | Return Type  | Description |
|--------------------------------|-------------|-------------|
| getVehicleId()                 | int         | Returns the unique ID of the vehicle |
| getLicensePlate()              | String      | Fetches the vehicle’s license plate number |
| getBrand()                     | String      | Retrieves the vehicle manufacturer |
| getModel()                     | String      | Fetches the vehicle model |
| getColor()                     | String      | Retrieves the color of the vehicle |
| getSeatingCapacity()           | int         | Returns the available seating capacity |
| isAvailable()                  | boolean     | Checks if the vehicle is available |
| setAvailability(boolean status) | void       | Updates the vehicle’s availability status |

### Ride Class
| Method                         | Return Type  | Description |
|--------------------------------|-------------|-------------|
| getRideId()                    | int         | Returns the unique ID of the ride |
| getDriverId()                  | int         | Fetches the driver ID assigned to the ride |
| getPassengerId()               | int         | Returns the passenger ID requesting the ride |
| getPickupLocation()            | String      | Retrieves the pickup address |
| getDropoffLocation()           | String      | Fetches the destination address |
| getDistance()                  | double      | Returns the total distance traveled (in km) |
| getFare()                      | double      | Fetches the total ride cost |
| getStatus()                    | String      | Returns the current ride status |
| updateRideStatus(String status) | void       | Updates the ride's status |

### Payment Class
| Method                         | Return Type  | Description |
|--------------------------------|-------------|-------------|
| getPaymentId()                 | int         | Returns the unique ID for the payment transaction |
| getRideId()                    | int         | Retrieves the ID of the ride tied to the payment |
| getPassengerId()               | int         | Fetches the passenger’s ID making the payment |
| getAmount()                    | double      | Returns the payment amount |
| getPaymentMethod()             | String      | Retrieves the payment type used |
| getStatus()                    | String      | Fetches the payment status |
| processPayment()               | boolean     | Confirms if the payment was successful |

### Feedback Class
| Method                         | Return Type  | Description |
|--------------------------------|-------------|-------------|
| getFeedbackId()                | int         | Returns the unique ID for feedback |
| getUserId()                    | int         | Fetches the ID of the user giving feedback |
| getRideId()                    | int         | Retrieves the ID of the ride being reviewed |
| getRating()                    | double      | Returns the star rating provided (1-5) |
| getComments()                  | String      | Fetches additional feedback comments |
| submitFeedback()               | void        | Saves the feedback given by the user |
