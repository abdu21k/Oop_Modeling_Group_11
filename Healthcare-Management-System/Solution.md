
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><title>Healthcare Management System - OOP Design</title></head>
<body>
<h1>Healthcare Management System - Object-Oriented Design</h1>
<p>We consider a set of classes typical for a Healthcare Management System. These include user roles (User, Patient, Doctor, Admin) and operational entities (Appointment, MedicalRecord, TimeSlot):contentReference[oaicite:0]{index=0}. Each class is defined with its attributes and methods below, illustrating how they model the system. Key class relationships and OOP design principles (encapsulation, inheritance, abstraction, association) are then discussed.</p>

<h2>User</h2>
<p>The <em>User</em> class is a general base class for all system users, capturing common identity and authentication data. It is inherited by specialized classes such as <em>Patient</em>, <em>Doctor</em>, and <em>Admin</em>:contentReference[oaicite:1]{index=1}. Typical attributes include a unique user ID, name, email, password, and contact information, all encapsulated within the class for secure access. Methods often include <code>login()</code>, <code>logout()</code>, and <code>updateProfile()</code> to manage the user account.</p>
<h3>Attributes</h3>
<table>
  <tr><th>Name</th><th>Type</th><th>Description</th></tr>
  <tr><td>userID</td><td>int</td><td>Unique identifier for the user</td></tr>
  <tr><td>username</td><td>String</td><td>User login name or identifier</td></tr>
  <tr><td>password</td><td>String</td><td>Password (stored securely, e.g., hashed)</td></tr>
  <tr><td>name</td><td>String</td><td>Full name of the user</td></tr>
  <tr><td>email</td><td>String</td><td>Email address of the user</td></tr>
  <tr><td>contactNumber</td><td>String</td><td>Phone number or contact information</td></tr>
</table>
<h3>Methods</h3>
<table>
  <tr><th>Name</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>login()</td><td>boolean</td><td>Authenticate the user (returns success/failure)</td></tr>
  <tr><td>logout()</td><td>void</td><td>End the user session</td></tr>
  <tr><td>updateProfile()</td><td>void</td><td>Update user personal details</td></tr>
  <tr><td>changePassword()</td><td>void</td><td>Change the user password</td></tr>
</table>

<h2>Patient</h2>
<p>The <em>Patient</em> class extends <em>User</em> with patient-specific information. For example, it might include attributes like <code>patientID</code>, <code>name</code>, <code>gender</code>, <code>dateOfBirth</code>, and <code>contactDetails</code>:contentReference[oaicite:2]{index=2}. Methods in <em>Patient</em> include <code>viewMedicalRecord()</code> (to access personal medical history) and <code>bookAppointment()</code> (to schedule a new appointment). These use inherited login behavior but add functionality for patients (e.g., accessing medical records).</p>
<h3>Attributes</h3>
<table>
  <tr><th>Name</th><th>Type</th><th>Description</th></tr>
  <tr><td>patientID</td><td>int</td><td>Unique identifier for the patient</td></tr>
  <tr><td>name</td><td>String</td><td>Patient's full name</td></tr>
  <tr><td>gender</td><td>String</td><td>Patient's gender</td></tr>
  <tr><td>dateOfBirth</td><td>Date</td><td>Patient's birth date</td></tr>
  <tr><td>contactDetails</td><td>String</td><td>Phone and address of the patient</td></tr>
</table>
<h3>Methods</h3>
<table>
  <tr><th>Name</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>viewMedicalRecord()</td><td>MedicalRecord[]</td><td>Retrieve the patient's medical records</td></tr>
  <tr><td>bookAppointment(doctorID, slot)</td><td>Appointment</td><td>Schedule a new appointment with a doctor</td></tr>
  <tr><td>cancelAppointment(appointmentID)</td><td>boolean</td><td>Cancel a previously scheduled appointment</td></tr>
  <tr><td>updateContactInfo()</td><td>void</td><td>Update the patient's contact information</td></tr>
</table>

<h2>Doctor</h2>
<p>The <em>Doctor</em> class also extends <em>User</em> and adds doctor-specific data. Example attributes include <code>doctorID</code>, <code>name</code>, <code>specialization</code>, and <code>contactDetails</code>:contentReference[oaicite:3]{index=3}. Doctors have methods such as <code>viewAppointments()</code> to see upcoming appointments, <code>prescribeTreatment()</code> to update medical records, and <code>addAvailability()</code> to set available time slots.</p>
<h3>Attributes</h3>
<table>
  <tr><th>Name</th><th>Type</th><th>Description</th></tr>
  <tr><td>doctorID</td><td>int</td><td>Unique identifier for the doctor</td></tr>
  <tr><td>name</td><td>String</td><td>Doctor's full name</td></tr>
  <tr><td>specialization</td><td>String</td><td>Medical specialty (e.g., cardiology)</td></tr>
  <tr><td>contactDetails</td><td>String</td><td>Phone and email of the doctor</td></tr>
  <tr><td>schedule</td><td>TimeSlot[]</td><td>Available time slots for appointments</td></tr>
