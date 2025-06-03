public class Property {
    private static int counter = 1;
    private int id;
    private String title;
    private double price;
    private String location;
    private String type;
    private String description;
    private User owner;

    public Property(String title, double price, String location, String type, String description, User owner) {
        this.id = counter++;
        this.title = title;
        this.price = price;
        this.location = location;
        this.type = type;
        this.description = description;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public User getOwner() {
        return owner;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "ID: " + id +
                ", Title: " + title +
                ", Price: " + price +"birr"+
                ", Location: " + location +
                ", Type: " + type +
                ", Description: " + description +
                ", Owner: " + owner.getName();
    }

}
