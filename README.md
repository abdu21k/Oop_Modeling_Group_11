# Oop_Modeling_Group_11
 Abdulkerim Kedir abdu21k
 Mihrer Belete  Mercymera
Firew kasa   frew094991
Mastewal Ayano   mayaye1   
Dagmawi Teferi    dadu1161
Title

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



