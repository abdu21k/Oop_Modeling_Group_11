import java.util.ArrayList;
import java.util.List;

public class RealEstatePlatform {

    private List<User> users;               // All registered users
    private List<Property> allProperties;   // All properties listed on the platform

    public RealEstatePlatform() {
        this.users = new ArrayList<>();
        this.allProperties = new ArrayList<>();
    }

    // Register a new user
    public void registerUser(User user) {
        users.add(user);
        System.out.println(user.getName() + " registered successfully!");
    }

    // Add a property (for sellers or agents)
    public void addProperty(Property property) {
        allProperties.add(property);
        System.out.println("Property '" + property.getTitle() + "' added to platform.");
    }

    // Show all available properties
    public void showAllProperties() {
        if (allProperties.isEmpty()) {
            System.out.println("No properties available.");
        } else {
            for (Property property : allProperties) {
                System.out.println(property);
            }
        }
    }

    // Get all properties
    public List<Property> getAllProperties() {
        return allProperties;
    }

    // Get all users
    public List<User> getUsers() {
        return users;
    }
}
