import java.util.*;
import java.math.BigDecimal;
// import java.sql.Time; // Unused import
import java.text.SimpleDateFormat;

public class HotelReservationSystem {

    // Enums
    enum ReservationStatus { PENDING, CONFIRMED, CANCELLED, COMPLETED }
    enum RoomAvailabilityStatus { AVAILABLE, OCCUPIED, MAINTENANCE, RESERVED }

    // Classes
    static class Payment {
        private String paymentID;
        private String reservationID; // Link to reservation
        private BigDecimal amount;
        private Date paymentDate;
        private String method;

        public Payment(String reservationID, BigDecimal amount, String method) {
            this.paymentID = UUID.randomUUID().toString();
            this.reservationID = reservationID;
            this.amount = amount;
            this.paymentDate = new Date();
            this.method = method;
        }
        public String getPaymentID() { return paymentID; }
        public String getReservationID() { return reservationID; }
        public BigDecimal getAmount() { return amount; }
        public Date getPaymentDate() { return paymentDate; }
        public String getMethod() { return method; }
        public void setAmount(BigDecimal amount) { this.amount = amount; }
        public void setMethod(String method) { this.method = method; }
        
        @Override
        public String toString() {
            return "Payment{ID=" + paymentID + ", amount=" + amount + 
                   ", date=" + new SimpleDateFormat("yyyy-MM-dd").format(paymentDate) + ", method=" + method + "}";
        }
    }

    static class RoomType {
        private String typeID;
        private String name;
        private String description;
        private BigDecimal pricePerNight;
        private int capacity;

        public RoomType(String name, String description, BigDecimal pricePerNight, int capacity) {
            this.typeID = UUID.randomUUID().toString();
            this.name = name;
            this.description = description;
            this.pricePerNight = pricePerNight;
            this.capacity = capacity;
        }
        public String getTypeID() { return typeID; }
        public String getName() { return name; }
        public String getDescription() { return description; }
        public BigDecimal getPricePerNight() { return pricePerNight; }
        public int getCapacity() { return capacity; }
        public void setName(String name) { this.name = name; }
        public void setDescription(String description) { this.description = description; }
        public void setPricePerNight(BigDecimal pricePerNight) { this.pricePerNight = pricePerNight; }
        public void setCapacity(int capacity) { this.capacity = capacity; }

        @Override
        public String toString() {
            return name + " (Capacity: " + capacity + ", Price: $" + pricePerNight + "/night)";
        }
    }

    static class Room {
        private String roomID;
        private String hotelID;
        private String roomNumber;
        private RoomType roomType;
        private RoomAvailabilityStatus status;
        private List<String> features;

        public Room(String hotelID, String roomNumber, RoomType roomType) {
            this.roomID = UUID.randomUUID().toString();
            this.hotelID = hotelID;
            this.roomNumber = roomNumber;
            this.roomType = roomType;
            this.status = RoomAvailabilityStatus.AVAILABLE;
            this.features = new ArrayList<>();
        }
        public String getRoomID() { return roomID; }
        public String getHotelID() { return hotelID; }
        public String getRoomNumber() { return roomNumber; }
        public RoomType getRoomType() { return roomType; }
        public RoomAvailabilityStatus getStatus() { return status; }
        public List<String> getFeatures() { return new ArrayList<>(features); }
        public void setHotelID(String hotelID) { this.hotelID = hotelID; }
        public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
        public void setRoomType(RoomType roomType) { this.roomType = roomType; }
        public void setStatus(RoomAvailabilityStatus status) { this.status = status; }
        public void addFeature(String feature) {
            if (feature != null && !feature.trim().isEmpty() && !features.contains(feature)) {
                features.add(feature);
            }
        }
        public boolean isAvailable(Date[] dateRange, List<Reservation> allHotelReservations) {
            if (status != RoomAvailabilityStatus.AVAILABLE && status != RoomAvailabilityStatus.RESERVED) { // Allow booking if AVAILABLE or RESERVED (could be reserved for different dates)
                 if (status == RoomAvailabilityStatus.OCCUPIED || status == RoomAvailabilityStatus.MAINTENANCE) return false;
            }
            if (dateRange == null || dateRange.length < 2 || dateRange[0] == null || dateRange[1] == null) return true;
            Date newBookingStart = dateRange[0]; Date newBookingEnd = dateRange[1];
            for (Reservation r : allHotelReservations) {
                if (r.getRoom().getRoomID().equals(roomID) && r.getStatus() != ReservationStatus.CANCELLED) {
                    if (r.getCheckinDate().before(newBookingEnd) && r.getCheckoutDate().after(newBookingStart)) return false;
                }
            }
            return true;
        }
        @Override
        public String toString() {
            return "Room #" + roomNumber + " - " + roomType.getName() + " (Status: " + status + ", Features: " + features + ")";
        }
    }

