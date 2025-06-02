## Ride-Sharing Service Attributes

### Driver
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| driverId       | int       | Unique ID for each driver |
| name           | String    | Driver’s full name |
| phoneNumber    | String    | Contact number |
| licenseNumber  | String    | Driver’s license number |
| rating         | double    | Driver’s average rating |
| availability   | boolean   | Is the driver available? |
| currentLocation | String   | Driver’s GPS coordinates |

### Passenger
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| passengerId    | int       | Unique ID for the passenger |
| name           | String    | Passenger’s full name |
| phoneNumber    | String    | Contact number |
| paymentMethod  | String    | Preferred payment method (Card, Cash, Wallet) |
| rating         | double    | Passenger rating given by drivers |

### Vehicle
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| vehicleId      | int       | Unique ID for the vehicle |
| licensePlate   | String    | Vehicle’s license plate number |
| brand          | String    | Manufacturer (Toyota, Tesla, etc.) |
| model          | String    | Model (Camry, Model S, etc.) |
| color          | String    | Vehicle’s color |
| seatingCapacity | int      | Number of available seats |
| status         | String    | Vehicle status (Active, In Service) |

### Ride
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| rideId         | int       | Unique ID for the ride |
| driverId       | int       | Assigned driver’s ID |
| passengerId    | int       | Requesting passenger’s ID |
| pickupLocation | String    | Starting address |
| dropoffLocation | String   | Destination address |
| distance       | double    | Distance traveled (km) |
| fare          | double    | Total ride cost |
| status        | String    | Ride status (Requested, Ongoing, Completed) |

### Payment
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| paymentId      | int       | Unique ID for the payment transaction |
| rideId        | int       | ID of the ride tied to the payment |
| passengerId   | int       | Passenger ID making the payment |
| amount        | double    | Amount paid |
| paymentMethod | String    | Payment type used |
| status        | String    | Payment status (Pending, Paid, Failed) |

### Feedback
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| feedbackId     | int       | Unique ID for feedback |
| userId         | int       | ID of user giving feedback |
| rideId         | int       | ID of the ride being reviewed |
| rating         | double    | Rating given (1-5 stars) |
| comments       | String    | Passenger/driver feedback |
