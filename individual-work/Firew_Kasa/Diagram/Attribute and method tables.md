
 Hotel Reservation System - Initial Attribute and Method Tables

 Initial Attribute Table

| Class Name    | Attribute Name | Data Type         | Visibility | Rationale                                  |
|---------------|----------------|-------------------|------------|---------------------------------------------|
| Room          | roomID         | String            | private    | Unique identifier for each room             |
| Room          | type           | String            | private    | Type of room (e.g., Single, Double, Suite)  |
| Room          | price          | double            | private    | Cost per night                              |
| Room          | isAvailable    | boolean           | private    | Indicates if room is currently free         |
| Room          | capacity       | int               | private    | Maximum number of occupants allowed         |
| Customer      | customerID     | String            | private    | Unique ID for the customer                  |
| Customer      | name           | String            | private    | Full name of the customer                   |
| Customer      | phoneNumber    | String            | private    | Contact number                              |
| Customer      | email          | String            | private    | Email address of customer                   |
| Reservation   | reservationID  | String            | private    | Unique ID for the reservation               |
| Reservation   | checkInDate    | LocalDate         | private    | Date of check-in                            |
| Reservation   | checkOutDate   | LocalDate         | private    | Date of check-out                           |
| Reservation   | isConfirmed    | boolean           | private    | Indicates if reservation is confirmed       |
| Reservation   | customer       | Customer          | private    | Customer who made the reservation           |
| Reservation   | room           | Room              | private    | Room that has been reserved                 |
| Payment       | paymentID      | String            | private    | ID of the payment                           |
| Payment       | amount         | double            | private    | Amount paid                                 |
| Payment       | isPaid         | boolean           | private    | Shows if payment is successful              |
| Payment       | reservationID  | String            | private    | Links payment to reservation                |
| HotelManager  | hotelName      | String            | private    | Name of the hotel                           |
| HotelManager  | rooms          | ArrayList<Room>   | private    | Collection of hotel rooms                   |
| MainSystem    | (none)         | —                 | —          | Main logic controller (no attributes)       |

Initial Method Table

| Class Name    | Method Name           | Return Type | Visibility | Rationale                                             |
|---------------|------------------------|-------------|------------|--------------------------------------------------------|
| Room          | showRoomInfo()         | void        | public     | Displays room details                                 |
| Room          | isAvailable()          | boolean     | public     | Returns availability status                           |
| Room          | setAvailability()      | void        | public     | Sets availability to true/false                       |
| Customer      | registerCustomer()     | void        | public     | Registers a new customer                              |
| Customer      | viewProfile()          | void        | public     | Displays customer details                             |
| Customer      | updateContact()        | void        | public     | Modifies phone or email info                          |
| Reservation   | createReservation()    | void        | public     | Creates a new reservation                             |
| Reservation   | cancelReservation()    | void        | public     | Cancels an existing reservation                       |
| Reservation   | isConfirmed()          | boolean     | public     | Checks if reservation is confirmed                    |
| Reservation   | showReservationInfo()  | void        | public     | Displays reservation information                      |
| Payment       | processPayment()       | boolean     | public     | Simulates a payment transaction and returns result    |
| Payment       | markAsPaid()           | void        | public     | Marks the payment as successful                       |
| Payment       | showPaymentStatus()    | void        | public     | Displays payment confirmation or failure message      |
| HotelManager  | addRoom()              | void        | public     | Adds a room to the hotel inventory                    |
| HotelManager  | listAvailableRooms()   | void        | public     | Displays all free rooms                               |
| HotelManager  | findRoomByType()       | Room        | public     | Returns room object matching a given type             |
| MainSystem    | showMenu()             | void        | public     | Displays user options                                 |
| MainSystem    | handleUserInput()      | void        | public     | Captures and processes user input                     |
| MainSystem    | callOtherModules()     | void        | public     | Coordinates between system modules                    |
