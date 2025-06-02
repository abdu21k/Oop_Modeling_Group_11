## Health Management System Attributes

### Patient
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| patientId      | int       | Unique identifier for the patient |
| name           | String    | Patient's full name |
| age            | int       | Patient's age |
| gender         | String    | Patient’s gender (Male, Female, Other) |
| phoneNumber    | String    | Contact number for the patient |
| address        | String    | Residential address |
| medicalHistory | String    | Summary of past medical conditions |
| currentMedications | String | List of ongoing medications |
| assignedDoctor | int       | ID of the doctor assigned to the patient |

### Doctor
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| doctorId       | int       | Unique identifier for the doctor |
| name           | String    | Doctor's full name |
| specialization | String    | Field of expertise (Cardiology, Orthopedics, etc.) |
| phoneNumber    | String    | Contact number |
| availability   | boolean   | Whether the doctor is available for consultation |
| hospitalAffiliation | String | Name of the hospital/clinic |
| yearsOfExperience | int    | Number of years in medical practice |

### Appointment
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| appointmentId  | int       | Unique identifier for the appointment |
| patientId      | int       | ID of the patient booking the appointment |
| doctorId       | int       | ID of the doctor assigned to the appointment |
| date           | String    | Scheduled date of the appointment |
| time           | String    | Scheduled time of the appointment |
| status        | String    | Status of the appointment (Scheduled, Completed, Canceled) |

### Medical Record
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| recordId       | int       | Unique identifier for the medical record |
| patientId      | int       | ID of the associated patient |
| doctorId       | int       | ID of the treating doctor |
| diagnosis      | String    | Diagnosis provided by the doctor |
| prescribedMedications | String | Medications prescribed for treatment |
| treatmentNotes | String    | Doctor's notes on treatment |

### Prescription
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| prescriptionId | int       | Unique identifier for the prescription |
| patientId      | int       | ID of the patient receiving the prescription |
| doctorId       | int       | ID of the prescribing doctor |
| medicationName | String    | Name of the prescribed medicine |
| dosage         | String    | Recommended dosage (e.g., 500mg twice a day) |
| duration       | String    | Duration of medication intake (e.g., 7 days) |

### Billing
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| billId         | int       | Unique identifier for the billing record |
| patientId      | int       | ID of the patient associated with the bill |
| amount         | double    | Total bill amount |
| paymentStatus  | String    | Status of payment (Pending, Paid, Overdue) |
| paymentMethod  | String    | Method of payment (Cash, Card, Insurance) |

### Feedback
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| feedbackId     | int       | Unique identifier for feedback |
| userId         | int       | ID of the user providing feedback |
| rating         | double    | Rating provided (1-5 stars) |
| comments       | String    | Additional feedback comments |
