# Oop_Modeling_Group_11
<!DOCTYPE html>
<html>
<head>
  <title>Group Members and Individual Domains</title>
</head>
<body>

  <h2>Group Members & Individual Domains</h2>

  <table border="1" cellpadding="8" cellspacing="0">
    <tr>
      <th>Name</th>
      <th>Username</th>
      <th>Individual Domain</th>
    </tr>
    <tr>
      <td>Abdulkerim Kedir</td>
      <td>abdu21k</td>
      <td>Domain 4: Vehicle Rental System</td>
    </tr>
    <tr>
      <td>Mihrer Belete</td>
      <td>mercymera</td>
      <td>Domain 5: Online Food Delivery System</td>
    </tr>
    <tr>
      <td>Firew Kasa</td>
      <td>frew094991</td>
      <td>Pending</td>
    </tr>
    <tr>
      <td>Mastewal Ayano</td>
      <td>mayaye1</td>
      <td>Domain 8: Inventory Management System</td>
    </tr>
    <tr>
      <td>Dagmawi Teferi</td>
      <td>dadu1161</td>
      <td>Domain 10: Real Estate Listing Platform</td>
    </tr>
  </table>

</body>
</html>



3. Modeling Inventory Transactions and Movement

What we are  Doing in This Part of the Project:

In this section, we are focusing on how to track every product movement in the inventory system. That means we need to figure out how the system will handle all the different kinds of actions like when we:

Buy new stock from a supplier

Sell products to customers

Move products from one location to another (e.g., warehouse to store)

Fix errors (like damaged or missing items)


The goal is to make sure that the system always knows where products are and how many are left, in real-time.


---

Plan / Structure:

1. Understand the Types of Transactions

First, we will list out all the types of inventory movements the system will handle. 

Purchase Order – when we get new items from a supplier.

Sales Order – when items are sold to customers.

Stock Transfer – moving items between different storage locations.

Stock Adjustment – if items get damaged, stolen, or there's a mistake.


2. Decide What Info to Store

Each transaction should record the following:

What happened (purchase, sale, etc.)

Which product and how many

When it happened (date/time)

Where it happened (which location)

Why (optional – like reason for adjustment)


3. Build the Logic to Record Movements

Now we need to think: how will the system actually update stock?

Example:

If 50 items come in from a supplier, I need to increase stock at the receiving location.

If 10 items are sold, the system should reduce stock at the selling location.

If 20 items are moved from Warehouse A to Store B, it should subtract from A and add to B.


4. Handle Errors and Real-Life Situations

Stuff happens. We will  plan for things like:

Someone tries to sell more than we have → show error

A product is perishable → track expiry date

Someone accidentally enters the wrong number → allow adjustments


5. Think About System Integration

If this inventory system is connected to other systems like:

POS (Point of Sale)
Procurement software

Then we need to make sure it updates stock immediately when things are sold or ordered.

How we will Do It

1. Create sample data:
Products
Locations
Starting stock levels

2. Design tables or classes to represent:
Transactions
Products
Locations
Stock levels
3. Write basic logic (or pseudocode) for:
Adding a purchase order
Recording a sale
Moving stock
Adjusting stock
4. Test it out:
Simulate a few transactions (e.g., purchase 100 chairs, sell 20, transfer 30)

Check if stock levels are correct after each one



Healthcare Management System

What we are Doing in This Project:

In this project, we will try to building a Healthcare Management System that helps hospitals or clinics manage patient records, appointments, doctors, and treatments. The main goal is to make it easier to organize healthcare data, so things like booking appointments, storing patient history, and assigning doctors are handled properly and efficiently.


My Plan / Structure:

1. What Features the System Needs

Here are the core things I want the system to do:

Register and manage patients

Register doctors and their specialties

Book, view, and manage appointments

Record treatments or diagnoses

Track medication prescribed to patients

Optional: billing and payment tracking

2. Main Entities I Need

we will design tables or classes for:

Patient: patient ID, name, age, gender, contact info, medical history

Doctor: doctor ID, name, department/specialty, contact info

Appointment: appointment ID, patient ID, doctor ID, date/time, reason

