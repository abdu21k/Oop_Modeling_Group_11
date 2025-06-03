import java.util.ArrayList;
import java.util.List;

public class Seller extends User {
    private List<Property> listedProperties;

    public Seller(String name, String email, String password) {
        super(name, email, password);
        this.listedProperties = new ArrayList<>();
    }

    public void addProperty(Property property) {
        listedProperties.add(property);
        System.out.println("Property added: " + property.getTitle());
    }

    public void removeProperty(Property property) {
        if (listedProperties.remove(property)) {
            System.out.println("Property removed: " + property.getTitle());
        } else {
            System.out.println("Property not found.");
        }
    }

    public List<Property> getListedProperties() {
        return listedProperties;
    }

    public void showMyListings() {
        if (listedProperties.isEmpty()) {
            System.out.println("No properties listed.");
        } else {
            System.out.println("Listed Properties:");
            for (Property p : listedProperties) {
                System.out.println("- " + p.getTitle() + " | " + p.getPrice() + " | " + p.getLocation());
            }
        }
    }
}