    static class Hotel {
        private String hotelID;
        private String name;
        private String address;
        private List<Room> rooms;
        private List<Reservation> reservations;

        public Hotel(String name, String address) {
            this.hotelID = UUID.randomUUID().toString();
            this.name = name;
            this.address = address;
            this.rooms = new ArrayList<>();
            this.reservations = new ArrayList<>();
        }
        public String getHotelID() { return hotelID; }
        public String getName() { return name; }
        public String getAddress() { return address; }
        public List<Room> getAllRooms() { return new ArrayList<>(rooms); }
        public List<Reservation> getAllReservations() { return new ArrayList<>(reservations); }
        public void setName(String name) { this.name = name; }
        public void setAddress(String address) { this.address = address; }
        public boolean addRoom(Room room) {
            if (room != null && getRoomByNumber(room.getRoomNumber()) == null) {
                rooms.add(room); room.setHotelID(hotelID); return true;
            }
            return false;
        }
        public Room getRoomByNumber(String roomNumber) {
            for (Room room : rooms) if (room.getRoomNumber().equals(roomNumber)) return room;
            return null;
        }
        public void addReservation(Reservation reservation) {
            if (reservation != null && !reservations.contains(reservation)) reservations.add(reservation);
        }
        public boolean removeReservation(String reservationID) { // Note: This is not used by main cancel flow
            return reservations.removeIf(res -> res.getReservationID().equals(reservationID));
        }
    }

    static class Customer {
        private String customerID;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private List<Reservation> reservations;

        public Customer(String firstName, String lastName, String email, String phone) {
            this.customerID = UUID.randomUUID().toString();
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.reservations = new ArrayList<>();
        }
        public String getCustomerID() { return customerID; }
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getEmail() { return email; }
        public String getPhone() { return phone; }
        public List<Reservation> viewReservations() { return new ArrayList<>(reservations); }
        public void setFirstName(String firstName) { this.firstName = firstName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public void setEmail(String email) { this.email = email; }
        public void setPhone(String phone) { this.phone = phone; }

        public Reservation makeReservation(Hotel hotel, Room room, Date checkinDate, Date checkoutDate, int noOfGuests) {
            if (hotel==null || room==null || checkinDate==null || checkoutDate==null || noOfGuests<=0) { System.err.println("Res Fail: Invalid params"); return null; }
            if (checkoutDate.before(checkinDate) || checkoutDate.equals(checkinDate)) { System.err.println("Res Fail: Checkout before/on check-in"); return null; }
            if (noOfGuests > room.getRoomType().getCapacity()) { System.err.println("Res Fail: Guests > capacity"); return null; }
            if (!room.isAvailable(new Date[]{checkinDate, checkoutDate}, hotel.getAllReservations())) { System.err.println("Res Fail: Room not available"); return null; }

            long diffInMillies = Math.abs(checkoutDate.getTime() - checkinDate.getTime());
            long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);
            if (diffInDays == 0) diffInDays = 1; // Min 1 day charge
            BigDecimal totalPrice = room.getRoomType().getPricePerNight().multiply(BigDecimal.valueOf(diffInDays));

            Reservation newRes = new Reservation(this, room, checkinDate, checkoutDate, noOfGuests, totalPrice);
            reservations.add(newRes); hotel.addReservation(newRes);
            // Consider setting room status to RESERVED here or after payment
            // room.setStatus(RoomAvailabilityStatus.RESERVED); 
            return newRes;
        }
        public boolean cancelReservation(String reservationID) {
            for (Reservation res : reservations) {
                if (res.getReservationID().equals(reservationID) && res.getStatus() != ReservationStatus.CANCELLED) {
                    res.setStatus(ReservationStatus.CANCELLED);
                    // Optionally set room status back to AVAILABLE if it was RESERVED
                    // res.getRoom().setStatus(RoomAvailabilityStatus.AVAILABLE);
                    return true;
                }
            }
            return false;
        }
        @Override
        public String toString() { return firstName + " " + lastName + " (" + email + ")"; }
    }