Treatment Record: treatment ID, patient ID, doctor ID, diagnosis, prescription, date

(Optional) Billing: billing ID, patient ID, service given, total cost, payment status


Logic flow

1. Patient Registration:

Add new patient to the system

Store basic details and any existing medical info


2. Doctor Registration:

Add doctors with their specialties (e.g., Cardiology, Pediatrics)

Store contact and working hours if needed


3. Appointment Booking:

A patient can request an appointment with a specific doctor

System checks doctor availability

Appointment is saved with date, time, and purpose



4. Managing Treatments:

After appointment, doctor updates patient's record with diagnosis and treatment

If medicine is prescribed, system saves that info too



5. Viewing Patient Records:

Admin or doctor can view full medical history for any patient

Useful for ongoing or repeat visits



6. (Optional) Billing and Payments:

Track the cost of treatments or consultations

Mark payments as paid/unpaid
---

How we wll Build It (Step-by-Step Tasks):

1. Create data structures / tables:

Patient

Doctor

Appointment

Treatment

(Optional) Billing

2. Create basic functions or pages:

Add / edit / delete patients and doctors

Book appointments

View appointments by date or doctor

Record treatments after appointments

View patient medical history

3. Add logic for validations:

Prevent double-booking doctors

Ensure appointment date/time is valid

Validate required fields (e.g., no blank names)

4. Test the system:

Register a few patients and doctors

Book and view appointments

Simulate treatments and view record
Extra Features (if I finish early):

Allow search by patient name or ID

Add login system for doctors/admins

Generate printable reports (appointments, medical history)

Notify about upcoming appointments





Smart Home Automation
System

What we are  Doing in This Project:

In this project, we will try to build a Smart Home Automation System that allows users to control and monitor home devices (like lights, fans, security cameras, etc.) using software. The goal is to make the home smarter, more comfortable, and more secure — all controllable from one system.

This project is great for combining hardware and software concepts, or simulating them using code (if hardware isn’t used).


---

Our Plan / Structure:

1. Features I Want to Include

Here’s what the system should be able to do:

Turn devices (lights, fans, etc.) ON and OFF remotely

Schedule actions (e.g., turn on lights at 6 PM)

Monitor sensors (e.g., temperature, motion)

Alert users about unusual activity (e.g., motion detected at night)

Optional: Control via mobile/web app interface


2. Key Components (Entities or Modules)

Device: device ID, type (light, fan, etc.), location (bedroom, living room), status (on/off)

Sensor: sensor ID, type (temperature, motion, smoke), location, reading value

User Control Panel: allows the user to turn things on/off or view status

Automation Rule: defines conditions (e.g., if time is 7 AM → turn on lights)

Alerts/Notifications: stores or sends alerts to the user when needed

--- (Logic Flow):

1. Device Registration:

Each smart device is added with a name, type, and location

Status (on/off) is tracked


2. User Control Panel:

From the panel (or app), the user can:

See current device status

Turn any device on or off

Set schedules or automation rules


3. Automation Engine:

The system checks rules:

“If time = 10 PM → turn off living room lights”

“If motion detected in hallway → send alert”


4. Sensor Monitoring (if simulated):

System reads data from sensors (e.g., motion = true)

Triggers actions (e.g., turn on lights or send notification)


5. Alerts & Logs:

System records what happened and when (e.g., "Fan turned on at 2:00 PM")

Sends alerts for motion detection, smoke, etc



How I’ll Build It (Step-by-Step Plan):

1. Design device and sensor data structure:

Device: ID, type, location, status

Sensor: ID, type, value, location

AutomationRule: condition, action


2. Create control functions:

Turn device on/off

Read/update sensor values

Check and apply automation rules


3. Simulate devices/sensors (if hardware not available):

Use simple functions or input values to mimic real-world activity

Example: simulate temperature going up, or motion detected at night


4. Create user interface (basic CLI or GUI):

View device status

Control devices

Set automation rules


5. Testing the system:

Simulate turning lights/fans on and off

Test a scheduled rule (e.g., turn on fan at 1 PM)

Trigger alerts based on fake sensor data

--
Extra Features 



Use real-time clock for scheduling





