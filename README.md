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

3. Design tables or classes to represent:
Transactions
Products
Locations
Stock levels
4. Write basic logic (or pseudocode) for:
Adding a purchase order
Recording a sale
Moving stock
Adjusting stock
5. Test it out:
Simulate a few transactions (e.g., purchase 100 chairs, sell 20, transfer 30)

Check if stock levels are correct after each one
















Abdulkerim Kedir 
Vehicle Rental System

What I'm Doing in This Project:

In this project, I’m building a Vehicle Rental System that allows users (like customers or staff) to rent and return vehicles, track availability, and manage rental records. Think of it like a simplified version of how car rental services (e.g., Hertz or local rental shops) work.

The main focus is to make sure the right vehicle is available, booked by the customer, and properly updated when returned.


My Plan / Structure:

1. Understand the Core Features I Need

Here’s what the system must do at a minimum:

Add and manage vehicles (cars, bikes, vans, etc.)

Register customers

Allow customers to rent available vehicles

Track which vehicle is rented and by whom

Handle returns and update vehicle status

Calculate rental cost based on time/days

Optional: generate receipts or reports

2. Identify the Main Entities

I’ll need to design tables or classes for:

Vehicle: vehicle ID, type, brand, model, plate number, status (available/rented), price per hour/day

Customer: customer ID, name, license number, contact info

Rental Transaction: rental ID, vehicle ID, customer ID, rent date/time, return date/time, total cost, status



How the System Should Work (Logic Plan):

1. Add Vehicle:

Admin adds vehicles to the system

Sets rental price and availability status

2. Register Customer:

New customers are added to the system with details

Existing customers can be searched by ID/license number

3. Rent a Vehicle:

System checks for available vehicles

Customer selects one and sets rental period

System updates vehicle status to "rented"

Saves transaction record with date and time

4. Return a Vehicle:

On return, system calculates total duration

Uses pricing to calculate the bill

Updates vehicle status back to "available"

Closes the rental transaction


5. Track & View Rentals:

Admin or user can view current rentals, completed rentals, or available vehicles



How I’ll Build It (My Step-by-Step To-Do List):

1. Create data structures or tables:

Vehicle (info + availability)

Customer (info)

RentalTransaction (records rentals)


2. Create functions / forms for:

Adding/editing vehicles

Registering customers

Renting a vehicle (check availability, create transaction)

Returning a vehicle (calculate cost, update status)

Viewing records


3. Handle validations:

Don’t allow double-booking the same vehicle

Don’t allow renting if customer or vehicle data is missing

Validate date inputs and costs


4. Testing:

Try renting and returning multiple vehicles

Check if the system updates availability correctly

Make sure cost calculation works for different time periods
---

Extra Features (if I have time):

Allow filtering vehicles by type (car, van, etc.)

Add login roles (Admin vs Customer)

Generate PDF receipt or report of rentals

Alert if vehicle is overdue for return
