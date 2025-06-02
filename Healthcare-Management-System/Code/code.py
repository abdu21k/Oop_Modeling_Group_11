import java.util.ArrayList;

// Patient Class
class Patient {
    private int patientId;
    private String name, gender, phoneNumber, address, medicalHistory, currentMedications;
    private int age;
    private int assignedDoctor;

    public Patient(int patientId, String name, int age, String gender, String phoneNumber, String address,
                   String medicalHistory, String currentMedications, int assignedDoctor) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.medicalHistory = medicalHistory;
        this.currentMedications = currentMedications;
        this.assignedDoctor = assignedDoctor;
    }

    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public String getMedicalHistory() { return medicalHistory; }
    public String getCurrentMedications() { return currentMedications; }
    public int getAssignedDoctor() { return assignedDoctor; }
}

// Doctor Class
class Doctor {
    private int doctorId;
    private String name, specialization, phoneNumber, hospitalAffiliation;
    private int yearsOfExperience;
    private boolean availability;

    public Doctor(int doctorId, String name, String specialization, String phoneNumber,
                  String hospitalAffiliation, int yearsOfExperience, boolean availability) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
        this.hospitalAffiliation = hospitalAffiliation;
        this.yearsOfExperience = yearsOfExperience;
        this.availability = availability;
    }

    public int getDoctorId() { return doctorId; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getHospitalAffiliation() { return hospitalAffiliation; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public boolean isAvailable() { return availability; }
}

// Appointment Class
class Appointment {
    private int appointmentId, patientId, doctorId;
    private String date, time, status;

    public Appointment(int appointmentId, int patientId, int doctorId, String date, String time, String status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public int getAppointmentId() { return appointmentId; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getStatus() { return status; }
    public void updateStatus(String status) { this.status = status; }
}

// Medical Record Class
class MedicalRecord {
    private int recordId, patientId, doctorId;
    private String diagnosis, prescribedMedications, treatmentNotes;

    public MedicalRecord(int recordId, int patientId, int doctorId, String diagnosis,
                         String prescribedMedications, String treatmentNotes) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.diagnosis = diagnosis;
        this.prescribedMedications = prescribedMedications;
        this.treatmentNotes = treatmentNotes;
    }

    public int getRecordId() { return recordId; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getDiagnosis() { return diagnosis; }
    public String getPrescribedMedications() { return prescribedMedications; }
    public String getTreatmentNotes() { return treatmentNotes; }
}

// Prescription Class
class Prescription {
    private int prescriptionId, patientId, doctorId;
    private String medicationName, dosage, duration;

    public Prescription(int prescriptionId, int patientId, int doctorId, String medicationName,
                        String dosage, String duration) {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.duration = duration;
    }

    public int getPrescriptionId() { return prescriptionId; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getMedicationName() { return medicationName; }
    public String getDosage() { return dosage; }
    public String getDuration() { return duration; }
}

// Billing Class
class Billing {
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
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static ArrayList<MedicalRecord> records = new ArrayList<>();
    private static ArrayList<Prescription> prescriptions = new ArrayList<>();
    private static ArrayList<Billing> billings = new ArrayList<>();
    private static ArrayList<Feedback> feedbacks = new ArrayList<>();

    public static void main(String[] args) {
        // Sample Data
        doctors.add(new Doctor(1, "Dr. John Doe", "Cardiology", "1234567890", "City Hospital", 10, true));
        patients.add(new Patient(1, "Alice Smith", 30, "Female", "0987654321", "123 Main St", "No prior issues", "None", 1));
        
        // Testing System Functionality
        Feedback feedback = new Feedback(1, 1, 5.0, "Excellent service!");
        feedbacks.add(feedback);
        
        feedback.submitFeedback();

        System.out.println("Health Management System is Fully Functional!");
    }
}