</table>
<h3>Methods</h3>
<table>
  <tr><th>Name</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>viewAppointments()</td><td>Appointment[]</td><td>Retrieve all upcoming appointments</td></tr>
  <tr><td>prescribeTreatment(patientID)</td><td>void</td><td>Write or update the patient's treatment plan</td></tr>
  <tr><td>addAvailability(slot)</td><td>boolean</td><td>Mark a time slot as available for booking</td></tr>
  <tr><td>removeAvailability(slot)</td><td>boolean</td><td>Remove an available time slot</td></tr>
</table>

<h2>Admin</h2>
<p>The <em>Admin</em> class extends <em>User</em> and represents system administrators. Its attributes may include <code>adminID</code>, <code>name</code>, <code>department</code>, and <code>contactDetails</code>:contentReference[oaicite:4]{index=4}. Admin methods typically involve system-wide management tasks, such as <code>addUser()</code> or <code>removeUser()</code> to manage user accounts, and <code>generateReport()</code> to compile system statistics.</p>
<h3>Attributes</h3>
<table>
  <tr><th>Name</th><th>Type</th><th>Description</th></tr>
  <tr><td>adminID</td><td>int</td><td>Unique identifier for the admin</td></tr>
  <tr><td>name</td><td>String</td><td>Administrator's full name</td></tr>
  <tr><td>department</td><td>String</td><td>Department or unit the admin oversees</td></tr>
  <tr><td>contactDetails</td><td>String</td><td>Phone and email of the admin</td></tr>
</table>
<h3>Methods</h3>
<table>
  <tr><th>Name</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>addUser(user)</td><td>boolean</td><td>Create a new user account</td></tr>
  <tr><td>removeUser(userID)</td><td>boolean</td><td>Delete an existing user account</td></tr>
  <tr><td>updateUser(user)</td><td>boolean</td><td>Modify details of an existing user</td></tr>
  <tr><td>generateReport()</td><td>Report</td><td>Generate administrative reports and statistics</td></tr>
</table>

<h2>Appointment</h2>
<p>The <em>Appointment</em> class represents a scheduled meeting between a patient and a doctor. Its key attributes include <code>appointmentID</code>, <code>patientID</code>, <code>doctorID</code>, <code>appointmentDate</code>, <code>appointmentTime</code>, and <code>status</code> (e.g., scheduled, completed):contentReference[oaicite:5]{index=5}. Methods often allow managing the appointment: for example, <code>scheduleAppointment()</code>, <code>cancelAppointment()</code>, and <code>rescheduleAppointment()</code> to change the appointment time.</p>
<h3>Attributes</h3>
<table>
  <tr><th>Name</th><th>Type</th><th>Description</th></tr>
  <tr><td>appointmentID</td><td>int</td><td>Unique identifier for the appointment</td></tr>
  <tr><td>patientID</td><td>int</td><td>ID of the patient (foreign key)</td></tr>
  <tr><td>doctorID</td><td>int</td><td>ID of the doctor (foreign key)</td></tr>
  <tr><td>appointmentDate</td><td>Date</td><td>Date of the appointment</td></tr>
  <tr><td>appointmentTime</td><td>Time</td><td>Time of the appointment</td></tr>
  <tr><td>status</td><td>String</td><td>Appointment status (e.g., Scheduled/Cancelled)</td></tr>
</table>
<h3>Methods</h3>
<table>
  <tr><th>Name</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>scheduleAppointment()</td><td>boolean</td><td>Reserve the appointment slot (returns true if successful):contentReference[oaicite:6]{index=6}</td></tr>
  <tr><td>cancelAppointment()</td><td>boolean</td><td>Cancel the appointment (make the slot available)</td></tr>
  <tr><td>rescheduleAppointment(newDate, newTime)</td><td>boolean</td><td>Change the appointment's date or time</td></tr>
  <tr><td>updateStatus(status)</td><td>void</td><td>Update the appointment status</td></tr>
</table>

<h2>MedicalRecord</h2>
<p>The <em>MedicalRecord</em> class stores clinical information for a patient. Attributes may include <code>recordID</code>, <code>patientID</code>, <code>doctorID</code>, <code>diagnosis</code>, <code>medications</code>, and <code>treatmentPlan</code>:contentReference[oaicite:7]{index=7}. Methods include <code>addRecord()</code> to create a new record entry, <code>updateRecord()</code> to modify existing records, and <code>getRecords()</code> to retrieve a patient’s history.</p>
<h3>Attributes</h3>
<table>
  <tr><th>Name</th><th>Type</th><th>Description</th></tr>
  <tr><td>recordID</td><td>int</td><td>Unique identifier for the medical record</td></tr>
  <tr><td>patientID</td><td>int</td><td>ID of the patient (foreign key)</td></tr>
  <tr><td>doctorID</td><td>int</td><td>ID of the doctor (foreign key)</td></tr>
  <tr><td>diagnosis</td><td>String</td><td>Diagnosis details</td></tr>
  <tr><td>medications</td><td>String</td><td>Prescribed medications</td></tr>
  <tr><td>treatmentPlan</td><td>String</td><td>Recommended treatment plan</td></tr>
