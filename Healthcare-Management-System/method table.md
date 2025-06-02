## Health Management System Methods

### Patient Class
| Method                           | Return Type  | Description |
|----------------------------------|-------------|-------------|
| getPatientId()                   | int         | Returns the unique ID of the patient |
| getName()                         | String      | Retrieves the patient's name |
| getAge()                          | int         | Returns the patient's age |
| getGender()                       | String      | Fetches the patient's gender |
| getPhoneNumber()                  | String      | Retrieves the contact number |
| getAddress()                      | String      | Fetches the residential address |
| getMedicalHistory()               | String      | Returns patient's medical history summary |
| getCurrentMedications()           | String      | Lists ongoing medications |
| getAssignedDoctor()               | int         | Returns the doctor ID assigned to the patient |

### Doctor Class
| Method                           | Return Type  | Description |
|----------------------------------|-------------|-------------|
| getDoctorId()                    | int         | Returns the unique ID of the doctor |
| getName()                         | String      | Retrieves the doctor's name |
| getSpecialization()               | String      | Fetches the doctor's field of expertise |
| getPhoneNumber()                  | String      | Returns the contact number |
| isAvailable()                     | boolean     | Checks if the doctor is available |
| getHospitalAffiliation()          | String      | Retrieves the hospital/clinic name |
| getYearsOfExperience()            | int         | Returns the number of years in medical practice |

### Appointment Class
| Method                           | Return Type  | Description |
|----------------------------------|-------------|-------------|
| getAppointmentId()                | int         | Returns the unique ID of the appointment |
| getPatientId()                    | int         | Fetches the patient ID linked to the appointment |
| getDoctorId()                     | int         | Retrieves the assigned doctor ID |
| getDate()                         | String      | Returns the scheduled appointment date |
| getTime()                         | String      | Fetches the scheduled appointment time |
| getStatus()                       | String      | Checks the appointment status (Scheduled, Completed, Canceled) |
| updateStatus(String status)       | void        | Updates the appointment status |

### Medical Record Class
| Method                           | Return Type  | Description |
|----------------------------------|-------------|-------------|
| getRecordId()                     | int         | Returns the unique ID for the medical record |
| getPatientId()                     | int         | Fetches the ID of the associated patient |
| getDoctorId()                      | int         | Retrieves the ID of the treating doctor |
| getDiagnosis()                     | String      | Returns the diagnosis details |
| getPrescribedMedications()         | String      | Lists medications prescribed |
| getTreatmentNotes()                | String      | Fetches treatment details and recommendations |

### Prescription Class
| Method                           | Return Type  | Description |
|----------------------------------|-------------|-------------|
| getPrescriptionId()               | int         | Returns the unique prescription ID |
| getPatientId()                    | int         | Fetches the patient ID receiving the prescription |
| getDoctorId()                     | int         | Retrieves the ID of the prescribing doctor |
| getMedicationName()                | String      | Returns the name of the prescribed medicine |
| getDosage()                        | String      | Fetches the recommended dosage |
| getDuration()                      | String      | Specifies the duration of medication intake |

### Billing Class
| Method                           | Return Type  | Description |
|----------------------------------|-------------|-------------|
| getBillId()                       | int         | Returns the unique billing record ID |
| getPatientId()                     | int         | Fetches the patient ID linked to the bill |
| getAmount()                        | double      | Returns the total bill amount |
| getPaymentStatus()                 | String      | Checks the payment status (Pending, Paid, Overdue) |
| getPaymentMethod()                 | String      | Fetches the payment type used |

### Feedback Class
| Method                           | Return Type  | Description |
|----------------------------------|-------------|-------------|
| getFeedbackId()                   | int         | Returns the unique feedback ID |
| getUserId()                        | int         | Retrieves the user ID providing the feedback |
| getRating()                        | double      | Returns the rating provided (1-5 stars) |
| getComments()                      | String      | Fetches the user's feedback comments |
| submitFeedback()                   | void        | Saves and stores feedback in the system |
