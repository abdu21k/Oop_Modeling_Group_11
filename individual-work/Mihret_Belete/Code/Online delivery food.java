// User.java
abstract class User {
    protected String id;
    protected String name;
    protected String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public abstract void showDashboard();
}

// Customer.java
class Customer extends User {
    public Customer(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void showDashboard() {
        System.out.println("Welcome, " + name + "! Browse menu and place your order.");
    }
}

// Restaurant.java
class Restaurant extends User {
    public Restaurant(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void showDashboard() {
        System.out.println("Restaurant Dashboard for: " + name);
    }
}

// DeliveryPerson.java
class DeliveryPerson extends User {
    public DeliveryPerson(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void showDashboard() {
        System.out.println("Delivery Dashboard for: " + name);
    }
}

// MenuItem.java
class MenuItem {
    String name;
    double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Order.java
class Order {
    private static int idCounter = 0;
    private int orderId;
    private Customer customer;
    private Restaurant restaurant;
    private MenuItem item;
    private String status;

    public Order(Customer customer, Restaurant restaurant, MenuItem item) {
        this.orderId = ++idCounter;
        this.customer = customer;
        this.restaurant = restaurant;
        this.item = item;
        this.status = "Placed";
    }

    public void trackOrder() {
        System.out.println("Order #" + orderId + " Status: " + status);
    }

    public void updateStatus(String status) {
        this.status = status;
    }
}

// Payment.java
class Payment {
    public static void processPayment(Customer customer, double amount) {
        System.out.println("Payment of $" + amount + " processed for " + customer.name);
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("C1", "Alice", "alice@example.com");
        Restaurant restaurant = new Restaurant("R1", "BurgerHouse", "contact@burgerhouse.com");
        MenuItem burger = new MenuItem("Cheeseburger", 5.99);

        customer.showDashboard();

        Order order = new Order(customer, restaurant, burger);
        order.trackOrder();

        Payment.processPayment(customer, burger.price);
        order.updateStatus("Out for Delivery");
        order.trackOrder();
    }
}
