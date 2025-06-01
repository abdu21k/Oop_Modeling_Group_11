import java.util.ArrayList;
import java.util.scanner;
class product {
    int id;
    string name;
    int quantity;
    public Product(int id, String name, int quantity){ 
        this.id = id; 
        this.name = name; 
        this.quantity = quantity;
    } 
    public String toString() {
        return id + ". " + name + " | Qty: " + quantity;
    }
}
public class main {
    static Arraylist<product> products = new Arraylist<>();
    static int nextid=1;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Inventory System ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Purchase Product");
            System.out.println("4. Sell Product");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = input.nextInt();
            switch (choice) {
                case 1: addProduct(input);
                break;
                case 2:
                    viewProducts();
                    break; 
                case 3:
                        purchaseProduct(input);
                        break;
                case 4:
                            sellProduct(input);
                            break;
                case 0:
                    System.out.println("Goodbye!"); 
                    break;
                default: System.out.println("Invalid choice.");
                } 
        } while (choice != 0);
        input.close(); } 
        public static void addProduct(Scanner input) {
            System.out.print("Enter product name: "); 
            input.nextLine(); 
            String name = input.nextLine();
            System.out.print("Enter quantity: "); 
            int qty = input.nextInt();
            products.add(new Product(nextId++, name, qty));
            System.out.println("Product added."); } 
        public static void viewProducts() { 
            if (products.isEmpty()) { 
                System.out.println("No products.");
                } else {
                    for (Product p : products) { 
                        System.out.println(p);
                        }
                    }
                }
                        public static void purchaseProduct(Scanner input) { 
                            System.out.print("Enter product ID: ");
                            int id = input.nextInt();
                            System.out.print("Enter amount to purchase: ");
                            int amount = input.nextInt();
                            for (Product p : products) {
                                if (p.id == id) 
                                {
                                    p.quantity += amount;
                                System.out.println("Stock updated.");
                                return;
                                } 
                                
                           }
                           System.out.println("Product not found.");
                           }
                           public static void sellProduct(Scanner input) {
                               System.out.print("Enter product ID: "); 
                               int id = input.nextInt();
                               System.out.print("Enter amount to sell: ");
                               int amount = input.nextInt();
                               for (Product p : products) { 
                                   if (p.id == id) {
                                       if (p.quantity >= amount) {
                                           p.quantity -= amount; 
                                           System.out.println("Sale recorded.");
                                           }
                                           else {
                                               System.out.println("Not enough stock."); 
                                               
                                           } return; 
                                       
                                   } 
                                   
                               } System.out.println("Product not found."); }
}
