<h1>Domain 6: Healthcare Management System</h1>

<h2>Question</h2>
<p>
  In this project, we are designing a Healthcare Management System using object-oriented programming. 
  The main idea is to model the basic operations that happen in a healthcare setting — like in a clinic or hospital — where 
  patients need treatment, doctors need to manage appointments, and admins oversee the whole system.
</p>

<p>
  The system will have three main user roles: <strong>Patients</strong>, <strong>Doctors</strong>, and <strong>Admins</strong>. 
  Patients should be able to register, log in, and book appointments with doctors based on their specialization and available time slots. 
  Each patient will also have a medical record that includes their visit history and any notes from previous consultations.
</p>

<p>
  Doctors will manage their own schedules, view their upcoming appointments, and access the medical records of the patients they’re treating. 
  After each visit, they should be able to add new information to a patient’s file, like diagnosis notes or treatment suggestions.
</p>

<p>
  Admins will have a broader view of the system. They’ll manage both doctors and patients, assign roles, organize schedules, 
  and ensure that everything runs smoothly from behind the scenes.
</p>

<p>
  The goal is to create a structured and realistic system using OOP principles like encapsulation, inheritance, and association. 
  The relationships between patients, doctors, appointments, and records should be clear and well-defined. 
  This system is not about building a full web application, but about showing how the objects interact, and how a real-life scenario 
  can be represented in code using clean and logical design.
</p>

<h2>Scope</h2>

<p>
  The system will focus on the following key features:
</p>

<ul>
  <li><strong>User Registration & Login:</strong> All users (patients, doctors, and admins) can create accounts and log in securely.</li>
  
  <li><strong>Patient Features:</strong> Patients can update their personal info, view doctors by specialization, book appointments, 
      and check their past visit history.</li>

  <li><strong>Doctor Features:</strong> Doctors can set their available time slots, view assigned appointments, 
      and access or update patient medical records after each consultation.</li>

  <li><strong>Appointment Management:</strong> Patients can request appointments with available doctors. 
      The system ensures that appointment times do not overlap, and admins or doctors can approve, reschedule, or cancel them if needed.</li>

  <li><strong>Medical Records:</strong> Each patient has a record linked to their appointments. 
      Doctors can add notes after visits, while patients can only view their own records.</li>

  <li><strong>Admin Control:</strong> Admins manage the overall system, including assigning doctors, updating availability, 
      handling user roles, and monitoring appointment activity.</li>

  <li><strong>Role-Based Access:</strong> Each user type only has access to what they need. 
      Patients can't see other patients' data, doctors can't edit admin functions, and so on.</li>
</ul>

<p>
  The scope is limited to essential healthcare features like patient management, scheduling, and record-keeping. 
  More advanced modules like billing, prescription handling, or lab integration are outside this version’s focus but can be added later 
  if the system is designed to be extendable.
</p>
