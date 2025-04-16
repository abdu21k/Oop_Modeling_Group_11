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