    static class Reservation {
        private String reservationID;
        private Customer customer;
        private Room room;
        private Date checkinDate;
        private Date checkoutDate;
        private Date bookingDate;
        private int noOfGuests;
        private ReservationStatus status;
        private BigDecimal totalPrice;
        private Payment payment;

        public Reservation(Customer cust, Room room, Date checkin, Date checkout, int guests, BigDecimal price) {
            this.reservationID = UUID.randomUUID().toString();
            this.customer = cust; this.room = room;
            this.checkinDate = checkin; this.checkoutDate = checkout;
            this.bookingDate = new Date(); this.noOfGuests = guests;
            this.status = ReservationStatus.PENDING; this.totalPrice = price;
        }
        public String getReservationID() { return reservationID; }
        public Customer getCustomer() { return customer; }
        public Room getRoom() { return room; }
        public Date getCheckinDate() { return checkinDate; }
        public Date getCheckoutDate() { return checkoutDate; }
        public Date getBookingDate() { return bookingDate; }
        public int getNoOfGuests() { return noOfGuests; }
        public ReservationStatus getStatus() { return status; }
        public BigDecimal getTotalPrice() { return totalPrice; }
        public Payment getPayment() { return payment; }
        public void setStatus(ReservationStatus status) { this.status = status; }
        public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }
        public void setPayment(Payment payment) { this.payment = payment; }
        
        public boolean processPayment(String method) {
            if (status == ReservationStatus.CANCELLED || status == ReservationStatus.COMPLETED) {
                System.err.println("Pay Fail: Res " + status); return false;
            }
            this.payment = new Payment(reservationID, totalPrice, method);
            this.status = ReservationStatus.CONFIRMED;
            // After successful payment, the room is definitively reserved for these dates.
            // The room's isAvailable check handles overlaps. Setting a specific RESERVED status might be redundant
            // or require more complex status management if room is shared across reservations (which it isn't typically).
            // For simplicity, isAvailable is the primary guard.
            // room.setStatus(RoomAvailabilityStatus.RESERVED); // This could be added
            return true;
        }
        @Override
        public String toString() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return "Res #" + reservationID + " Room: " + room.getRoomNumber() +
                   " Dates: " + sdf.format(checkinDate) + " to " + sdf.format(checkoutDate) +
                   " Guests: " + noOfGuests + " Status: " + status + " Total: $" + totalPrice +
                   (payment != null ? " PaymentID: " + payment.getPaymentID() : " NoPayment");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>(); List<Hotel> hotels = new ArrayList<>();
        initializeSampleData(customers, hotels);
        System.out.println("Welcome to Hotel Reservation System!");

