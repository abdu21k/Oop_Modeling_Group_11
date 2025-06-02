import java.util.ArrayList;

// Abstract Class: Person
abstract class Person {
    private String name, phoneNumber, address;

    public Person(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }

    public abstract void displayDetails();
}

// Interface for Medical Services
interface MedicalServices {
    void diagnose();
    void prescribeMedication();
}

// Interface for Billing System
interface BillingSystem {
    void generateInvoice();
}

// Doctor Class (Inherits Person & Implements MedicalServices)
class Doctor extends Person implements MedicalServices {
    private int doctorId;
    private String specialization;
    private int yearsOfExperience;
    private boolean availability;

    public Doctor(int doctorId, String name, String phoneNumber, String address,
                  String specialization, int yearsOfExperience, boolean availability) {
        super(name, phoneNumber, address);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
        this.availability = availability;
    }

    public int getDoctorId() { return doctorId; }
    public String getSpecialization() { return specialization; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public boolean isAvailable() { return availability; }

    @Override
    public void diagnose() {
        System.out.println("Doctor " + getName() + " is diagnosing a patient.");
    }

    @Override
    public void prescribeMedication() {
        System.out.println("Doctor " + getName() + " has prescribed medication.");
    }

    @Override
    public void displayDetails() {
        System.out.println("Doctor ID: " + doctorId + " | Name: " + getName() + " | Specialization: " + specialization);
    }
}

// Patient Class (Inherits Person)
class Patient extends Person {
    private int patientId;
    private int age;
    private String gender, medicalHistory, currentMedications;
    private int assignedDoctor;

    public Patient(int patientId, String name, int age, String gender, String phoneNumber, String address,
                   String medicalHistory, String currentMedications, int assignedDoctor) {
        super(name, phoneNumber, address);
        this.patientId = patientId;
        this.age = age;
        this.gender = gender;
        this.medicalHistory = medicalHistory;
        this.currentMedications = currentMedications;
        this.assignedDoctor = assignedDoctor;
    }

    public int getPatientId() { return patientId; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getMedicalHistory() { return medicalHistory; }
    public String getCurrentMedications() { return currentMedications; }
    public int getAssignedDoctor() { return assignedDoctor; }

    @Override
    public void displayDetails() {
        System.out.println("Patient ID: " + patientId + " | Name: " + getName() + " | Age: " + age);
    }
}

// Billing Class (Implements BillingSystem)
class Billing implements BillingSystem {
    private int billId, patientId;
    private double amount;
    private String paymentStatus, paymentMethod;

    public Billing(int billId, int patientId, double amount, String paymentStatus, String paymentMethod) {
        this.billId = billId;
        this.patientId = patientId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
    }

    public int getBillId() { return billId; }
    public int getPatientId() { return patientId; }
    public double getAmount() { return amount; }
    public String getPaymentStatus() { return paymentStatus; }
    public String getPaymentMethod() { return paymentMethod; }

    @Override
    public void generateInvoice() {
        System.out.println("Generating invoice for Patient ID: " + patientId + " - Amount: $" + amount);
    }
}

// Feedback Class
class Feedback {
    private int feedbackId, userId;
    private double rating;
    private String comments;

    public Feedback(int feedbackId, int userId, double rating, String comments) {
        this.feedbackId = feedbackId;
        this.userId = userId;
        this.rating = rating;
        this.comments = comments;
    }

    public int getFeedbackId() { return feedbackId; }
    public int getUserId() { return userId; }
    public double getRating() { return rating; }
    public String getComments() { return comments; }
    public void submitFeedback() { System.out.println("Feedback submitted successfully."); }
}

// Main System
public class HealthManagementSystem {
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Billing> billings = new ArrayList<>();
    private static ArrayList<Feedback> feedbacks = new ArrayList<>();

    public static void main(String[] args) {
        // Sample Data
        doctors.add(new Doctor(1, "Dr. John Doe", "1234567890", "City Hospital", "Cardiology", 10, true));
        patients.add(new Patient(1, "Alice Smith", 30, "Female", "0987654321", "123 Main St", "No prior issues", "None", 1));
        billings.add(new Billing(1, 1, 250.00, "Paid", "Card"));
        feedbacks.add(new Feedback(1, 1, 5.0, "Excellent service!"));

        // Testing System Functionality
        doctors.get(0).displayDetails();
        doctors.get(0).diagnose();
        doctors.get(0).prescribeMedication();
        
        patients.get(0).displayDetails();
        
        billings.get(0).generateInvoice();
        
        feedbacks.get(0).submitFeedback();

        System.out.println("Health Management System is Fully Functional!");
    }
}
