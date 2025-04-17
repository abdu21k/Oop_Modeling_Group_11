<h1>Domain 6: Healthcare Management System</h1>

<h2>Question</h2>
<p>
  The goal of this project is to model a healthcare management system using object-oriented programming concepts. 
  The system should help organize and manage core operations within a healthcare facility like a clinic or small hospital.
</p>
<p>
  It should support three main types of users: patients, doctors, and admins. Patients need to be able to register, 
  log in, and book appointments with doctors based on availability and specialization. Doctors should be able to manage 
  their appointments, view basic information about their patients, and add visit notes or medical summaries. Admins 
  will oversee the system by managing user accounts, assigning doctors, and controlling appointment schedules.
</p>
<p>
  The model should clearly show how the different parts of the system are connected. For example, patients can have 
  multiple appointments with different doctors, and doctors should be able to track all their appointments and update 
  patient records accordingly. The design should use important OOP principles like encapsulation, inheritance 
  (especially for user roles), and association between classes.
</p>

<h2>Scope</h2>
<ul>
  <li><strong>User registration and login</strong><br>
    Patients, doctors, and admins can create accounts and log in with their respective roles.
  </li>

  <li><strong>Patient management</strong><br>
    Patients can view and update their profiles and see their appointment history and medical records.
  </li>

  <li><strong>Doctor management</strong><br>
    Doctors have profiles that show their specialty, availability, and upcoming appointments.
  </li>

  <li><strong>Appointments</strong><br>
    Patients can request appointments based on doctor availability. Doctors can approve or view scheduled appointments. 
    Admins can assign, cancel, or manage appointments when necessary.
  </li>

  <li><strong>Medical records</strong><br>
    Doctors can add notes and summaries after each consultation. Patients can view their own records, but not edit them.
  </li>

  <li><strong>Role-based access</strong><br>
    Each user has access only to what their role allows (e.g., patients can’t edit doctor info, and doctors can’t 
    access unrelated patient data).
  </li>
</ul>

<p>
  The focus is to keep the system simple but practical, showing how a real-world healthcare environment can be 
  represented using OOP in a clean and structured way.
</p>

