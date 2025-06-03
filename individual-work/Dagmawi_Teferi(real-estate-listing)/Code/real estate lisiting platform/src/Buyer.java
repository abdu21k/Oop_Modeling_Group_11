import java.util.List;
import java.util.ArrayList;

public class Buyer extends User {
    private List<Property> savedProperties;

    public Buyer(String name, String email, String password) {
        super(name, email, password);
        this.savedProperties = new ArrayList<>();
    }
    public void saveProperty(Property p) {
        if (!savedProperties.contains(p)) {
            savedProperties.add(p);
            System.out.println("Property saved.");
        } else {
            System.out.println("Property already saved.");
        }
    }

    public void viewSavedProperties() {
        System.out.println("Saved Properties:");
        for (Property p : savedProperties) {
            System.out.println("- " + p.getTitle() + " | " + p.getLocation() + " | $" + p.getPrice());
        }
    }

    public List<Property> getSavedProperties() {
        return savedProperties;
    }
}
