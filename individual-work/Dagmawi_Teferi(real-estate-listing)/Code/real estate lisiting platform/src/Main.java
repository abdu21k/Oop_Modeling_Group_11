import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RealEstatePlatform platform = new RealEstatePlatform();

        System.out.println("Welcome to the Real Estate Listing Platform!");

        User currentUser = null;

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Add Property (Seller/Agent only)");
            System.out.println("3. View All Properties");
            System.out.println("4. Save Property (Buyer only)");
            System.out.println("5. View Saved Properties (Buyer only)");
            System.out.println("6. Switch User");
            System.out.println("7. Exit");


            System.out.print("Choose option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter Owner's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter your role (buyer/seller/agent): ");
                    String role = scanner.nextLine().toLowerCase();

                    switch (role) {
                        case "buyer":
                            currentUser = new Buyer(name, email, password);
                            break;
                        case "seller":
                            currentUser = new Seller(name, email, password);
                            break;
                        case "agent":
                            currentUser = new Agent(name, email, password);
                            break;
                        default:
                            System.out.println("Invalid role!");
                            continue;
                    }


                    platform.registerUser(currentUser);
                    System.out.println(role + " registered successfully.");
                    break;

                case 2:
                    if (currentUser instanceof Seller || currentUser instanceof Agent) {
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Location: ");
                        String location = scanner.nextLine();
                        double price = 0;
                        while (true) {
                            System.out.print("Price: ");
                            try {
                                price = scanner.nextDouble();
                                scanner.nextLine(); // consume newline
                                break;  // valid input, exit loop
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input! Please enter a valid number for the price.");
                                scanner.nextLine(); // clear invalid input
                            }
                        }

                        System.out.print("Type (House/Apartment/etc.): ");
                        String type = scanner.nextLine();
                        System.out.print("Description: ");
                        String desc = scanner.nextLine();

                        Property property = new Property(title, price, location, type, desc, currentUser);
                        platform.addProperty(property);

                        if (currentUser instanceof Seller) {
                            ((Seller) currentUser).addProperty(property);
                        } else if (currentUser instanceof Agent) {
                            ((Agent) currentUser).addProperty(property);
                        }


                        System.out.println("Property added!");
                    } else {
                        System.out.println("Only sellers or agents can add properties.");
                    }
                    break;

                case 3:
                    platform.showAllProperties();
                    break;

                case 4:
                    if (currentUser instanceof Buyer) {
                        platform.showAllProperties();
                        System.out.print("Enter Property ID to save: ");
                        int propId = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        Property selected = null;
                        for (Property p : platform.getAllProperties()) {
                            if (p.getId() == propId) {
                                selected = p;
                                break;
                            }
                        }

                        if (selected != null) {
                            ((Buyer) currentUser).saveProperty(selected);
                            System.out.println("Property saved.");
                        } else {
                            System.out.println("Property not found.");
                        }
                    } else {
                        System.out.println("Only buyers can save properties.");
                    }
                    break;

                case 5:
                    if (currentUser instanceof Buyer) {
                        List<Property> saved = ((Buyer) currentUser).getSavedProperties();
                        if (saved.isEmpty()) {
                            System.out.println("No saved properties.");
                        } else {
                            System.out.println("Saved Properties:");
                            for (Property p : saved) {
                                System.out.println(p);
                            }
                        }
                    } else {
                        System.out.println("Only buyers can view saved properties.");
                    }
                    break;

                case 6:
                    if (platform.getUsers().isEmpty()) {
                        System.out.println("No users registered yet.");
                        break;
                    }

                    System.out.print("Enter your name: ");
                    String switchName = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String switchPassword = scanner.nextLine();

                    boolean found = false;
                    for (User u : platform.getUsers()) {
                        if (u.getName().equalsIgnoreCase(switchName) && u.getPassword().equals(switchPassword)) {
                            currentUser = u;
                            found = true;
                            System.out.println("Switched to user: " + currentUser.getName());
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("User not found or password incorrect.");
                    }
                    break;

                case 7:
                    System.out.println("Thank you for using the Real Estate Platform!");
                    scanner.close();
                    return;



                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