</table>
<h3>Methods</h3>
<table>
  <tr><th>Name</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>addRecord()</td><td>void</td><td>Create a new medical record entry</td></tr>
  <tr><td>updateRecord()</td><td>void</td><td>Update information in an existing record</td></tr>
  <tr><td>getRecords(patientID)</td><td>MedicalRecord[]</td><td>Retrieve all records for a patient</td></tr>
  <tr><td>deleteRecord(recordID)</td><td>boolean</td><td>Remove a medical record entry</td></tr>
</table>

<h2>TimeSlot</h2>
<p>The <em>TimeSlot</em> class represents an available period for scheduling. It might include attributes such as <code>slotID</code>, <code>startTime</code>, <code>endTime</code>, and <code>isAvailable</code>. Methods could include <code>bookSlot()</code> to mark the slot as occupied and <code>cancelSlot()</code> to free it. A <em>TimeSlot</em> is typically associated with a <em>Doctor</em> or <em>Appointment</em> to manage schedules.</p>
<h3>Attributes</h3>
<table>
  <tr><th>Name</th><th>Type</th><th>Description</th></tr>
  <tr><td>slotID</td><td>int</td><td>Unique identifier for the time slot</td></tr>
  <tr><td>startTime</td><td>DateTime</td><td>Start time of the slot</td></tr>
  <tr><td>endTime</td><td>DateTime</td><td>End time of the slot</td></tr>
  <tr><td>isAvailable</td><td>boolean</td><td>Whether the slot is available for booking</td></tr>
</table>
<h3>Methods</h3>
<table>
  <tr><th>Name</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>bookSlot()</td><td>boolean</td><td>Mark the slot as booked (unavailable)</td></tr>
  <tr><td>cancelSlot()</td><td>boolean</td><td>Free the slot for booking</td></tr>
  <tr><td>isAvailable()</td><td>boolean</td><td>Check availability status</td></tr>
  <tr><td>toString()</td><td>String</td><td>Return human-readable slot time</td></tr>
</table>

<h2>Key Class Relationships</h2>
<ul>
  <li><strong>Inheritance:</strong> The base <em>User</em> class is extended by <em>Patient</em>, <em>Doctor</em>, and <em>Admin</em>, allowing code reuse of common attributes and methods:contentReference[oaicite:8]{index=8}:contentReference[oaicite:9]{index=9}.</li>
  <li><strong>Associations:</strong> Each <em>Doctor</em> can have many <em>Appointment</em> instances, and similarly each <em>Patient</em> can have many <em>Appointment</em> instances (one-to-many relationships):contentReference[oaicite:10]{index=10}:contentReference[oaicite:11]{index=11}.</li>
  <li><strong>Other relationships:</strong> A <em>MedicalRecord</em> is associated with one <em>Patient</em> (and one <em>Doctor</em>) each, modeling the patient’s health records. Each <em>Appointment</em> is linked to exactly one <em>TimeSlot</em> (and vice versa for scheduling).</li>
</ul>

<h2>Object-Oriented Principles Applied</h2>
<ul>
  <li><strong>Encapsulation:</strong> Data fields in each class are kept private and accessed via public methods. This wraps data and behavior in a single unit:contentReference[oaicite:12]{index=12}. For example, sensitive attributes like passwords are hidden inside <em>User</em> and only accessed through authentication methods.</li>
  <li><strong>Inheritance:</strong> Common features are factored into base classes. Here, <em>User</em> provides shared attributes (ID, name, email) and <code>login()</code> methods for all roles, while subclasses <em>Patient</em>, <em>Doctor</em>, and <em>Admin</em> inherit these features:contentReference[oaicite:13]{index=13}:contentReference[oaicite:14]{index=14}. This avoids code duplication.</li>
  <li><strong>Abstraction:</strong> Each class represents a clear concept (e.g., Patient, Appointment) and exposes only relevant details, hiding internal complexity:contentReference[oaicite:15]{index=15}. For instance, the <em>Appointment</em> class abstracts scheduling so higher-level code need not manage time details directly.</li>
  <li><strong>Association:</strong> Classes interact through relationships. For example, the <em>Doctor</em> class is associated with <em>Appointment</em> (a doctor can have many appointments):contentReference[oaicite:16]{index=16}:contentReference[oaicite:17]{index=17}, and the <em>Patient</em> class likewise. These associations allow objects to reference each other and work together (e.g. a patient booking a doctor’s appointment).</li>
</ul>

</body>
</html>
