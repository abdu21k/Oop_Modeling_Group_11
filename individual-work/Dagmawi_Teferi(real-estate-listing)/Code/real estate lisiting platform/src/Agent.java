import java.util.ArrayList;
import java.util.List;

public class Agent extends User {
    private List<Property> listings;

    public Agent(String name, String email, String password) {
        super(name, email, password);
        this.listings = new ArrayList<>();
    }

    public void addProperty(Property property) {
        listings.add(property);
    }

    public List<Property> getListings() {
        return listings;
    }
}