        while (true) {
            System.out.println("\nMenu: 1.Reg Cust 2.Add Hotel/Room 3.View Rooms 4.Make Res 5.Cancel Res 6.View Res 7.Pay 8.Exit");
            System.out.print("Opt: ");
            int choice;
            try { choice = Integer.parseInt(scanner.nextLine()); } 
            catch (NumberFormatException e) { System.out.println("Invalid. Enter num."); continue; }

            switch (choice) {
                case 1: registerCustomer(scanner, customers); break;
                case 2: addHotelAndRoom(scanner, hotels); break;
                case 3: viewAvailableRooms(scanner, hotels); break;
                case 4: makeReservation(scanner, customers, hotels); break;
                case 5: cancelReservation(scanner, customers); break;
                case 6: viewReservations(customers); break;
                case 7: processPayment(scanner, customers); break;
                case 8: System.out.println("Exiting..."); scanner.close(); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void initializeSampleData(List<Customer> customers, List<Hotel> hotels) {
        customers.add(new Customer("John", "Doe", "john.doe@e.com", "12345"));
        customers.add(new Customer("Jane", "Smith", "jane.smith@e.com", "67890"));
        Hotel hotel1 = new Hotel("Grand Plaza", "1 Main St, NY"); hotels.add(hotel1);
        RoomType std = new RoomType("Standard", "Std room, queen bed", new BigDecimal("99.99"), 2);
        RoomType dlx = new RoomType("Deluxe", "Dlx room, king bed", new BigDecimal("149.99"), 3);
        RoomType sui = new RoomType("Suite", "Suite, living area", new BigDecimal("249.99"), 4);
        hotel1.addRoom(new Room(hotel1.getHotelID(), "101", std));
        hotel1.addRoom(new Room(hotel1.getHotelID(), "102", std));
        hotel1.addRoom(new Room(hotel1.getHotelID(), "201", dlx));
        hotel1.addRoom(new Room(hotel1.getHotelID(), "301", sui));
    }

    private static void registerCustomer(Scanner scanner, List<Customer> customers) {
        System.out.println("\n--- Register Customer ---");
        System.out.print("First Name: "); String fname = scanner.nextLine();
        System.out.print("Last Name: "); String lname = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Phone: "); String phone = scanner.nextLine();
        Customer customer = new Customer(fname, lname, email, phone); customers.add(customer);
        System.out.println("Customer registered: " + customer.getCustomerID());
    }

    private static void addHotelAndRoom(Scanner scanner, List<Hotel> hotels) {
        System.out.println("\n--- Add Hotel ---");
        System.out.print("Hotel Name: "); String hotelName = scanner.nextLine();
        System.out.print("Hotel Address: "); String hotelAddress = scanner.nextLine();
        Hotel hotel = new Hotel(hotelName, hotelAddress); hotels.add(hotel);
        System.out.println("Hotel added. Add room to " + hotel.getName() + ":");
        System.out.print("Room Number: "); String roomNum = scanner.nextLine();
        System.out.print("Room Type Name: "); String rtName = scanner.nextLine();
        System.out.print("Description: "); String desc = scanner.nextLine();
        System.out.print("Price/Night: "); BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.print("Capacity: "); int cap = Integer.parseInt(scanner.nextLine());
        RoomType roomType = new RoomType(rtName, desc, price, cap);
        Room room = new Room(hotel.getHotelID(), roomNum, roomType);
        if (hotel.addRoom(room)) System.out.println("Room " + roomNum + " added to " + hotel.getName());
        else System.out.println("Fail to add room " + roomNum + " (may exist).");
    }

    private static void viewAvailableRooms(Scanner scanner, List<Hotel> hotels) {
        if (hotels.isEmpty()) { System.out.println("No hotels available."); return; }
        System.out.println("\n--- Select Hotel ---");
        for (int i=0; i<hotels.size(); i++) System.out.println((i+1) + ". " + hotels.get(i).getName());
        System.out.print("Select hotel (1-" + hotels.size() + "): "); int hotelChoice = Integer.parseInt(scanner.nextLine()) - 1;
        if (hotelChoice<0 || hotelChoice>=hotels.size()) { System.out.println("Invalid hotel."); return; }
        Hotel selectedHotel = hotels.get(hotelChoice);
        System.out.print("Check-in (yyyy-mm-dd): "); Date checkin = parseDate(scanner.nextLine());
        System.out.print("Check-out (yyyy-mm-dd): "); Date checkout = parseDate(scanner.nextLine());
        if (checkin == null || checkout == null || checkout.before(checkin) || checkin.equals(checkout)) { System.out.println("Invalid dates."); return;}

        System.out.println("\nAvailable Rooms at " + selectedHotel.getName() + ":");
        boolean found = false;
        for (Room room : selectedHotel.getAllRooms()) {
            if (room.isAvailable(new Date[]{checkin, checkout}, selectedHotel.getAllReservations())) {
                System.out.println(room); found = true;
            }
        }
        if (!found) System.out.println("No rooms available for selected dates.");
    }

    private static void makeReservation(Scanner scanner, List<Customer> customers, List<Hotel> hotels) {
        if (customers.isEmpty()) { System.out.println("No customers. Register first."); return; }
        if (hotels.isEmpty()) { System.out.println("No hotels. Add first."); return; }
        
        System.out.println("\n--- Select Customer ---");
        for (int i=0; i<customers.size(); i++) System.out.println((i+1) + ". " + customers.get(i).getFirstName());
        System.out.print("Choose customer: "); int custIdx = Integer.parseInt(scanner.nextLine()) - 1;
        if (custIdx<0 || custIdx>=customers.size()) { System.out.println("Invalid customer."); return; }
        Customer customer = customers.get(custIdx);
        
        System.out.println("\n--- Select Hotel ---");
        for (int i=0; i<hotels.size(); i++) System.out.println((i+1) + ". " + hotels.get(i).getName());
        System.out.print("Choose hotel: "); int hotelIdx = Integer.parseInt(scanner.nextLine()) - 1;
        if (hotelIdx<0 || hotelIdx>=hotels.size()) { System.out.println("Invalid hotel."); return; }
        Hotel hotel = hotels.get(hotelIdx);
        
        System.out.print("Check-in (yyyy-mm-dd): "); Date checkin = parseDate(scanner.nextLine());
        System.out.print("Check-out (yyyy-mm-dd): "); Date checkout = parseDate(scanner.nextLine());
        if (checkin == null || checkout == null) { System.out.println("Date parsing failed."); return; }

        List<Room> availableRooms = new ArrayList<>();
        for (Room r : hotel.getAllRooms()) {
            if (r.isAvailable(new Date[]{checkin, checkout}, hotel.getAllReservations())) availableRooms.add(r);
        }
        if (availableRooms.isEmpty()) { System.out.println("No rooms available for dates."); return; }
        
        System.out.println("\nAvailable Rooms:");
        for (int i=0; i<availableRooms.size(); i++) System.out.println((i+1) + ". " + availableRooms.get(i).getRoomNumber() + " - " + availableRooms.get(i).getRoomType().getName());
        System.out.print("Choose room: "); int roomIdx = Integer.parseInt(scanner.nextLine()) - 1;
        if (roomIdx<0 || roomIdx>=availableRooms.size()) { System.out.println("Invalid room."); return; }
        Room room = availableRooms.get(roomIdx);
        
        System.out.print("Number of guests: "); int guests = Integer.parseInt(scanner.nextLine());
        Reservation res = customer.makeReservation(hotel, room, checkin, checkout, guests);
        if (res != null) System.out.println("\nReservation " + res.getReservationID() + " created!\n" + res);
    }

    private static void cancelReservation(Scanner scanner, List<Customer> customers) {
        if (customers.isEmpty()) { System.out.println("No customers."); return; }
        System.out.print("Enter reservation ID to cancel: "); String resID = scanner.nextLine();
        boolean found = false;
        for (Customer c : customers) {
            if (c.cancelReservation(resID)) {
                System.out.println("Reservation " + resID + " cancelled."); found = true; break;
            }
        }
        if (!found) System.out.println("Res " + resID + " not found or already cancelled.");
    }

    private static void viewReservations(List<Customer> customers) {
        if (customers.isEmpty()) { System.out.println("No customers."); return; }
        System.out.println("\n--- All Reservations ---");
        boolean hasRes = false;
        for (Customer c : customers) {
            List<Reservation> reservations = c.viewReservations();
            if (!reservations.isEmpty()) {
                System.out.println("\nCustomer: " + c.getFirstName() + " " + c.getLastName());
                for (Reservation res : reservations) System.out.println(res + "\n---------------------");
                hasRes = true;
            }
        }
        if (!hasRes) System.out.println("No reservations found.");
    }
    
    private static void processPayment(Scanner scanner, List<Customer> customers) {
        if (customers.isEmpty()) { System.out.println("No customers."); return; }
        System.out.print("Reservation ID for payment: "); String resID = scanner.nextLine();
        System.out.println("Pay methods: 1.CC 2.Debit 3.Bank Transfer 4.Cash");
        System.out.print("Select method (1-4): "); int methodChoice = Integer.parseInt(scanner.nextLine());
        String method;
        switch (methodChoice) {
            case 1: method = "Credit Card"; break; case 2: method = "Debit Card"; break;
            case 3: method = "Bank Transfer"; break; case 4: method = "Cash"; break;
            default: System.out.println("Invalid method."); return;
        }
        boolean found = false;
        for (Customer c : customers) {
            for (Reservation res : c.viewReservations()) {
                if (res.getReservationID().equals(resID)) {
                    if (res.processPayment(method)) System.out.println("Payment for " + resID + " ok!\n" + res);
                    else System.out.println("Payment fail for " + resID + " (status: " + res.getStatus() + ").");
                    found = true; break;
                }
            }
            if (found) break;
        }
        if (!found) System.out.println("Reservation " + resID + " not found.");
    }

    private static Date parseDate(String input) {
        try { return java.sql.Date.valueOf(input); } // Expects yyyy-mm-dd
        catch (IllegalArgumentException e) {
            System.out.println("Invalid date: '" + input + "'. Use yyyy-mm-dd. Op aborted.");
            return null; 
        }
    }
}